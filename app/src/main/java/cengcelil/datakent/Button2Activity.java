package cengcelil.datakent;

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
import android.widget.Toast;

import java.util.ArrayList;

import cengcelil.Adapter.MyAdapter;
import cengcelil.Model.Datalar;

public class Button2Activity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    ListView listView;
    ArrayList<Datalar> arrayList;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button2);
        listView=findViewById(R.id.listview_b2);
        databaseHelper=new DatabaseHelper(this);
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
                edit_data_1.setText(arrayList.get(position).getData1());
                edit_data_2.setText(arrayList.get(position).getData2());
                edit_data_3.setText(arrayList.get(position).getData3());
                if(arrayList.get(position).getOnay()==1)
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
                        int onay;
                        if(cheched_data.isChecked())
                            onay = 1;
                        else
                            onay = 0;
                        boolean result=databaseHelper.editData(edit_data_h.getText().toString(),edit_data_1.getText().toString(),edit_data_2.getText().toString(),edit_data_3.getText().toString(),arrayList.get(position).getId(),onay);
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
