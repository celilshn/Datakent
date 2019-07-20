package cengcelil.Adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
public class MSSQL_Adapter extends AsyncTask<String,String,String> {

    boolean success=false;
    String data_h;
    String data_1=null;
    String data_2=null;
    Connection connection;
    public static final String SERVER_NAME="192.168.1.102:1433";
    public static final String DATABASE_NAME="Datakent";
    public static final String USER_NAME="DELL";
    public static final String PASS_WORD="dell";

    public MSSQL_Adapter(String data_h) {
        this.data_h = data_h;

    }
    public MSSQL_Adapter(String data_h, String data_1) {
        this.data_h = data_h;
        this.data_1 = data_1;


    }
    public MSSQL_Adapter(String data_h, String data_1, String data_2) {
        this.data_h = data_h;
        this.data_1 = data_1;
        this.data_2 = data_2;

    }
    public MSSQL_Adapter(String data_h, String data_1, String data_2, String data_3) {
        this.data_h = data_h;
        this.data_1 = data_1;
        this.data_2 = data_2;
        this.data_3 = data_3;

    }

    String data_3=null;
    @Override
    protected String doInBackground(String... strings) { //middle
        String mesaj;
        connection=Baglanti(USER_NAME,PASS_WORD,DATABASE_NAME,SERVER_NAME);
        if(connection==null)
        {
            mesaj="sıkıntı";
        }
        else
        {
            String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
            String query="INSERT INTO [dbo].[table_1] ([kolon_1],[kolon_2],[kolon_3],[kolon_4],[kontrol],[add_time]) VALUES('"+data_h+"','"+data_1+"','"+data_2+"','"+data_3
                    +"','not checked','" +currentDateTimeString+"');";
            try {
                Statement statement=connection.createStatement();
                ResultSet resultSet=statement.executeQuery(query);
                if(resultSet.next()){
                    mesaj="başarılı";
                    success=true;
                    connection.close();
                }
                else{
                    mesaj="sıkıntı";
                    success=false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return null;
    }
    @Override
    protected void onPreExecute() {
        //PROGRESS BAR FALAN FİLAN
    } // start
    @Override
    protected void onPostExecute(String r) {
        //if(success)
           //basarılı
    } //end

    public Connection Baglanti(String user,String password,String database,String server){
        StrictMode.ThreadPolicy policy=new  StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection=null;
        String connection_URL;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connection_URL="jdbc:jtds:sqlserver://"+server+";databaseName="+database;
            connection= DriverManager.getConnection(connection_URL,user
            ,password);
        }
        catch (ClassNotFoundException e) {
            Log.e("error1",e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e("error2",e.getMessage());

        }
        return connection;
    }

}
