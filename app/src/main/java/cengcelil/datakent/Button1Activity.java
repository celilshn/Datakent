package cengcelil.datakent;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import cengcelil.Adapter.MyAdapter;
import cengcelil.Model.Datalar;

public class Button1Activity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    ListView listView;
    ArrayList<Datalar>arrayList;
    MyAdapter myAdapter;
    FloatingActionButton floatingActionButton;
    SharedPreferences sharedPreferences,fortype;
    String table_1,table_2,table_3,table_4,table_5,table_6;
    static String type1,type2,type3,type4,type5,type6;
    TextView t1,t2;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button1);
        t1=findViewById(R.id.textView14);
        t2=findViewById(R.id.textView15);


        sharedPreferences= getSharedPreferences("key", Context.MODE_PRIVATE);
        type1=sharedPreferences.getString("key_type1","");
        type2=sharedPreferences.getString("key_type2","");
        type3=sharedPreferences.getString("key_type3","");
        type4=sharedPreferences.getString("key_type4","");
        type5=sharedPreferences.getString("key_type5","");
        type6=sharedPreferences.getString("key_type6","");
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
        final EditText new_data_4=mView.findViewById(R.id.editText5);
        final EditText new_data_5=mView.findViewById(R.id.editText6);
        final Button ndhb=mView.findViewById(R.id.button12);
        final Button nd1b=mView.findViewById(R.id.button13);
        final Button nd2b=mView.findViewById(R.id.button14);
        final Button nd3b=mView.findViewById(R.id.button15);
        final Button nd4b=mView.findViewById(R.id.button16);
        final Button nd5b=mView.findViewById(R.id.button17);

        final Button new_data_button=mView.findViewById(R.id.button5);
        final CheckBox checked_data=mView.findViewById(R.id.checkBox);
        new_data_h.setHint(table_1);

            ndhb.setOnClickListener(new View.OnClickListener() {
                final Calendar myCalendar = Calendar.getInstance();

                final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        new_data_h.setText(new StringBuilder()
                                // Month is 0 based so add 1
                                .append(dayOfMonth).append("/").append(monthOfYear + 1).append("/").append(year).append(" "));
                    }
                };
                @Override
                public void onClick(View v) {
                    new DatePickerDialog(Button1Activity.this, date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                                   }
            });
        nd1b.setOnClickListener(new View.OnClickListener() {
            final Calendar myCalendar = Calendar.getInstance();

            final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    // TODO Auto-generated method stub
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                    new_data_1.setText(new StringBuilder()
                            // Month is 0 based so add 1
                            .append(dayOfMonth).append("/").append(monthOfYear + 1).append("/").append(year).append(" "));
                }
            };
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Button1Activity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        nd2b.setOnClickListener(new View.OnClickListener() {
            final Calendar myCalendar = Calendar.getInstance();

            final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    // TODO Auto-generated method stub
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                    new_data_2.setText(new StringBuilder()
                            // Month is 0 based so add 1
                            .append(dayOfMonth).append("/").append(monthOfYear + 1).append("/").append(year).append(" "));
                }
            };
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Button1Activity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        nd3b.setOnClickListener(new View.OnClickListener() {
            final Calendar myCalendar = Calendar.getInstance();

            final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    // TODO Auto-generated method stub
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                    new_data_3.setText(new StringBuilder()
                            // Month is 0 based so add 1
                            .append(dayOfMonth).append("/").append(monthOfYear + 1).append("/").append(year).append(" "));
                }
            };
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Button1Activity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        nd4b.setOnClickListener(new View.OnClickListener() {
            final Calendar myCalendar = Calendar.getInstance();

            final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    // TODO Auto-generated method stub
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                    new_data_4.setText(new StringBuilder()
                            // Month is 0 based so add 1
                            .append(dayOfMonth).append("/").append(monthOfYear + 1).append("/").append(year).append(" "));
                }
            };
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Button1Activity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        nd5b.setOnClickListener(new View.OnClickListener() {
            final Calendar myCalendar = Calendar.getInstance();

            final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    // TODO Auto-generated method stub
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                    new_data_5.setText(new StringBuilder()
                            // Month is 0 based so add 1
                            .append(dayOfMonth).append("/").append(monthOfYear + 1).append("/").append(year).append(" "));
                }
            };
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Button1Activity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        if(count==1){

            new_data_1.setVisibility(View.VISIBLE);
            new_data_1.setHint(table_2);
            checktype(ndhb,nd1b,nd2b,nd3b,nd4b,nd5b);

        }
        else if(count==2){
            new_data_1.setVisibility(View.VISIBLE);
            new_data_1.setHint(table_2);
            new_data_2.setVisibility(View.VISIBLE);
            new_data_2.setHint(table_3);
            checktype(ndhb,nd1b,nd2b,nd3b,nd4b,nd5b);

        }
        else if(count==3){
            new_data_1.setVisibility(View.VISIBLE);
            new_data_1.setHint(table_2);
            new_data_2.setVisibility(View.VISIBLE);
            new_data_2.setHint(table_3);

            new_data_3.setVisibility(View.VISIBLE);
            new_data_3.setHint(table_4);
            checktype(ndhb,nd1b,nd2b,nd3b,nd4b,nd5b);

        }
        else if(count==4){
            new_data_1.setVisibility(View.VISIBLE);
            new_data_1.setHint(table_2);
            new_data_2.setVisibility(View.VISIBLE);
            new_data_2.setHint(table_3);

            new_data_3.setVisibility(View.VISIBLE);
            new_data_3.setHint(table_4);
            new_data_4.setVisibility(View.VISIBLE);
            new_data_4.setHint(table_5);
            checktype(ndhb,nd1b,nd2b,nd3b,nd4b,nd5b);

        }
        else if(count==5){
            new_data_1.setVisibility(View.VISIBLE);
            new_data_1.setHint(table_2);
            new_data_2.setVisibility(View.VISIBLE);
            new_data_2.setHint(table_3);

            new_data_3.setVisibility(View.VISIBLE);
            new_data_3.setHint(table_4);
            new_data_4.setVisibility(View.VISIBLE);
            new_data_4.setHint(table_5);
            new_data_5.setVisibility(View.VISIBLE);
            new_data_5.setHint(table_6);
            checktype(ndhb,nd1b,nd2b,nd3b,nd4b,nd5b);

        }
        builder.setView(mView);
        final AlertDialog alertDialog=builder.create();
        alertDialog.show();
        new_data_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String onay;
                boolean result = false;
                if(checked_data.isChecked())
                    onay="iptal";
                else
                    onay="beklemede";
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
                if(count==4) {
                    result = databaseHelper.insertData(new_data_h.getText().toString(), new_data_1.getText().toString(), new_data_2.getText().toString(), new_data_3.getText().toString(),new_data_4.getText().toString(), onay);
                }
                if(count==5) {
                    result = databaseHelper.insertData(new_data_h.getText().toString(), new_data_1.getText().toString(), new_data_2.getText().toString(), new_data_3.getText().toString(),new_data_4.getText().toString(),new_data_5.getText().toString(), onay);
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
    public void checktype(Button h,Button _1,Button _2,Button _3,Button _4,Button _5){
        if(type1.equals("Date"))
            h.setVisibility(View.VISIBLE);
        if(type2.equals("Date"))
            _1.setVisibility(View.VISIBLE);
        if(type3.equals("Date"))
            _2.setVisibility(View.VISIBLE);
        if(type4.equals("Date"))
            _3.setVisibility(View.VISIBLE);
        if(type5.equals("Date"))
            _4.setVisibility(View.VISIBLE);
        if(type6.equals("Date"))
            _5.setVisibility(View.VISIBLE);
    }
}
