package cengcelil.datakent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import cengcelil.Adapter.MyAdapter;
import cengcelil.Model.Datalar;

public class Button1Activity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    ListView listView;
    ArrayList<Datalar>arrayList;
    MyAdapter myAdapter;
    EditText et1,et2,et3,et4;
    Button new_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button1);
        new_data=findViewById(R.id.button6);
        listView=findViewById(R.id.listview);
        databaseHelper=new DatabaseHelper(this);
        arrayList=new ArrayList<>();
        LoadDataInListView();


    }

    private void LoadDataInListView() {
        arrayList=databaseHelper.getAllData();
        myAdapter=new MyAdapter(this,arrayList);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Button1Activity.this);
                View mView=getLayoutInflater().inflate(R.layout.dialog_items,null);
                final EditText edit_data_h=mView.findViewById(R.id.editText5);
                final EditText edit_data_1=mView.findViewById(R.id.editText6);
                final EditText edit_data_2=mView.findViewById(R.id.editText7);
                final EditText edit_data_3=mView.findViewById(R.id.editText8);
                final Button accept_edit=mView.findViewById(R.id.button7);
                final Button delete_edit=mView.findViewById(R.id.button8);



                edit_data_h.setText(arrayList.get(position).getDatah());
                edit_data_1.setText(arrayList.get(position).getData1());
                edit_data_2.setText(arrayList.get(position).getData2());
                edit_data_3.setText(arrayList.get(position).getData3());

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

                        boolean result=databaseHelper.editData(edit_data_h.getText().toString(),edit_data_1.getText().toString(),edit_data_2.getText().toString(),edit_data_3.getText().toString(),arrayList.get(position).getId());
                        if(result) {
                            Toast.makeText(Button1Activity.this, "Data edited", Toast.LENGTH_SHORT).show();
                            updateList();

                        }
                        else
                            Toast.makeText(Button1Activity.this, "Error", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();

                    }
                });
            }
        });
    }

    public void insert(View view) {
        boolean result=databaseHelper.insertData(et1.getText().toString(),et2.getText().toString(),et3.getText().toString(),et4.getText().toString());
        if(result) {
            Toast.makeText(Button1Activity.this, "Data inserted", Toast.LENGTH_SHORT).show();
            updateList();

        }
        else
            Toast.makeText(Button1Activity.this, "Error", Toast.LENGTH_SHORT).show();
    }

    public void updateList(){
        arrayList=databaseHelper.getAllData();
        myAdapter=new MyAdapter(this,arrayList);
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
        builder.setView(mView);
        final AlertDialog alertDialog=builder.create();
        alertDialog.show();
        new_data_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result=databaseHelper.insertData(new_data_h.getText().toString(),new_data_1.getText().toString(),new_data_2.getText().toString(),new_data_3.getText().toString());
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
