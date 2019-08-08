package cengcelil.datakent;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.CountDownTimer;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;


import cengcelil.Adapter.MSSQL_Adapter;
import cengcelil.Model.Datalar;

public class DatabaseHelper extends SQLiteOpenHelper {

    public SQLiteDatabase db = this.getReadableDatabase();
    private ContentValues contentValues = new ContentValues(), contentValues_ = new ContentValues();
    String table_1, table_2, table_3, table_4,table_5,table_6;
    int count;
    static boolean check;
    String s_data_h;
    Context context;
    static SharedPreferences mPreferences;

    public static void set_Check(Context context) {
        mPreferences = context.getSharedPreferences("check", Context.MODE_PRIVATE);
        check = mPreferences.getBoolean("check", true);
    }

    public DatabaseHelper(Context context, String table_1, String table_2, int a) {
        super(context, "datakent.db", null, 1);
        this.table_1 = table_1;
        this.table_2 = table_2;
        set_Check(context);
        if (check)
            create();
        this.context=context;

    }

    public DatabaseHelper(Context context, String table_1) {
        super(context, "datakent.db", null, 1);
        this.table_1 = table_1;
        count = 1;
        set_Check(context);
        if (check)
            create();
        this.context=context;

    }

    public DatabaseHelper(Context context, String table_1, String table_2) {
        super(context, "datakent.db", null, 1);
        this.table_1 = table_1;
        this.table_2 = table_2;
        count = 2;
        set_Check(context);
        if (check)
            create();
        this.context=context;

    }

    public DatabaseHelper(Context context, String table_1, String table_2, String table_3) {
        super(context, "datakent.db", null, 1);
        this.table_1 = table_1;
        this.table_2 = table_2;
        this.table_3 = table_3;
        count = 3;
        set_Check(context);
        if (check)
            create();
        this.context=context;

    }

    public DatabaseHelper(Context context, String table_1, String table_2, String table_3, String table_4) {
        super(context, "datakent.db", null, 1);
        this.table_1 = table_1;
        this.table_2 = table_2;
        this.table_3 = table_3;
        this.table_4 = table_4;
        count = 4;
        set_Check(context);
        if (check)
            create();
        this.context=context;

    }
    public DatabaseHelper(Context context, String table_1, String table_2, String table_3, String table_4,String table_5) {
        super(context, "datakent.db", null, 1);
        this.table_1 = table_1;
        this.table_2 = table_2;
        this.table_3 = table_3;
        this.table_4 = table_4;
        this.table_5 = table_5;
        count = 5;
        set_Check(context);
        if (check)
            create();
        this.context=context;

    }
    public DatabaseHelper(Context context, String table_1, String table_2, String table_3, String table_4,String table_5,String table_6) {
        super(context, "datakent.db", null, 1);
        this.table_1 = table_1;
        this.table_2 = table_2;
        this.table_3 = table_3;
        this.table_4 = table_4;
        this.table_5 = table_5;
        this.table_6 = table_6;
        count = 6;
        set_Check(context);
        if (check)
            create();
        this.context=context;

    }


    public void create() {
        db.execSQL("DROP TABLE IF EXISTS Data");
        db.execSQL("DROP TABLE IF EXISTS Data_log");
        if (count == 1) {
            db.execSQL("CREATE TABLE Data (data_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT,status TEXT,add_time TEXT)");
            db.execSQL("CREATE TABLE Data_log (log_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT," + table_2 + " TEXT,log TEXT,date TEXT)");
            MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(table_1,false,context);
            mssql_adapter.execute("");
        } else if (count == 2) {
            db.execSQL("CREATE TABLE Data (data_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT," + table_2 + " TEXT,status TEXT,add_time TEXT)");
            db.execSQL("CREATE TABLE Data_log (log_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT," + table_2 + " TEXT,log TEXT,date TEXT)");
            MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(table_1,table_2,false,context);
            mssql_adapter.execute("");
        } else if (count == 3) {
            db.execSQL("CREATE TABLE Data (data_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT," + table_2 + " TEXT," + table_3 + " TEXT,status TEXT,add_time TEXT)");
            db.execSQL("CREATE TABLE Data_log (log_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT," + table_2 + " TEXT,log TEXT,date TEXT)");
            MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(table_1,table_2,table_3,false,context);
            mssql_adapter.execute("");
        } else if (count == 4) {
            db.execSQL("CREATE TABLE Data (data_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT," + table_2 + " TEXT," + table_3 + " TEXT," + table_4 + " TEXT,status TEXT,add_time TEXT)");
            db.execSQL("CREATE TABLE Data_log (log_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT," + table_2 + " TEXT,log TEXT,date TEXT)");
            MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(table_1,table_2,table_3,table_4,false,context);
            mssql_adapter.execute("");
        } else if (count == 5) {
            db.execSQL("CREATE TABLE Data (data_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT," + table_2 + " TEXT," + table_3 + " TEXT," + table_4 + " TEXT,"+table_5+ " TEXT,status TEXT,add_time TEXT)");
            db.execSQL("CREATE TABLE Data_log (log_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT," + table_2 + " TEXT,log TEXT,date TEXT)");
            MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(table_1,table_2,table_3,table_4,table_5,false,context);
            mssql_adapter.execute("");
        } else if (count == 6) {
            db.execSQL("CREATE TABLE Data (data_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT," + table_2 + " TEXT," + table_3 + " TEXT," + table_4 + " TEXT,"+table_5+ " TEXT,"+table_6+ " TEXT,status TEXT,add_time TEXT)");
            db.execSQL("CREATE TABLE Data_log (log_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT," + table_2 + " TEXT,log TEXT,date TEXT)");
            MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(table_1,table_2,table_3,table_4,table_5,table_6,false,context);
            mssql_adapter.execute("");
        }
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putBoolean("check", false);
        editor.commit();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        check = true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Data");
        db.execSQL("DROP TABLE IF EXISTS Data_log");
        onCreate(db);
    }

    public boolean insertData(String datah, String status) {
        contentValues.put(table_1, datah);
        contentValues_.put(table_1, datah);
        contentValues_.put(table_2, "");
        insert_contentValues(status);
        long result_ = db.insert("Data_log", null, contentValues_);
        long result = db.insert("Data", null, contentValues);
        if(status.equals("gonderildi")){
            direct_send(datah);
        }
        else
            add_timer(datah);
        if (result == -1 && result_ == -1)
            return false;
        else
            return true;
    }

    public boolean insertData(String datah, String data1, String status) {
        this.s_data_h = datah;
        contentValues.put(table_1, datah);
        contentValues.put(table_2, data1);
        contentValues_.put(table_1, datah);
        contentValues_.put(table_2, data1);
        insert_contentValues(status);
        long result_ = db.insert("Data_log", null, contentValues_);

        long result = db.insert("Data", null, contentValues);
        if(status.equals("gonderildi")){
            direct_send(datah,data1);
        }
        else
            add_timer(datah,data1);
        if (result == -1 && result_ == -1)
            return false;
        else
            return true;
    }

    public boolean insertData(String datah, String data1, String data2, String status) {
        contentValues.put(table_1, datah);
        contentValues.put(table_2, data1);
        contentValues.put(table_3, data2);
        contentValues_.put(table_1, datah);
        contentValues_.put(table_2, data1);
        insert_contentValues(status);

        this.s_data_h = datah;

        long result_ = db.insert("Data_log", null, contentValues_);

        long result = db.insert("Data", null, contentValues);
        if(status.equals("gonderildi")){
            direct_send(datah,data1,data2);
        }
        else
            add_timer(datah,data1,data2);
        if (result == -1 && result_ == -1)
            return false;
        else
            return true;
    }

    public boolean insertData(String datah, String data1, String data2, String data3, String status) {
        contentValues.put(table_1, datah);
        contentValues.put(table_2, data1);
        contentValues.put(table_3, data2);
        contentValues.put(table_4, data3);
        contentValues_.put(table_1, datah);
        contentValues_.put(table_2, data1);
        insert_contentValues(status);
        this.s_data_h = datah;
        long result_ = db.insert("Data_log", null, contentValues_);
        long result = db.insert("Data", null, contentValues);
        if(status.equals("gonderildi")){
            direct_send(datah,data1,data2,data3);
        }
        else
            add_timer(datah,data1,data2,data3);
        if (result == -1 && result_ == -1)
            return false;
        else
            return true;
    }
    public boolean insertData(String datah, String data1, String data2, String data3, String data4, String status) {
        contentValues.put(table_1, datah);
        contentValues.put(table_2, data1);
        contentValues.put(table_3, data2);
        contentValues.put(table_4, data3);
        contentValues.put(table_5, data4);
        contentValues_.put(table_1, datah);
        contentValues_.put(table_2, data1);
        insert_contentValues(status);
        this.s_data_h = datah;
        long result_ = db.insert("Data_log", null, contentValues_);
        long result = db.insert("Data", null, contentValues);
        if(status.equals("gonderildi")){
            direct_send(datah,data1,data2,data3,data4);
        }
        else
            add_timer(datah,data1,data2,data3,data4);
        if (result == -1 && result_ == -1)
            return false;
        else
            return true;
    }
    public boolean insertData(String datah, String data1, String data2, String data3, String data4, String data5, String status) {
        contentValues.put(table_1, datah);
        contentValues.put(table_2, data1);
        contentValues.put(table_3, data2);
        contentValues.put(table_4, data3);
        contentValues.put(table_5, data4);
        contentValues.put(table_6, data5);
        contentValues_.put(table_1, datah);
        contentValues_.put(table_2, data1);
        insert_contentValues(status);
        this.s_data_h = datah;
        long result_ = db.insert("Data_log", null, contentValues_);
        long result = db.insert("Data", null, contentValues);
        if(status.equals("gonderildi")){
            direct_send(datah,data1,data2,data3,data4,data5);
        }
        else
            add_timer(datah,data1,data2,data3,data4,data5);
        if (result == -1 && result_ == -1)
            return false;
        else
            return true;
    }
    public void insert_contentValues(String status) {
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());//saat-tarih
        contentValues.put("add_time", currentDateTimeString);// add time column
        contentValues.put("status", status); //DATA status
        contentValues_.put("log", "ekleme");//DATA_LOG log
        contentValues_.put("date", currentDateTimeString);
    }
    public void send_contentValues(String dh,String d1) {
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());//saat-tarih
        contentValues_.put(table_1, dh);
        contentValues_.put(table_2, d1);
        contentValues.put("add_time", currentDateTimeString);// add time column
        contentValues_.put("log", "gonderildi");//DATA_LOG log
        contentValues_.put("date", currentDateTimeString);
        db.insert("Data_log", null, contentValues_);

    }

    public void deleteData(String id) {
        db.delete("Data", "data_id = ?", new String[]{id});
        contentValues_.put("log", "silme");
        contentValues_.put(table_1, s_data_h);
        contentValues_.put("data_id", id);

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        contentValues_.put("date", currentDateTimeString);
        db.insert("Data_log", null, contentValues_);


    }

    public ArrayList<Datalar> getAll_log() {
        ArrayList<Datalar> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(("SELECT * FROM Data_log"), null);
        while (cursor.moveToNext()) {
            String log_id = cursor.getString(0);
            String datah = cursor.getString(1);
            String data1 = cursor.getString(2);
            String log = cursor.getString(3);
            String date = cursor.getString(4);
            Datalar datalar = new Datalar(log_id, datah, data1, log, date, 22);
            arrayList.add(datalar);
        }
        return arrayList;
    }

    public ArrayList<Datalar> getAllData_b1() {
        ArrayList<Datalar> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(("SELECT * FROM Data"), null);
        while (cursor.moveToNext()) {
            String status = "beklemede";
            String data_id = cursor.getString(0);
            String datah = cursor.getString(1);
            String data1 =cursor.getString(2);
            if (count == 1) {
                status = cursor.getString(3);

            } else if (count == 2) {
                status = cursor.getString(4);
            } else if (count == 3) {
                status = cursor.getString(5);

            } else if (count == 4) {
                status = cursor.getString(6);

            } else if (count == 5) {
                status = cursor.getString(7);

            } else if (count == 6) {
                status = cursor.getString(8);

            }
            Datalar datalar = new Datalar(data_id, datah,data1, status);
            arrayList.add(datalar);
        }
        return arrayList;
    }

    public ArrayList<Datalar> getAllData_b2() {
        ArrayList<Datalar> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(("SELECT * FROM Data"), null);
        while (cursor.moveToNext()) {
            if (count == 1) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String status = cursor.getString(2);
                Datalar datalar = new Datalar(data_id, datah, status);
                arrayList.add(datalar);
            } else if (count == 2) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String status = cursor.getString(3);
                Datalar datalar = new Datalar(data_id, datah, data1, status);
                arrayList.add(datalar);
            } else if (count == 3) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String data2 = cursor.getString(3);
                String status = cursor.getString(4);
                Datalar datalar = new Datalar(data_id, datah, data1, data2, status);
                arrayList.add(datalar);
            } else if (count == 4) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String data2 = cursor.getString(3);
                String data3 = cursor.getString(4);
                String status = cursor.getString(5);
                Datalar datalar = new Datalar(data_id, datah, data1, data2, data3, status);
                arrayList.add(datalar);
            } else if (count == 5) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String data2 = cursor.getString(3);
                String data3 = cursor.getString(4);
                String data4 = cursor.getString(5);
                String status = cursor.getString(6);
                Datalar datalar = new Datalar(data_id, datah, data1, data2, data3,data4, status);
                arrayList.add(datalar);
            } else if (count == 6) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String data2 = cursor.getString(3);
                String data3 = cursor.getString(4);
                String data4 = cursor.getString(5);
                String data5 = cursor.getString(6);
                String status = cursor.getString(7);
                Datalar datalar = new Datalar(data_id, datah, data1, data2, data3,data4,data5,status);
                arrayList.add(datalar);
            }
        }
        return arrayList;
    }

    public ArrayList<Datalar> getAllData_wait() {
        ArrayList<Datalar> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(("SELECT * FROM Data WHERE status = 'beklemede'"), null);
        while (cursor.moveToNext()) {
            if (count == 1) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String status = cursor.getString(2);
                Datalar datalar = new Datalar(data_id, datah, status);
                arrayList.add(datalar);
            } else if (count == 2) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String status = cursor.getString(3);
                Datalar datalar = new Datalar(data_id, datah, data1, status);
                arrayList.add(datalar);
            } else if (count == 3) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String data2 = cursor.getString(3);
                String status = cursor.getString(4);
                Datalar datalar = new Datalar(data_id, datah, data1, data2, status);
                arrayList.add(datalar);
            } else if (count == 4) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String data2 = cursor.getString(3);
                String data3 = cursor.getString(4);
                String status = cursor.getString(5);
                Datalar datalar = new Datalar(data_id, datah, data1, data2, data3, status);
                arrayList.add(datalar);
            } else if (count == 5) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String data2 = cursor.getString(3);
                String data3 = cursor.getString(4);
                String data4 = cursor.getString(5);
                String status = cursor.getString(6);
                Datalar datalar = new Datalar(data_id, datah, data1, data2, data3,data4, status);
                arrayList.add(datalar);
            } else if (count == 6) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String data2 = cursor.getString(3);
                String data3 = cursor.getString(4);
                String data4 = cursor.getString(5);
                String data5 = cursor.getString(6);
                String status = cursor.getString(7);
                Datalar datalar = new Datalar(data_id, datah, data1, data2, data3,data4,data5,status);
                arrayList.add(datalar);
            }
        }
        return arrayList;
    }

    public ArrayList<Datalar> getAllData_cancel() {
        ArrayList<Datalar> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(("SELECT * FROM Data WHERE status = 'iptal'"), null);
        while (cursor.moveToNext()) {
            if (count == 1) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String status = cursor.getString(2);
                Datalar datalar = new Datalar(data_id, datah, status);
                arrayList.add(datalar);
            } else if (count == 2) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String status = cursor.getString(3);
                Datalar datalar = new Datalar(data_id, datah, data1, status);
                arrayList.add(datalar);
            } else if (count == 3) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String data2 = cursor.getString(3);
                String status = cursor.getString(4);
                Datalar datalar = new Datalar(data_id, datah, data1, data2, status);
                arrayList.add(datalar);
            } else if (count == 4) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String data2 = cursor.getString(3);
                String data3 = cursor.getString(4);
                String status = cursor.getString(5);
                Datalar datalar = new Datalar(data_id, datah, data1, data2, data3, status);
                arrayList.add(datalar);
            } else if (count == 5) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String data2 = cursor.getString(3);
                String data3 = cursor.getString(4);
                String data4 = cursor.getString(5);
                String status = cursor.getString(6);
                Datalar datalar = new Datalar(data_id, datah, data1, data2, data3,data4, status);
                arrayList.add(datalar);
            } else if (count == 6) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String data2 = cursor.getString(3);
                String data3 = cursor.getString(4);
                String data4 = cursor.getString(5);
                String data5 = cursor.getString(6);
                String status = cursor.getString(7);
                Datalar datalar = new Datalar(data_id, datah, data1, data2, data3,data4,data5,status);
                arrayList.add(datalar);
            }
        }
        return arrayList;
    }

    public ArrayList<Datalar> getAllData_sent() {
        ArrayList<Datalar> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(("SELECT * FROM Data WHERE status = 'gonderildi'"), null);
        while (cursor.moveToNext()) {
            if (count == 1) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String status = cursor.getString(2);
                Datalar datalar = new Datalar(data_id, datah, status);
                arrayList.add(datalar);
            } else if (count == 2) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String status = cursor.getString(3);
                Datalar datalar = new Datalar(data_id, datah, data1, status);
                arrayList.add(datalar);
            } else if (count == 3) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String data2 = cursor.getString(3);
                String status = cursor.getString(4);
                Datalar datalar = new Datalar(data_id, datah, data1, data2, status);
                arrayList.add(datalar);
            } else if (count == 4) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String data2 = cursor.getString(3);
                String data3 = cursor.getString(4);
                String status = cursor.getString(5);
                Datalar datalar = new Datalar(data_id, datah, data1, data2, data3, status);
                arrayList.add(datalar);
            } else if (count == 5) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String data2 = cursor.getString(3);
                String data3 = cursor.getString(4);
                String data4 = cursor.getString(5);
                String status = cursor.getString(6);
                Datalar datalar = new Datalar(data_id, datah, data1, data2, data3,data4, status);
                arrayList.add(datalar);
            } else if (count == 6) {
                String data_id = cursor.getString(0);
                String datah = cursor.getString(1);
                String data1 = cursor.getString(2);
                String data2 = cursor.getString(3);
                String data3 = cursor.getString(4);
                String data4 = cursor.getString(5);
                String data5 = cursor.getString(6);
                String status = cursor.getString(7);
                Datalar datalar = new Datalar(data_id, datah, data1, data2, data3,data4,data5,status);
                arrayList.add(datalar);
            }
        }
        return arrayList;
    }


    public boolean editOnay(String id, String status) {
        contentValues.put("status", status);
        contentValues_.put("log", "status duzenleme");
        contentValues_.put(table_1, s_data_h);
        contentValues_.put(table_2, "");
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        contentValues_.put("date", currentDateTimeString);
        db.insert("Data_log", null, contentValues_);
        long result = db.update("Data", contentValues, "data_id = ?", new String[]{id});
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean editData(String datah, String id, String status) {
        contentValues.put(table_1, datah);
        contentValues.put("status", status);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        contentValues_.put("date", currentDateTimeString);
        contentValues_.put("log", "duzenleme(" + table_1 + ")");
        contentValues_.put(table_1, s_data_h);
        contentValues_.put(table_2, "");
        db.insert("Data_log", null, contentValues_);
        long result = db.update("Data", contentValues, "data_id = ?", new String[]{id});
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean editData(String datah, String data1, String id, String status) {
        contentValues.put(table_1, datah);
        contentValues.put(table_2, data1);
        contentValues.put("status", status);
        contentValues_.put("log", "duzenleme(" + table_1 + "," + table_2 + ")");
        contentValues_.put(table_1, datah);
        contentValues_.put(table_2, data1);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        contentValues_.put("date", currentDateTimeString);
        db.insert("Data_log", null, contentValues_);
        long result = db.update("Data", contentValues, "data_id = ?", new String[]{id});
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean editData(String datah, String data1, String data2, String id, String status) {
        contentValues.put(table_1, datah);
        contentValues.put(table_2, data1);
        contentValues.put(table_3, data2);
        contentValues.put("status", status);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        contentValues_.put("date", currentDateTimeString);
        contentValues_.put("log", "duzenleme(" + table_1 + "," + table_2 + "," + table_3 + ")");
        contentValues_.put(table_1, datah);
        contentValues_.put(table_2, data1);
        db.insert("Data_log", null, contentValues_);

        long result = db.update("Data", contentValues, "data_id = ?", new String[]{id});
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean editData(String datah, String data1, String data2, String data3, String id, String status) {
        contentValues.put(table_1, datah);
        contentValues.put(table_2, data1);
        contentValues.put(table_3, data2);
        contentValues.put(table_4, data3);
        contentValues.put("status", status);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        contentValues_.put("date", currentDateTimeString);
        contentValues_.put("log", "duzenleme(" + table_1 + "," + table_2 + "," + table_3 + "," + table_4 + ")");
        contentValues_.put(table_1, datah);
        contentValues_.put(table_2, data1);
        db.insert("Data_log", null, contentValues_);

        long result = db.update("Data", contentValues, "data_id = ?", new String[]{id});
        if (result == -1)
            return false;
        else
            return true;
    }
    public boolean editData(String datah, String data1, String data2, String data3,String data4, String id, String status) {
        contentValues.put(table_1, datah);
        contentValues.put(table_2, data1);
        contentValues.put(table_3, data2);
        contentValues.put(table_4, data3);
        contentValues.put(table_5, data4);
        contentValues.put("status", status);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        contentValues_.put("date", currentDateTimeString);
        contentValues_.put("log", "duzenleme(" + table_1 + "," + table_2 + "," + table_3 + "," + table_4 +"," + table_5 + ")");
        contentValues_.put(table_1, datah);
        contentValues_.put(table_2, data1);
        db.insert("Data_log", null, contentValues_);

        long result = db.update("Data", contentValues, "data_id = ?", new String[]{id});
        if (result == -1)
            return false;
        else
            return true;
    }
    public boolean editData(String datah, String data1, String data2, String data3,String data4,String data5, String id, String status) {
        contentValues.put(table_1, datah);
        contentValues.put(table_2, data1);
        contentValues.put(table_3, data2);
        contentValues.put(table_4, data3);
        contentValues.put(table_5, data4);
        contentValues.put(table_6, data5);
        contentValues.put("status", status);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        contentValues_.put("date", currentDateTimeString);
        contentValues_.put("log", "duzenleme(" + table_1 + "," + table_2 + "," + table_3 + "," + table_4 +"," + table_5 + "," + table_6 + ")");
        contentValues_.put(table_1, datah);
        contentValues_.put(table_2, data1);
        db.insert("Data_log", null, contentValues_);

        long result = db.update("Data", contentValues, "data_id = ?", new String[]{id});
        if (result == -1)
            return false;
        else
            return true;
    }
    public String get_id(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(("select max(data_id) from data;"), null);
        cursor.moveToFirst();
        String id=cursor.getString(0);
        cursor.close();
        return id;
    }
    public void add_timer(final String s_data_h) {
        final int id=Integer.valueOf(get_id());
        countDownTimer=new CountDownTimer(saat,dakika) {
            @Override
            public void onTick(long millisUntilFinished) {
                kalan= (int) (millisUntilFinished/dakika);
            }

            @Override
            public void onFinish() {
                contentValues.put("status","gonderildi");
                db.update("Data",contentValues, "data_id = ?", new String[]{String.valueOf(id)});
                MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(s_data_h,true,context);
                mssql_adapter.execute("");
                send_contentValues(s_data_h,"");

            }
        }.start();

    }
    public void add_timer(final String s_data_h, final String s_data_1) {
        final int id=Integer.valueOf(get_id());
        countDownTimer=new CountDownTimer(saat,dakika) {
            @Override
            public void onTick(long millisUntilFinished) {
                kalan= (int) (millisUntilFinished/dakika);
            }

            @Override
            public void onFinish() {
                contentValues.put("status","gonderildi");
                db.update("Data",contentValues, "data_id = ?", new String[]{String.valueOf(id)});
                MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(s_data_h,s_data_1,true,context);
                mssql_adapter.execute("");
                send_contentValues(s_data_h,s_data_1);

            }
        }.start();

    }
    public void add_timer(final String s_data_h, final String s_data_1, final String s_data_2) {
        final int id=Integer.valueOf(get_id());
        countDownTimer=new CountDownTimer(saat,dakika) {
            @Override
            public void onTick(long millisUntilFinished) {
                kalan= (int) (millisUntilFinished/dakika);
            }

            @Override
            public void onFinish() {
                MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(s_data_h,s_data_1,s_data_2,true,context);
                mssql_adapter.execute("");
                contentValues.put("status","gonderildi");
                db.update("Data",contentValues, "data_id = ?", new String[]{String.valueOf(id)});
                send_contentValues(s_data_h,s_data_1);

            }
        }.start();

    }
    public void add_timer(final String s_data_h, final String s_data_1, final String s_data_2, final String s_data_3) {
        final int id=Integer.valueOf(get_id());
        countDownTimer=new CountDownTimer(saat,dakika) {
            @Override
            public void onTick(long millisUntilFinished) {
                kalan= (int) (millisUntilFinished/dakika);
            }

            @Override
            public void onFinish() {
                MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(s_data_h,s_data_1,s_data_2,s_data_3,true,context);
                mssql_adapter.execute("");
                contentValues.put("status","gonderildi");
                db.update("Data",contentValues, "data_id = ?", new String[]{String.valueOf(id)});
                send_contentValues(s_data_h,s_data_1);

            }
        }.start();

    }
    public void add_timer(final String s_data_h, final String s_data_1, final String s_data_2, final String s_data_3,final String s_data_4) {
        final int id=Integer.valueOf(get_id());
        countDownTimer=new CountDownTimer(saat,dakika) {
            @Override
            public void onTick(long millisUntilFinished) {
                kalan= (int) (millisUntilFinished/dakika);
            }

            @Override
            public void onFinish() {
                MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(s_data_h,s_data_1,s_data_2,s_data_3,s_data_4,true,context);
                mssql_adapter.execute("");
                contentValues.put("status","gonderildi");
                db.update("Data",contentValues, "data_id = ?", new String[]{String.valueOf(id)});
                send_contentValues(s_data_h,s_data_1);

            }
        }.start();

    }
    public void add_timer(final String s_data_h, final String s_data_1, final String s_data_2, final String s_data_3,final String s_data_4,final String s_data_5) {
        final int id=Integer.valueOf(get_id());
        countDownTimer=new CountDownTimer(saat,dakika) {
            @Override
            public void onTick(long millisUntilFinished) {
                kalan= (int) (millisUntilFinished/dakika);
            }

            @Override
            public void onFinish() {
                MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(s_data_h,s_data_1,s_data_2,s_data_3,s_data_4,s_data_5,true,context);
                mssql_adapter.execute("");
                contentValues.put("status","gonderildi");
                db.update("Data",contentValues, "data_id = ?", new String[]{String.valueOf(id)});
                send_contentValues(s_data_h,s_data_1);


            }
        }.start();

    }
    public void direct_send(final String s_data_h){
        final int id=Integer.valueOf(get_id());
        contentValues.put("status","gonderildi");
        db.update("Data",contentValues, "data_id = ?", new String[]{String.valueOf(id)});
        MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(s_data_h,true,context);
        mssql_adapter.execute("");
        send_contentValues(s_data_h,"");

    }
    public void direct_send(final String s_data_h, final String s_data_1){
        final int id=Integer.valueOf(get_id());
        contentValues.put("status","gonderildi");
        db.update("Data",contentValues, "data_id = ?", new String[]{String.valueOf(id)});
        MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(s_data_h,s_data_1,true,context);
        mssql_adapter.execute("");
        send_contentValues(s_data_h,s_data_1);

    }

    public void direct_send(final String s_data_h, final String s_data_1, final String s_data_2){
        final int id=Integer.valueOf(get_id());
        contentValues.put("status","gonderildi");
        db.update("Data",contentValues, "data_id = ?", new String[]{String.valueOf(id)});
        MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(s_data_h,s_data_1,s_data_2,true,context);
        mssql_adapter.execute("");
        send_contentValues(s_data_h,s_data_1);

    }

    public void direct_send(final String s_data_h, final String s_data_1, final String s_data_2, final String s_data_3){
        final int id=Integer.valueOf(get_id());
        contentValues.put("status","gonderildi");
        db.update("Data",contentValues, "data_id = ?", new String[]{String.valueOf(id)});
        MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(s_data_h,s_data_1,s_data_2,s_data_3,true,context);
        mssql_adapter.execute("");
        send_contentValues(s_data_h,s_data_1);

    }

    public void direct_send(final String s_data_h, final String s_data_1, final String s_data_2, final String s_data_3,final String s_data_4){
        final int id=Integer.valueOf(get_id());
        contentValues.put("status","gonderildi");
        db.update("Data",contentValues, "data_id = ?", new String[]{String.valueOf(id)});
        MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(s_data_h,s_data_1,s_data_2,s_data_3,s_data_4,true,context);
        mssql_adapter.execute("");
        send_contentValues(s_data_h,s_data_1);

    }

    public void direct_send(final String s_data_h, final String s_data_1, final String s_data_2, final String s_data_3,final String s_data_4,final String s_data_5){
        final int id=Integer.valueOf(get_id());
        contentValues.put("status","gonderildi");
        db.update("Data",contentValues, "data_id = ?", new String[]{String.valueOf(id)});
        MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(s_data_h,s_data_1,s_data_2,s_data_3,s_data_4,s_data_5,true,context);
        mssql_adapter.execute("");

        send_contentValues(s_data_h,s_data_1);


    }
    CountDownTimer countDownTimer;
    //int saat=3600000;
    int saat=15000;
    //int dakika=60000;
    int dakika=1000;
    int kalan;


}