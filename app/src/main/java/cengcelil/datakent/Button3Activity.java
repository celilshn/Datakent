package cengcelil.datakent;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import cengcelil.Adapter.MyAdapter;
import cengcelil.Model.Datalar;

public class Button3Activity extends AppCompatActivity {
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
        arrayList=databaseHelper.getAllData_b3();
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
                textView_alert.setText("Verinin onayını iptal etmek için 'Onayı iptal et' butonuna tıklayınız");
                builder.setView(mView);
                final AlertDialog alertDialog=builder.create();
                alertDialog.show();
                button_yes.setText("Onayı iptal et");
                button_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean result=databaseHelper.editOnay(arrayList.get(position).getId(),0);
                        if(result)
                            Toast.makeText(Button3Activity.this, "Onay iptal edildi", Toast.LENGTH_SHORT).show();
                        updateList();
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

    public void updateList(){
        arrayList=databaseHelper.getAllData_b3();
        myAdapter=new MyAdapter(this,arrayList,3);
        listView.setAdapter(myAdapter);
    }
}
