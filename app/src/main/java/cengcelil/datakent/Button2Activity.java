package cengcelil.datakent;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import cengcelil.Adapter.MyAdapter;
import cengcelil.Model.Datalar;

public class Button2Activity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    ListView listView;
    ArrayList<Datalar> arrayList;
    MyAdapter myAdapter;

    SharedPreferences sharedPreferences;
    String table_1,table_2,table_3,table_4,table_5,table_6;
    int count;
    TextView t1,t2,t3,t4,t5,t6,t7;
    String type1,type2,type3,type4,type5,type6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button2);
        sharedPreferences= getSharedPreferences("key", Context.MODE_PRIVATE);
        count=sharedPreferences.getInt("key_count",0);
        type1=sharedPreferences.getString("key_type1","");
        type2=sharedPreferences.getString("key_type2","");
        type3=sharedPreferences.getString("key_type3","");
        type4=sharedPreferences.getString("key_type4","");
        type5=sharedPreferences.getString("key_type5","");
        type6=sharedPreferences.getString("key_type6","");

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
        listView=findViewById(R.id.listview_b2);
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
                final EditText edit_data_4=mView.findViewById(R.id.editText15);
                final EditText edit_data_5=mView.findViewById(R.id.editText16);
                final TextView tdh=mView.findViewById(R.id.textView4);
                final TextView td1=mView.findViewById(R.id.textView5);
                final TextView td2=mView.findViewById(R.id.textView6);
                final TextView td3=mView.findViewById(R.id.textView7);
                final TextView td4=mView.findViewById(R.id.textView33);
                final TextView td5=mView.findViewById(R.id.textView34);
                final Button accept_edit=mView.findViewById(R.id.button7);
                final Button delete_edit=mView.findViewById(R.id.button8);
                final CheckBox cheched_data=mView.findViewById(R.id.checkBox2);

                final Button ndhb=mView.findViewById(R.id.button18);
                final Button nd1b=mView.findViewById(R.id.button19);
                final Button nd2b=mView.findViewById(R.id.button20);
                final Button nd3b=mView.findViewById(R.id.button21);
                final Button nd4b=mView.findViewById(R.id.button22);
                final Button nd5b=mView.findViewById(R.id.button23);
                final LinearLayout l1=mView.findViewById(R.id.l1);
                final LinearLayout l2=mView.findViewById(R.id.l2);
                final LinearLayout l3=mView.findViewById(R.id.l3);
                final LinearLayout l4=mView.findViewById(R.id.l4);
                final LinearLayout l5=mView.findViewById(R.id.l5);


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

                            edit_data_h.setText(new StringBuilder()
                                    // Month is 0 based so add 1
                                    .append(dayOfMonth).append("/").append(monthOfYear + 1).append("/").append(year).append(" "));
                        }
                    };
                    @Override
                    public void onClick(View v) {
                        new DatePickerDialog(Button2Activity.this, date, myCalendar
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

                            edit_data_1.setText(new StringBuilder()
                                    // Month is 0 based so add 1
                                    .append(dayOfMonth).append("/").append(monthOfYear + 1).append("/").append(year).append(" "));
                        }
                    };
                    @Override
                    public void onClick(View v) {
                        new DatePickerDialog(Button2Activity.this, date, myCalendar
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

                            edit_data_2.setText(new StringBuilder()
                                    // Month is 0 based so add 1
                                    .append(dayOfMonth).append("/").append(monthOfYear + 1).append("/").append(year).append(" "));
                        }
                    };
                    @Override
                    public void onClick(View v) {
                        new DatePickerDialog(Button2Activity.this, date, myCalendar
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

                            edit_data_3.setText(new StringBuilder()
                                    // Month is 0 based so add 1
                                    .append(dayOfMonth).append("/").append(monthOfYear + 1).append("/").append(year).append(" "));
                        }
                    };
                    @Override
                    public void onClick(View v) {
                        new DatePickerDialog(Button2Activity.this, date, myCalendar
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

                            edit_data_4.setText(new StringBuilder()
                                    // Month is 0 based so add 1
                                    .append(dayOfMonth).append("/").append(monthOfYear + 1).append("/").append(year).append(" "));
                        }
                    };
                    @Override
                    public void onClick(View v) {
                        new DatePickerDialog(Button2Activity.this, date, myCalendar
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

                            edit_data_5.setText(new StringBuilder()
                                    // Month is 0 based so add 1
                                    .append(dayOfMonth).append("/").append(monthOfYear + 1).append("/").append(year).append(" "));
                        }
                    };
                    @Override
                    public void onClick(View v) {
                        new DatePickerDialog(Button2Activity.this, date, myCalendar
                                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                    }
                });
                checktype(ndhb,nd1b,nd2b,nd3b,nd4b,nd5b);

                edit_data_h.setText(arrayList.get(position).getDatah());
                tdh.setText(table_1);
                if(count==1){
                    l1.setVisibility(View.VISIBLE);
                    l2.setVisibility(View.GONE);
                    l3.setVisibility(View.GONE);
                    l4.setVisibility(View.GONE);
                    l5.setVisibility(View.GONE);
                    checktype(ndhb,nd1b,nd2b,nd3b,nd4b,nd5b);
                    edit_data_1.setText(arrayList.get(position).getData1());
                    td1.setText(table_2);


                }
                else if(count==2){
                    l1.setVisibility(View.VISIBLE);
                    l2.setVisibility(View.VISIBLE);
                    l3.setVisibility(View.GONE);
                    l4.setVisibility(View.GONE);
                    l5.setVisibility(View.GONE);
                    checktype(ndhb,nd1b,nd2b,nd3b,nd4b,nd5b);

                    edit_data_1.setText(arrayList.get(position).getData1());
                    edit_data_2.setText(arrayList.get(position).getData2());

                    td1.setText(table_2);
                    td2.setText(table_3);

                }
                if(count==3){
                    l1.setVisibility(View.VISIBLE);
                    l2.setVisibility(View.VISIBLE);
                    l3.setVisibility(View.VISIBLE);
                    l4.setVisibility(View.GONE);
                    l5.setVisibility(View.GONE);
                    checktype(ndhb,nd1b,nd2b,nd3b,nd4b,nd5b);

                    edit_data_1.setText(arrayList.get(position).getData1());
                    edit_data_2.setText(arrayList.get(position).getData2());
                    edit_data_3.setText(arrayList.get(position).getData3());

                    td1.setText(table_2);
                    td2.setText(table_3);
                    td3.setText(table_4);


                }
                if(count==4){
                    l1.setVisibility(View.VISIBLE);
                    l2.setVisibility(View.VISIBLE);
                    l3.setVisibility(View.VISIBLE);
                    l4.setVisibility(View.VISIBLE);
                    l5.setVisibility(View.GONE);

                    checktype(ndhb,nd1b,nd2b,nd3b,nd4b,nd5b);

                    edit_data_1.setText(arrayList.get(position).getData1());
                    edit_data_2.setText(arrayList.get(position).getData2());
                    edit_data_3.setText(arrayList.get(position).getData3());
                    edit_data_4.setText(arrayList.get(position).getData4());

                    td1.setText(table_2);
                    td2.setText(table_3);
                    td3.setText(table_4);
                    td4.setText(table_5);
                }
                if(count==5){
                    l1.setVisibility(View.VISIBLE);
                    l2.setVisibility(View.VISIBLE);
                    l3.setVisibility(View.VISIBLE);
                    l4.setVisibility(View.VISIBLE);
                    l5.setVisibility(View.VISIBLE);
                    checktype(ndhb,nd1b,nd2b,nd3b,nd4b,nd5b);

                    edit_data_1.setText(arrayList.get(position).getData1());
                    edit_data_2.setText(arrayList.get(position).getData2());
                    edit_data_3.setText(arrayList.get(position).getData3());
                    edit_data_4.setText(arrayList.get(position).getData4());
                    edit_data_5.setText(arrayList.get(position).getData5());

                    td1.setText(table_2);
                    td2.setText(table_3);
                    td3.setText(table_4);
                    td4.setText(table_5);
                    td5.setText(table_6);
                }


                if(arrayList.get(position).getStatus().equals("beklemede"))
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
                        if(count==4) {
                            result=databaseHelper.editData(edit_data_h.getText().toString(),edit_data_1.getText().toString(),edit_data_2.getText().toString(),edit_data_3.getText().toString(),edit_data_4.getText().toString(),arrayList.get(position).getId(),onay);
                        }
                        if(count==5) {
                            result=databaseHelper.editData(edit_data_h.getText().toString(),edit_data_1.getText().toString(),edit_data_2.getText().toString(),edit_data_3.getText().toString(),edit_data_4.getText().toString(),edit_data_5.getText().toString(),arrayList.get(position).getId(),onay);
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
