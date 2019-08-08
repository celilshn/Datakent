package cengcelil.datakent;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import cengcelil.Adapter.MyAdapter;
import cengcelil.Model.Datalar;

public class Button3Activity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    ListView listView;
    ArrayList<Datalar> arrayList;
    MyAdapter myAdapter;

    SharedPreferences sharedPreferences;
    String table_1,table_2,table_3,table_4,table_5,table_6;
    Spinner spinner;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button3);

        spinner=findViewById(R.id.spinner2);
        String[] option={"Beklemede","Iptal","Gönderildi"};

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,option);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
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
        else if(count==4)
        {
            table_1=sharedPreferences.getString("key_table1","0");
            table_2=sharedPreferences.getString("key_table2","0");
            table_3=sharedPreferences.getString("key_table3","0");
            table_4=sharedPreferences.getString("key_table4","0");
            table_5=sharedPreferences.getString("key_table5","0");

            databaseHelper=new DatabaseHelper(this,table_1,table_2,table_3,table_4,table_5);
        }
        else if(count==5)
        {
            table_1=sharedPreferences.getString("key_table1","0");
            table_2=sharedPreferences.getString("key_table2","0");
            table_3=sharedPreferences.getString("key_table3","0");
            table_4=sharedPreferences.getString("key_table4","0");
            table_5=sharedPreferences.getString("key_table5","0");
            table_6=sharedPreferences.getString("key_table6","0");
            databaseHelper=new DatabaseHelper(this,table_1,table_2,table_3,table_4,table_5,table_6);
        }

        listView=findViewById(R.id.listview_b3);
        arrayList=new ArrayList<>();
        spinner.setSelected(true);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getSelectedItemPosition()==0)
                    LoadDataInListView_wait();
                else if(parent.getSelectedItemPosition()==1)
                    LoadDataInListView_cancel();
                else if(parent.getSelectedItemPosition()==2)
                    LoadDataInListView_sent();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void LoadDataInListView_wait() {
        arrayList=databaseHelper.getAllData_wait();
        myAdapter=new MyAdapter(this,arrayList,3);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Button3Activity.this);
                View mView=getLayoutInflater().inflate(R.layout.dialog_check,null);
                final Button button_yes=mView.findViewById(R.id.button9);
                final Button button_no=mView.findViewById(R.id.button10);
                TextView textView_alert=mView.findViewById(R.id.textView8);
                textView_alert.setText("Veriyi iptal etmek için 'Veriyi iptal et' butonuna tıklayınız");
                builder.setView(mView);
                final AlertDialog alertDialog=builder.create();
                alertDialog.show();
                button_yes.setText("Veriyi iptal et");
                button_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean result=databaseHelper.editOnay(arrayList.get(position).getId(),"iptal");
                        if(result)
                            Toast.makeText(Button3Activity.this, "Veri iptal edildi", Toast.LENGTH_SHORT).show();
                        updateList_wait();
                        alertDialog.dismiss();
                    }
                });
                button_no.setText("İptal Et");
                button_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

            }
        });
    }
    private void LoadDataInListView_cancel() {
        arrayList=databaseHelper.getAllData_cancel();
        myAdapter=new MyAdapter(this,arrayList,3);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Button3Activity.this);
                View mView=getLayoutInflater().inflate(R.layout.dialog_check,null);
                final Button button_yes=mView.findViewById(R.id.button9);
                final Button button_no=mView.findViewById(R.id.button10);
                final Button button_direct=mView.findViewById(R.id.button24);
                button_direct.setVisibility(View.VISIBLE);
                TextView textView_alert=mView.findViewById(R.id.textView8);
                textView_alert.setText("Gönderilsin mi?");
                builder.setView(mView);
                final AlertDialog alertDialog=builder.create();
                alertDialog.show();
                button_direct.setText("Direkt Gönder");
                button_direct.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean result=databaseHelper.editOnay(arrayList.get(position).getId(),"beklemede");
                        if(result){
                            direct_send();
                            Toast.makeText(Button3Activity.this, "Gönderildi", Toast.LENGTH_SHORT).show();
                        }
                        updateList_cancel();
                        alertDialog.dismiss();

                    }
                });
                button_yes.setText("Gönder");
                button_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean result=databaseHelper.editOnay(arrayList.get(position).getId(),"beklemede");
                        if(result){
                            addTimer_modify();
                            Toast.makeText(Button3Activity.this, "Gönderim kuyruğuna eklendi", Toast.LENGTH_SHORT).show();
                        }
                        updateList_cancel();
                        alertDialog.dismiss();
                    }
                });
                button_no.setText("İptal");
                button_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

            }
        });
    }
    private void LoadDataInListView_sent() {
        arrayList=databaseHelper.getAllData_sent();
        myAdapter=new MyAdapter(this,arrayList,3);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {

                Toast.makeText(Button3Activity.this,"",Toast.LENGTH_SHORT).show();


                }


        });
    }
    public void updateList_wait(){
        arrayList=databaseHelper.getAllData_wait();
        myAdapter=new MyAdapter(this,arrayList,3);
        listView.setAdapter(myAdapter);
    }
    public void updateList_cancel(){
        arrayList=databaseHelper.getAllData_cancel();
        myAdapter=new MyAdapter(this,arrayList,3);
        listView.setAdapter(myAdapter);
    }
    public void addTimer_modify(){
        if(count==0)
        {
            databaseHelper.add_timer(table_1);
        }
        else if(count==1)
        {
            databaseHelper.add_timer(table_1,table_2);
        }
        else if(count==2)
        {
            databaseHelper.add_timer(table_1,table_2,table_3);
        }
        else if(count==3)
        {
            databaseHelper.add_timer(table_1,table_2,table_3,table_4);
        }
        else if(count==4)
        {
            databaseHelper.add_timer(table_1,table_2,table_3,table_4,table_5);
        }
        else if(count==5)
        {
            databaseHelper.add_timer(table_1,table_2,table_3,table_4,table_5,table_6);
        }
    }
    public void direct_send(){
        if(count==0)
        {
            databaseHelper.direct_send(table_1);
        }
        else if(count==1)
        {
            databaseHelper.direct_send(table_1,table_2);
        }
        else if(count==2)
        {
            databaseHelper.direct_send(table_1,table_2,table_3);
        }
        else if(count==3)
        {
            databaseHelper.direct_send(table_1,table_2,table_3,table_4);
        }
        else if(count==4)
        {
            databaseHelper.direct_send(table_1,table_2,table_3,table_4,table_5);
        }
        else if(count==5)
        {
            databaseHelper.direct_send(table_1,table_2,table_3,table_4,table_5,table_6);
        }
    }
}
