package cengcelil.datakent;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cengcelil.Adapter.MyAdapter;
import cengcelil.Model.Datalar;

public class Button2Activity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    ListView listView;
    ArrayList<Datalar> arrayList;
    MyAdapter myAdapter;

    SharedPreferences sharedPreferences;
    String table_1,table_2,table_3,table_4;
    int count;
    TextView t1,t2,t3,t4,t5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button2);
        t1=findViewById(R.id.textView9);
        t2=findViewById(R.id.textView10);
        t3=findViewById(R.id.textView11);
        t4=findViewById(R.id.textView12);
        t5=findViewById(R.id.textView13);

        sharedPreferences= getSharedPreferences("key", Context.MODE_PRIVATE);
        count=sharedPreferences.getInt("key_count",0);
        t1.setText("id");

        if(count==0)
        {
            table_1=sharedPreferences.getString("key_table1","0");
            databaseHelper=new DatabaseHelper(this,table_1);
            t2.setText(table_1);
        }
        else if(count==1)
        {
            table_1=sharedPreferences.getString("key_table1","0");
            table_2=sharedPreferences.getString("key_table2","0");
            databaseHelper=new DatabaseHelper(this,table_1,table_2);
            t2.setText(table_1);
            t3.setText(table_2);
            t3.setVisibility(View.VISIBLE);
        }
        else if(count==2)
        {
            table_1=sharedPreferences.getString("key_table1","0");
            table_2=sharedPreferences.getString("key_table2","0");
            table_3=sharedPreferences.getString("key_table3","0");
            databaseHelper=new DatabaseHelper(this,table_1,table_2,table_3);
            t2.setText(table_1);
            t3.setText(table_2);
            t3.setVisibility(View.VISIBLE);
            t4.setText(table_3);
            t4.setVisibility(View.VISIBLE);

        }
        else if(count==3)
        {
            table_1=sharedPreferences.getString("key_table1","0");
            table_2=sharedPreferences.getString("key_table2","0");
            table_3=sharedPreferences.getString("key_table3","0");
            table_4=sharedPreferences.getString("key_table4","0");
            databaseHelper=new DatabaseHelper(this,table_1,table_2,table_3,table_4);
            t2.setText(table_1);
            t3.setText(table_2);
            t3.setVisibility(View.VISIBLE);
            t4.setText(table_3);
            t4.setVisibility(View.VISIBLE);
            t5.setText(table_4);
            t5.setVisibility(View.VISIBLE);

        }

        listView=findViewById(R.id.listview_b2);
        arrayList=new ArrayList<>();
        LoadDataInListView();


    }

    private void LoadDataInListView() {
        arrayList=databaseHelper.getAllData_b2();
        myAdapter=new MyAdapter(this,arrayList,2);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Button2Activity.this);
                View mView=getLayoutInflater().inflate(R.layout.dialog_items,null);
                final EditText edit_data_h=mView.findViewById(R.id.editText5);
                final EditText edit_data_1=mView.findViewById(R.id.editText6);
                final EditText edit_data_2=mView.findViewById(R.id.editText7);
                final EditText edit_data_3=mView.findViewById(R.id.editText8);
                final Button accept_edit=mView.findViewById(R.id.button7);
                final Button delete_edit=mView.findViewById(R.id.button8);
                final CheckBox cheched_data=mView.findViewById(R.id.checkBox2);
                edit_data_h.setText(arrayList.get(position).getDatah());
                if(count==1){
                    edit_data_1.setVisibility(View.VISIBLE);
                    edit_data_1.setText(arrayList.get(position).getData1());
                }
                else if(count==2){
                    edit_data_1.setVisibility(View.VISIBLE);
                    edit_data_1.setText(arrayList.get(position).getData1());
                    edit_data_2.setVisibility(View.VISIBLE);
                    edit_data_2.setText(arrayList.get(position).getData2());

                }
                if(count==3){
                    edit_data_1.setVisibility(View.VISIBLE);
                    edit_data_1.setText(arrayList.get(position).getData1());
                    edit_data_2.setVisibility(View.VISIBLE);
                    edit_data_2.setText(arrayList.get(position).getData2());
                    edit_data_3.setVisibility(View.VISIBLE);
                    edit_data_3.setText(arrayList.get(position).getData3());
                }

                if(arrayList.get(position).getStatus()=="beklemede")
                    cheched_data.setChecked(true);
                builder.setView(mView);
                final AlertDialog alertDialog=builder.create();
                alertDialog.show();
                delete_edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        databaseHelper.deleteData(arrayList.get(position).getId());
                        updateList();
                        alertDialog.dismiss();
                    }
                });
                accept_edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String onay;
                        boolean result=false;
                        if(cheched_data.isChecked())
                            onay = "iptal";
                        else
                            onay = "beklemede";

                        if(count==0)
                        {
                             result=databaseHelper.editData(edit_data_h.getText().toString(),arrayList.get(position).getId(),onay);
                        }
                        if(count==1){
                            result=databaseHelper.editData(edit_data_h.getText().toString(),edit_data_1.getText().toString(),arrayList.get(position).getId(),onay);
                        }
                        if(count==2){
                            result=databaseHelper.editData(edit_data_h.getText().toString(),edit_data_1.getText().toString(),edit_data_2.getText().toString(),arrayList.get(position).getId(),onay);
                        }
                        if(count==3) {
                            result=databaseHelper.editData(edit_data_h.getText().toString(),edit_data_1.getText().toString(),edit_data_2.getText().toString(),edit_data_3.getText().toString(),arrayList.get(position).getId(),onay);
                        }
                        if(result) {
                            Toast.makeText(Button2Activity.this, "Data edited", Toast.LENGTH_SHORT).show();
                            updateList();
                        }
                        else
                            Toast.makeText(Button2Activity.this, "Error", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                });
            }
        });
    }

    public void updateList(){
        arrayList=databaseHelper.getAllData_b2();
        myAdapter=new MyAdapter(this,arrayList,2);
        listView.setAdapter(myAdapter);
    }
}
