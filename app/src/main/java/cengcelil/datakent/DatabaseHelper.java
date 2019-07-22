package cengcelil.datakent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.CountDownTimer;
import android.os.Handler;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import cengcelil.Adapter.MSSQL_Adapter;
import cengcelil.Model.Datalar;

public class DatabaseHelper extends SQLiteOpenHelper {

    public SQLiteDatabase db = this.getReadableDatabase();
    private ContentValues contentValues = new ContentValues(), contentValues_ = new ContentValues();
    String table_1, table_2, table_3, table_4;
    int count;
    boolean check;
    String s_data_h;
    Context context;
    public DatabaseHelper(Context context, String table_1, int a) {
        super(context, "datakent.db", null, 1);
        this.table_1 = table_1;
        if (check)
            create();
        this.context=context;

    }

    public DatabaseHelper(Context context, String table_1) {
        super(context, "datakent.db", null, 1);
        this.table_1 = table_1;
        count = 1;
        if (check)
            create();
        this.context=context;

    }

    public DatabaseHelper(Context context, String table_1, String table_2) {
        super(context, "datakent.db", null, 1);
        this.table_1 = table_1;
        this.table_2 = table_2;
        count = 2;
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
        if (check)
            create();
        this.context=context;

    }


    public void create() {
        if (count == 1) {
            db.execSQL("CREATE TABLE Data (data_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT,status TEXT,add_time TEXT)");
            db.execSQL("CREATE TABLE Data_log (log_id INTEGER PRIMARY KEY AUTOINCREMENT,data_id INTEGER," + table_1 + " TEXT,log TEXT,date TEXT)");
            MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(table_1,false,context);
            mssql_adapter.execute("");
        } else if (count == 2) {
            db.execSQL("CREATE TABLE Data (data_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT," + table_2 + " TEXT,status TEXT,add_time TEXT)");
            db.execSQL("CREATE TABLE Data_log (log_id INTEGER PRIMARY KEY AUTOINCREMENT,data_id INTEGER," + table_1 + " TEXT,log TEXT,date TEXT)");
            MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(table_1,table_2,false,context);
            mssql_adapter.execute("");
        } else if (count == 3) {
            db.execSQL("CREATE TABLE Data (data_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT," + table_2 + " TEXT," + table_3 + " TEXT,status TEXT,add_time TEXT)");
            db.execSQL("CREATE TABLE Data_log (log_id INTEGER PRIMARY KEY AUTOINCREMENT,data_id INTEGER," + table_1 + " TEXT,log TEXT,date TEXT)");
            MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(table_1,table_2,table_3,false,context);
            mssql_adapter.execute("");
        } else if (count == 4) {
            db.execSQL("CREATE TABLE Data (data_id INTEGER PRIMARY KEY AUTOINCREMENT," + table_1 + " TEXT," + table_2 + " TEXT," + table_3 + " TEXT," + table_4 + " TEXT,status TEXT,add_time TEXT)");
            db.execSQL("CREATE TABLE Data_log (log_id INTEGER PRIMARY KEY AUTOINCREMENT,data_id INTEGER," + table_1 + " TEXT,log TEXT,date TEXT)");
            MSSQL_Adapter mssql_adapter=new MSSQL_Adapter(table_1,table_2,table_3,table_4,false,context);
            mssql_adapter.execute("");
        }
        check = false;
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
        insert_contentValues(status);
        long result_ = db.insert("Data_log", null, contentValues_);
        long result = db.insert("Data", null, contentValues);
        add_timer(datah);
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

    public boolean insertData(String datah, String data1, String status) {
        this.s_data_h = datah;
        contentValues.put(table_1, datah);
        contentValues.put(table_2, data1);
        contentValues_.put(table_1, datah);
        insert_contentValues(status);
        long result_ = db.insert("Data_log", null, contentValues_);

        long result = db.insert("Data", null, contentValues);
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
        insert_contentValues(status);

        this.s_data_h = datah;

        long result_ = db.insert("Data_log", null, contentValues_);

        long result = db.insert("Data", null, contentValues);
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
        insert_contentValues(status);
        this.s_data_h = datah;
        long result_ = db.insert("Data_log", null, contentValues_);
        long result = db.insert("Data", null, contentValues);
        add_timer(datah,data1,data2,data3);
        if (result == -1 && result_ == -1)
            return false;
        else
            return true;
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
            String data_id = cursor.getString(1);
            String datah = cursor.getString(2);
            String log = cursor.getString(3);
            String date = cursor.getString(4);
            Datalar datalar = new Datalar(log_id, data_id, datah, log, date, 22);
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
            if (count == 1) {
                status = cursor.getString(2);

            } else if (count == 2) {
                status = cursor.getString(3);
            } else if (count == 3) {
                status = cursor.getString(4);

            } else if (count == 4) {
                status = cursor.getString(5);

            }
            Datalar datalar = new Datalar(data_id, datah, status);
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
            }

        }
        return arrayList;
    }


    public boolean editOnay(String id, String status) {
        contentValues.put("status", status);
        contentValues_.put("log", "status duzenleme");
        contentValues_.put(table_1, s_data_h);
        contentValues_.put("data_id", id);
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
        contentValues_.put("data_id", id);
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
        contentValues_.put("data_id", id);
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
        contentValues_.put("data_id", id);
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
        contentValues_.put("data_id", id);
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

            }
        }.start();

    }
    CountDownTimer countDownTimer;
    //int saat=3600000;
    int saat=3000;
    //int dakika=60000;
    int dakika=1000;
    int kalan;


}