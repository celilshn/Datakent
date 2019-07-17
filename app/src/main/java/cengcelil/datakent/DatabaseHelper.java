package cengcelil.datakent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import cengcelil.Model.Datalar;

public class DatabaseHelper extends SQLiteOpenHelper {
    public SQLiteDatabase db=this.getReadableDatabase();
    private ContentValues contentValues=new ContentValues(),contentValues_=new ContentValues();
    String table_1,table_2,table_3,table_4;
    int count;
    boolean check;
    String s_data_h;
    public DatabaseHelper(Context context,String table_1,int a) {
        super(context, "datakent.db", null, 1);
        this.table_1=table_1;
        if(check)
            create();

    }

    public DatabaseHelper(Context context,String table_1) {
        super(context, "datakent.db", null, 1);
        this.table_1=table_1;
        count=1;
        if(check)
            create();

    }
    public DatabaseHelper(Context context,String table_1,String table_2) {
        super(context, "datakent.db", null, 1);
        this.table_1=table_1;
        this.table_2=table_2;
        count=2;
        if(check)
            create();

    }
    public DatabaseHelper(Context context,String table_1,String table_2,String table_3) {
        super(context, "datakent.db", null, 1);
        this.table_1=table_1;
        this.table_2=table_2;
        this.table_3=table_3;
        count=3;
        if(check)
            create();

    }
    public DatabaseHelper(Context context,String table_1,String table_2,String table_3,String table_4) {
        super(context, "datakent.db", null, 1);
        this.table_1=table_1;
        this.table_2=table_2;
        this.table_3=table_3;
        this.table_4=table_4;
        count=4;
        if(check)
            create();
    }


    public void create(){
        if(count==1) {
            db.execSQL("CREATE TABLE Data (data_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT,onay INTEGER)");
            db.execSQL("CREATE TABLE Data_log (log_id INTEGER PRIMARY KEY AUTOINCREMENT,data_id INTEGER," + table_1 + " TEXT,log TEXT,date TEXT)");
        }
        else if(count==2) {
                db.execSQL("CREATE TABLE Data (data_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT," + table_2 + " TEXT,onay INTEGER)");
                db.execSQL("CREATE TABLE Data_log (log_id INTEGER PRIMARY KEY AUTOINCREMENT,data_id INTEGER," + table_1 + " TEXT,log TEXT,date TEXT)");
            }
        else if(count==3) {
                    db.execSQL("CREATE TABLE Data (data_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT," + table_2 + " TEXT," + table_3 + " TEXT,onay INTEGER)");
                    db.execSQL("CREATE TABLE Data_log (log_id INTEGER PRIMARY KEY AUTOINCREMENT,data_id INTEGER," + table_1 + " TEXT,log TEXT,date TEXT)");
                }
        else if(count==4) {
                        db.execSQL("CREATE TABLE Data (data_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT," + table_2 + " TEXT," + table_3 + " TEXT," + table_4 + " TEXT,onay INTEGER)");
                        db.execSQL("CREATE TABLE Data_log (log_id INTEGER PRIMARY KEY AUTOINCREMENT,data_id INTEGER," + table_1 + " TEXT,log TEXT,date TEXT)");
                    }
        check = false;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
       check=true;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS Data");
            db.execSQL("DROP TABLE IF EXISTS Data_log");
            onCreate(db);
    }

    public boolean insertData(String datah,int onay){
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        contentValues.put(table_1,datah);
        contentValues.put("onay",onay);
        check_timer(onay);
        contentValues_.put(table_1,datah);
        contentValues_.put("log","ekleme");
        contentValues_.put("date",currentDateTimeString);
        long result_=db.insert("Data_log",null,contentValues_);
        long result=db.insert("Data",null,contentValues);
        if(result == -1 && result_==-1)
            return false;
        else
            return true;
    }
    public void check_timer(int onay){
        if(onay==0)
        {
            Timer timer;


            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    Handler handler = new Handler();

                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                }
            };

            timer = new Timer();

            timer.schedule(timerTask,10000,30000);
        }

    }
    public boolean insertData(String datah,String data1,int onay){
       this.s_data_h=datah;
        contentValues.put(table_1,datah);
        contentValues.put(table_2,data1);
        contentValues.put("onay",onay);
        contentValues_.put(table_1,datah);
        contentValues_.put("log","ekleme");
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        contentValues_.put("date",currentDateTimeString);
        long result_=db.insert("Data_log",null,contentValues_);

        long result=db.insert("Data",null,contentValues);
        if(result == -1 && result_==-1)
            return false;
        else
            return true;
    }
    public boolean insertData(String datah,String data1,String data2,int onay){
        contentValues.put(table_1,datah);
        contentValues.put(table_2,data1);
        contentValues.put(table_3,data2);
        contentValues.put("onay",onay);
        contentValues_.put(table_1,datah);
        contentValues_.put("log","ekleme");
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        contentValues_.put("date",currentDateTimeString);
        this.s_data_h=datah;

        long result_=db.insert("Data_log",null,contentValues_);

        long result=db.insert("Data",null,contentValues);
        if(result == -1 && result_==-1)
            return false;
        else
            return true;
    }

    public boolean insertData(String datah,String data1,String data2,String data3,int onay){
        contentValues.put(table_1,datah);
        contentValues.put(table_2,data1);
        contentValues.put(table_3,data2);
        contentValues.put(table_4,data3);
        contentValues.put("onay",onay);
        contentValues_.put(table_1,datah);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        contentValues_.put("date",currentDateTimeString);
        contentValues_.put("log","ekleme");
        this.s_data_h=datah;

        long result_=db.insert("Data_log",null,contentValues_);

        long result=db.insert("Data",null,contentValues);
        if(result == -1 && result_==-1)
            return false;
        else
            return true;
    }
    public void deleteData(String id) {
        db.delete("Data", "data_id = ?", new String[]{id});
        contentValues_.put("log", "silme");
        contentValues_.put(table_1, s_data_h);
        contentValues_.put("data_id",id);

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        contentValues_.put("date",currentDateTimeString);
        db.insert("Data_log",null,contentValues_);


    }
    public ArrayList<Datalar> getAll_log() {
        ArrayList<Datalar>arrayList =new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor =db.rawQuery(("SELECT * FROM Data_log"),null);
        while(cursor.moveToNext()){
            String log_id=cursor.getString(0);
            String data_id=cursor.getString(1);
            String datah=cursor.getString(2);
            String log=cursor.getString(3);
            String date=cursor.getString(4);
            Datalar datalar=new Datalar(log_id,data_id,datah,log,date);
            arrayList.add(datalar);
        }
        return arrayList;
    }

    public ArrayList<Datalar> getAllData_b1() {
        ArrayList<Datalar>arrayList =new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor =db.rawQuery(("SELECT * FROM Data"),null);
        while(cursor.moveToNext()){
            int onay = 0;
            String data_id=cursor.getString(0);
            String datah=cursor.getString(1);
            if(count==1)
            {
                onay=Integer.valueOf(cursor.getString(2));

            }
            else if(count==2)
            {
                onay=Integer.valueOf(cursor.getString(3));
            }
            else if(count==3)
            {
                onay=Integer.valueOf(cursor.getString(4));

            }
            else if(count==4)
            {
                onay=Integer.valueOf(cursor.getString(5));

            }
            Datalar datalar=new Datalar(data_id,datah,onay);
            arrayList.add(datalar);
        }
        return arrayList;
    }
    public ArrayList<Datalar> getAllData_b2() {
    ArrayList<Datalar>arrayList =new ArrayList<>();
    SQLiteDatabase db=this.getReadableDatabase();
    Cursor cursor =db.rawQuery(("SELECT * FROM Data"),null);
        while(cursor.moveToNext()){
            if(count==1){
                String data_id=cursor.getString(0);
                String datah=cursor.getString(1);
                int onay=Integer.valueOf(cursor.getString(2));
                Datalar datalar=new Datalar(data_id,datah,onay);
                arrayList.add(datalar);
            }
            else if(count==2){
                String data_id=cursor.getString(0);
                String datah=cursor.getString(1);
                String data1=cursor.getString(2);
                int onay=Integer.valueOf(cursor.getString(3));
                Datalar datalar=new Datalar(data_id,datah,data1,onay);
                arrayList.add(datalar);
            }
            else if(count==3){
                String data_id=cursor.getString(0);
                String datah=cursor.getString(1);
                String data1=cursor.getString(2);
                String data2=cursor.getString(3);
                int onay=Integer.valueOf(cursor.getString(4));
                Datalar datalar=new Datalar(data_id,datah,data1,data2,onay);
                arrayList.add(datalar);
            }
            else if (count==4){
                String data_id=cursor.getString(0);
                String datah=cursor.getString(1);
                String data1=cursor.getString(2);
                String data2=cursor.getString(3);
                String data3=cursor.getString(4);
                int onay=Integer.valueOf(cursor.getString(5));
                Datalar datalar=new Datalar(data_id,datah,data1,data2,data3,onay);
                arrayList.add(datalar);
            }

        }
    return arrayList;
    }
    public ArrayList<Datalar> getAllData_b3() {
        ArrayList<Datalar>arrayList =new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor =db.rawQuery(("SELECT * FROM Data WHERE onay = 1"),null);
        while(cursor.moveToNext()){
            if(count==1){
                String data_id=cursor.getString(0);
                String datah=cursor.getString(1);
                int onay=Integer.valueOf(cursor.getString(2));
                Datalar datalar=new Datalar(data_id,datah,onay);
                arrayList.add(datalar);
            }
            else if(count==2){
                String data_id=cursor.getString(0);
                String datah=cursor.getString(1);
                String data1=cursor.getString(2);
                int onay=Integer.valueOf(cursor.getString(3));
                Datalar datalar=new Datalar(data_id,datah,data1,onay);
                arrayList.add(datalar);
            }
            else if(count==3){
                String data_id=cursor.getString(0);
                String datah=cursor.getString(1);
                String data1=cursor.getString(2);
                String data2=cursor.getString(3);
                int onay=Integer.valueOf(cursor.getString(4));
                Datalar datalar=new Datalar(data_id,datah,data1,data2,onay);
                arrayList.add(datalar);
            }
            else if (count==4){
                String data_id=cursor.getString(0);
                String datah=cursor.getString(1);
                String data1=cursor.getString(2);
                String data2=cursor.getString(3);
                String data3=cursor.getString(4);
                int onay=Integer.valueOf(cursor.getString(5));
                Datalar datalar=new Datalar(data_id,datah,data1,data2,data3,onay);
                arrayList.add(datalar);
            }

        }
        return arrayList;
    }
    public ArrayList<Datalar> getAllData_b4() {
        ArrayList<Datalar>arrayList =new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor =db.rawQuery(("SELECT * FROM Data WHERE onay = 0"),null);
        while(cursor.moveToNext()){
            if(count==1){
                String data_id=cursor.getString(0);
                String datah=cursor.getString(1);
                int onay=Integer.valueOf(cursor.getString(2));
                Datalar datalar=new Datalar(data_id,datah,onay);
                arrayList.add(datalar);
            }
            else if(count==2){
                String data_id=cursor.getString(0);
                String datah=cursor.getString(1);
                String data1=cursor.getString(2);
                int onay=Integer.valueOf(cursor.getString(3));
                Datalar datalar=new Datalar(data_id,datah,data1,onay);
                arrayList.add(datalar);
            }
            else if(count==3){
                String data_id=cursor.getString(0);
                String datah=cursor.getString(1);
                String data1=cursor.getString(2);
                String data2=cursor.getString(3);
                int onay=Integer.valueOf(cursor.getString(4));
                Datalar datalar=new Datalar(data_id,datah,data1,data2,onay);
                arrayList.add(datalar);
            }
            else if (count==4){
                String data_id=cursor.getString(0);
                String datah=cursor.getString(1);
                String data1=cursor.getString(2);
                String data2=cursor.getString(3);
                String data3=cursor.getString(4);
                int onay=Integer.valueOf(cursor.getString(5));
                Datalar datalar=new Datalar(data_id,datah,data1,data2,data3,onay);
                arrayList.add(datalar);
            }

        }
        return arrayList;
    }


    public boolean editOnay(String id,int onay){
        contentValues.put("onay",onay);
        contentValues_.put("log","onay duzenleme");
        contentValues_.put(table_1, s_data_h);
        contentValues_.put("data_id",id);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        contentValues_.put("date",currentDateTimeString);
        db.insert("Data_log",null,contentValues_);
        long result=db.update("Data",contentValues,"data_id = ?",new String[] {id});
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean editData(String datah,String id,int onay){
        contentValues.put(table_1,datah);
        contentValues.put("onay",onay);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        contentValues_.put("date",currentDateTimeString);
        contentValues_.put("log","duzenleme("+table_1+")");
        contentValues_.put(table_1, s_data_h);
        contentValues_.put("data_id",id);
        db.insert("Data_log",null,contentValues_);
        long result=db.update("Data",contentValues,"data_id = ?",new String[]{id});
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean editData(String datah,String data1,String id,int onay){
        contentValues.put(table_1,datah);
        contentValues.put(table_2,data1);
        contentValues.put("onay",onay);
        contentValues_.put("log","duzenleme("+table_1+","+table_2+")");
        contentValues_.put(table_1, datah);
        contentValues_.put("data_id",id);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        contentValues_.put("date",currentDateTimeString);
        db.insert("Data_log",null,contentValues_);
        long result=db.update("Data",contentValues,"data_id = ?",new String[]{id});
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean editData(String datah,String data1,String data2,String id,int onay){
        contentValues.put(table_1,datah);
        contentValues.put(table_2,data1);
        contentValues.put(table_3,data2);
        contentValues.put("onay",onay);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        contentValues_.put("date",currentDateTimeString);
        contentValues_.put("log","duzenleme("+table_1+","+table_2+","+table_3+")");
        contentValues_.put(table_1, datah);
        contentValues_.put("data_id",id);
        db.insert("Data_log",null,contentValues_);

        long result=db.update("Data",contentValues,"data_id = ?",new String[]{id});
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean editData(String datah,String data1,String data2,String data3,String id,int onay){
        contentValues.put(table_1,datah);
        contentValues.put(table_2,data1);
        contentValues.put(table_3,data2);
        contentValues.put(table_4,data3);
        contentValues.put("onay",onay);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        contentValues_.put("date",currentDateTimeString);
        contentValues_.put("log","duzenleme("+table_1+","+table_2+","+table_3+","+table_4+")");
        contentValues_.put(table_1, datah);
        contentValues_.put("data_id",id);
        db.insert("Data_log",null,contentValues_);

        long result=db.update("Data",contentValues,"data_id = ?",new String[]{id});
        if(result == -1)
            return false;
        else
            return true;
    }

}
