package cengcelil.datakent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import cengcelil.Model.Datalar;

public class DatabaseHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db=this.getReadableDatabase();
    private ContentValues contentValues=new ContentValues();


    public DatabaseHelper(Context context) {
        super(context, "datakent.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Data (data_id INTEGER PRIMARY KEY AUTOINCREMENT,data_header TEXT,data1 TEXT,data2 TEXT,data3 TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS Data");
            onCreate(db);
    }
    public boolean insertData(String datah,String data1,String data2,String data3){
        contentValues.put("data_header",datah);
        contentValues.put("data1",data1);
        contentValues.put("data2",data2);
        contentValues.put("data3",data3);

        long result=db.insert("Data",null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public void deleteData(String id) {
        db.delete("Data","data_id = ?", new String[]{id});


    }


    public ArrayList<Datalar> getAllData() {
    ArrayList<Datalar>arrayList =new ArrayList<>();
    SQLiteDatabase db=this.getReadableDatabase();
    Cursor cursor =db.rawQuery(("SELECT * FROM Data"),null);
        while(cursor.moveToNext()){
            String data_id=cursor.getString(0);
            String datah=cursor.getString(1);
            String data1=cursor.getString(2);
            String data2=cursor.getString(3);
            String data3=cursor.getString(4);
            Datalar datalar=new Datalar(data_id,datah,data1,data2,data3);
            arrayList.add(datalar);
        }
    return arrayList;
    }

    public boolean editData(String datah,String data1,String data2,String data3,String id){
        contentValues.put("data_header",datah);
        contentValues.put("data1",data1);
        contentValues.put("data2",data2);
        contentValues.put("data3",data3);

        long result=db.update("Data",contentValues,"data_id = ?",new String[]{id});
        if(result == -1)
            return false;
        else
            return true;
    }

}