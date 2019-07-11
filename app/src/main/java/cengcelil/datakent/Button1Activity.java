package cengcelil.datakent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
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
        builder.setView(mView);
        final AlertDialog alertDialog=builder.create();
        alertDialog.show();
        new_data_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int onay;
                if(checked_data.isChecked())
                    onay=1;
                else
                    onay=0;
                boolean result=databaseHelper.insertData(new_data_h.getText().toString(),new_data_1.getText().toString(),new_data_2.getText().toString(),new_data_3.getText().toString(),onay);
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
