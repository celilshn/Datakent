package cengcelil.datakent;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cengcelil.Adapter.MyAdapter;
import cengcelil.Model.Datalar;

public class Button1Activity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    ListView listView;
    ArrayList<Datalar>arrayList;
    MyAdapter myAdapter;
    FloatingActionButton floatingActionButton;
    SharedPreferences sharedPreferences;
    String table_1,table_2,table_3,table_4;
    TextView t1,t2;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button1);
        t1=findViewById(R.id.textView14);
        t2=findViewById(R.id.textView15);

        sharedPreferences= getSharedPreferences("key", Context.MODE_PRIVATE);
        count=sharedPreferences.getInt("key_count",0);
        if(count==0)
        {
            table_1=sharedPreferences.getString("key_table1","0");
            databaseHelper=new DatabaseHelper(this,table_1);

        }
        else if(count==1)
        {
            table_1=sharedPreferences.getString("key_table1","0");
            table_2=sharedPreferences.getString("key_table2","0");
            databaseHelper=new DatabaseHelper(this,table_1,table_2);


        }
        else if(count==2)
        {
            table_1=sharedPreferences.getString("key_table1","0");
            table_2=sharedPreferences.getString("key_table2","0");
            table_3=sharedPreferences.getString("key_table3","0");
            databaseHelper=new DatabaseHelper(this,table_1,table_2,table_3);

        }
        else if(count==3)
        {
            table_1=sharedPreferences.getString("key_table1","0");
            table_2=sharedPreferences.getString("key_table2","0");
            table_3=sharedPreferences.getString("key_table3","0");
            table_4=sharedPreferences.getString("key_table4","0");
            databaseHelper=new DatabaseHelper(this,table_1,table_2,table_3,table_4);

        }
        t1.setText("id");
        t2.setText(table_1);
        listView=findViewById(R.id.listview);
        floatingActionButton=findViewById(R.id.fab);
        arrayList=new ArrayList<>();
        LoadDataInListView();


    }

    private void LoadDataInListView() {
        arrayList=databaseHelper.getAllData_b1();
        myAdapter=new MyAdapter(this,arrayList,1);
        listView.setAdapter(myAdapter);
    }

    public void updateList(){
        arrayList=databaseHelper.getAllData_b1();
        myAdapter=new MyAdapter(this,arrayList,1);
        listView.setAdapter(myAdapter);
    }

    public void new_data_method(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(Button1Activity.this);
        View mView=getLayoutInflater().inflate(R.layout.new_data,null);
        final EditText new_data_h=mView.findViewById(R.id.editText);
        final EditText new_data_1=mView.findViewById(R.id.editText2);
        final EditText new_data_2=mView.findViewById(R.id.editText3);
        final EditText new_data_3=mView.findViewById(R.id.editText4);
        final Button new_data_button=mView.findViewById(R.id.button5);
        final CheckBox checked_data=mView.findViewById(R.id.checkBox);
        if(count==1){
            new_data_1.setVisibility(View.VISIBLE);
        }
        else if(count==2){
            new_data_1.setVisibility(View.VISIBLE);
            new_data_2.setVisibility(View.VISIBLE);
        }
        else if(count==3){
            new_data_1.setVisibility(View.VISIBLE);
            new_data_2.setVisibility(View.VISIBLE);
            new_data_3.setVisibility(View.VISIBLE);
        }
        builder.setView(mView);
        final AlertDialog alertDialog=builder.create();
        alertDialog.show();
        new_data_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int onay;
                boolean result = false;
                if(checked_data.isChecked())
                    onay=1;
                else
                    onay=0;
                if(count==0)
                {

                    result=databaseHelper.insertData(new_data_h.getText().toString(),onay);
                }
                if(count==1){
                    result=databaseHelper.insertData(new_data_h.getText().toString(),new_data_1.getText().toString(),onay);
                }
                if(count==2){
                    result=databaseHelper.insertData(new_data_h.getText().toString(),new_data_1.getText().toString(),new_data_2.getText().toString(),onay);
                }
                if(count==3) {
                    result = databaseHelper.insertData(new_data_h.getText().toString(), new_data_1.getText().toString(), new_data_2.getText().toString(), new_data_3.getText().toString(), onay);
                }
                if(result) {
                    Toast.makeText(Button1Activity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                    updateList();
                }
                else
                    Toast.makeText(Button1Activity.this, "Error", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });

    }
}
