package cengcelil.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

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
    String data_3=null;
    String data_4=null;
    String data_5=null;

    Connection connection;
    int count,scount;
    public static final String SERVER_NAME="192.168.1.102";
    public static final String DATABASE_NAME="Datakent";
    public static final String USER_NAME="DELL";
    public static final String PASS_WORD="dell";
    boolean check=true;
    static String k1,k2,k3,k4,k5,k6;
    Context context;
    public MSSQL_Adapter(String data_h,boolean c,Context context) {
        this.data_h = data_h;
        count=1;
        if(!c)
            create();
        this.context=context;

    }
    public MSSQL_Adapter(String data_h, String data_1,boolean c,Context context) {
        this.data_h = data_h;
        this.data_1 = data_1;
        count=2;
        if(!c)
            create();
        this.context=context;

    }
    public MSSQL_Adapter(String data_h, String data_1, String data_2,boolean c,Context context) {
        this.data_h = data_h;
        this.data_1 = data_1;
        this.data_2 = data_2;
        count=3;
        if(!c)
            create();
        this.context=context;

    }
    public MSSQL_Adapter(String data_h, String data_1, String data_2, String data_3,boolean c,Context context) {
        this.data_h = data_h;
        this.data_1 = data_1;
        this.data_2 = data_2;
        this.data_3 = data_3;
        count=4;
        if(!c)
            create();
        this.context=context;

    }
    public MSSQL_Adapter(String data_h, String data_1, String data_2, String data_3,String data_4,boolean c,Context context) {
        this.data_h = data_h;
        this.data_1 = data_1;
        this.data_2 = data_2;
        this.data_3 = data_3;
        this.data_4 = data_4;
        count=5;
        if(!c)
            create();
        this.context=context;

    }
    public MSSQL_Adapter(String data_h, String data_1, String data_2, String data_3,String data_4,String data_5,boolean c,Context context) {
        this.data_h = data_h;
        this.data_1 = data_1;
        this.data_2 = data_2;
        this.data_3 = data_3;
        this.data_4 = data_4;
        this.data_5 = data_5;
        count=6;
        if(!c)
            create();
        this.context=context;

    }

    public void create() {
        connection=Baglanti(USER_NAME,PASS_WORD,DATABASE_NAME,SERVER_NAME);
        String query = null;
        if (count == 1) {
            query="CREATE TABLE [dbo].[Data] ([data_id] INT  IDENTITY (1, 1) NOT NULL,["+data_h+"] TEXT NULL,[kontrol] TEXT NULL,[add_time] TEXT NULL,CONSTRAINT [PK_Data] PRIMARY KEY CLUSTERED ([data_id] ASC))";

        } else if (count == 2) {
            query="CREATE TABLE [dbo].[Data] ([data_id] INT  IDENTITY (1, 1) NOT NULL,["+data_h+"] TEXT NULL,[" + data_1 + "] TEXT NULL,[kontrol] TEXT NULL,[add_time] TEXT NULL,CONSTRAINT [PK_Data] PRIMARY KEY CLUSTERED ([data_id] ASC))";

        }
        else if (count == 3) {
            query="CREATE TABLE [dbo].[Data] ([data_id] INT  IDENTITY (1, 1) NOT NULL,["+data_h+"] TEXT NULL,[" + data_1 + "] TEXT NULL,[" + data_2 + "] TEXT NULL,[kontrol] TEXT NULL,[add_time] TEXT NULL,CONSTRAINT [PK_Data] PRIMARY KEY CLUSTERED ([data_id] ASC))";

        } else if (count == 4) {

            query="CREATE TABLE [dbo].[Data] ([data_id] INT  IDENTITY (1, 1) NOT NULL,["+data_h+"] TEXT NULL,[" + data_1 + "] TEXT NULL,[" + data_2 + "] TEXT NULL,[" + data_3 + "] TEXT NULL,[kontrol] TEXT NULL,[add_time] TEXT NULL,CONSTRAINT [PK_Data] PRIMARY KEY CLUSTERED ([data_id] ASC))";

        } else if (count == 5) {

            query="CREATE TABLE [dbo].[Data] ([data_id] INT  IDENTITY (1, 1) NOT NULL,["+data_h+"] TEXT NULL,[" + data_1 + "] TEXT NULL,[" + data_2 + "] TEXT NULL,[" + data_3 + "] TEXT NULL,[" + data_4 + "] TEXT NULL,[kontrol] TEXT NULL,[add_time] TEXT NULL,CONSTRAINT [PK_Data] PRIMARY KEY CLUSTERED ([data_id] ASC))";

        } else if (count == 6) {

            query = "CREATE TABLE [dbo].[Data] ([data_id] INT  IDENTITY (1, 1) NOT NULL,[" + data_h + "] TEXT NULL,[" + data_1 + "] TEXT NULL,[" + data_2 + "] TEXT NULL,[" + data_3 + "] TEXT NULL,[" + data_4 + "] TEXT NULL,[" + data_5 + "] TEXT NULL,[kontrol] TEXT NULL,[add_time] TEXT NULL,CONSTRAINT [PK_Data] PRIMARY KEY CLUSTERED ([data_id] ASC))";
        }
        Statement statement= null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            if(resultSet.next()){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        check = false;
    }

    @Override
    protected String doInBackground(String... strings) { //middle
        String mesaj;
        connection=Baglanti(USER_NAME,PASS_WORD,DATABASE_NAME,SERVER_NAME);
        if(context!=null){
            SharedPreferences sharedPreferences = context.getSharedPreferences("key", Context.MODE_PRIVATE);
            scount=sharedPreferences.getInt("key_count",0);
            if(scount==0)
            {
                k1=sharedPreferences.getString("key_table1","0");

            }
            else if(scount==1)
            {
                k1=sharedPreferences.getString("key_table1","0");
                k2=sharedPreferences.getString("key_table2","0");


            }
            else if(scount==2)
            {
                k1=sharedPreferences.getString("key_table1","0");
                k2=sharedPreferences.getString("key_table2","0");
                k3=sharedPreferences.getString("key_table3","0");

            }
            else if(scount==3)
            {
                k1=sharedPreferences.getString("key_table1","0");
                k2=sharedPreferences.getString("key_table2","0");
                k3=sharedPreferences.getString("key_table3","0");
                k4=sharedPreferences.getString("key_table4","0");

            }
            else if(scount==4)
            {
                k1=sharedPreferences.getString("key_table1","0");
                k2=sharedPreferences.getString("key_table2","0");
                k3=sharedPreferences.getString("key_table3","0");
                k4=sharedPreferences.getString("key_table4","0");
                k5=sharedPreferences.getString("key_table5","0");

            }
            else if(scount==5)
            {
                k1=sharedPreferences.getString("key_table1","0");
                k2=sharedPreferences.getString("key_table2","0");
                k3=sharedPreferences.getString("key_table3","0");
                k4=sharedPreferences.getString("key_table4","0");
                k5=sharedPreferences.getString("key_table5","0");
                k6=sharedPreferences.getString("key_table6","0");

            }
        }
        if(connection==null || check ==false)
        {
            mesaj="sıkıntı";
        }
        else
        {
            String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
            String query=null;
            if(count==1)
                 query="INSERT INTO [dbo].[Data] (["+k1+"],[kontrol],[add_time]) VALUES('"+data_h+"','not checked','" +currentDateTimeString+"');";
            else if(count==2)
                query="INSERT INTO [dbo].[Data] (["+k1+"],["+k2+"],[kontrol],[add_time]) VALUES('"+data_h+"','"+data_1+"','not checked','" +currentDateTimeString+"');";
            else if(count==3)
                query="INSERT INTO [dbo].[Data] (["+k1+"],["+k2+"],["+k3+"],[kontrol],[add_time]) VALUES('"+data_h+"','"+data_1+"','"+data_2+"','not checked','" +currentDateTimeString+"');";
            else if(count==4)
                query="INSERT INTO [dbo].[Data] (["+k1+"],["+k2+"],["+k3+"],["+k4+"],[kontrol],[add_time]) VALUES('"+data_h+"','"+data_1+"','"+data_2+"','"+data_3
                        +"','not checked','" +currentDateTimeString+"');";
            else if(count==5)
                query="INSERT INTO [dbo].[Data] (["+k1+"],["+k2+"],["+k3+"],["+k4+"],["+k5+"],[kontrol],[add_time]) VALUES('"+data_h+"','"+data_1+"','"+data_2+"','"+data_3
                        +"','"+data_4+"','not checked','" +currentDateTimeString+"');";
            else if(count==6)
                query="INSERT INTO [dbo].[Data] (["+k1+"],["+k2+"],["+k3+"],["+k4+"],["+k5+"],["+k6+"],[kontrol],[add_time]) VALUES('"+data_h+"','"+data_1+"','"+data_2+"','"+data_3
                        +"','"+data_4+"','"+data_5+"','not checked','" +currentDateTimeString+"');";

            try {
                Statement statement=connection.createStatement();
                boolean resultSet=statement.execute(query);
                if(resultSet){
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
