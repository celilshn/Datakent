package cengcelil.datakent;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import cengcelil.Adapter.MyAdapter;
import cengcelil.Model.Datalar;

public class Button4Activity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    ListView listView;
    ArrayList<Datalar> arrayList;
    MyAdapter myAdapter;

    SharedPreferences sharedPreferences;
    String table_1,table_2,table_3,table_4;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button4);
        sharedPreferences= getSharedPreferences("key", Context.MODE_PRIVATE);
        table_1=sharedPreferences.getString("key_table1","0");
        databaseHelper=new DatabaseHelper(this,table_1,22);
        listView=findViewById(R.id.list_view_b4);
        arrayList=new ArrayList<>();
        LoadDataInListView();
    }
    private void LoadDataInListView() {
        arrayList=databaseHelper.getAll_log();
        myAdapter=new MyAdapter(this,arrayList,4);
        listView.setAdapter(myAdapter);
    }
}
