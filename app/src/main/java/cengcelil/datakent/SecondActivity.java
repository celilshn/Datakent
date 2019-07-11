package cengcelil.datakent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4;
    Intent intent_b1,intent_b2,intent_b3,intent_b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

        intent_b1=new Intent(this,Button1Activity.class);
        intent_b2=new Intent(this,Button2Activity.class);
        intent_b3=new Intent(this,Button3Activity.class);
        intent_b4=new Intent(this,Button4Activity.class);
    }

    @Override
    public void onClick(View v) {
        if(v==b1){
            startActivity(intent_b1);
            Toast.makeText(this, "Yeni veri girişi", Toast.LENGTH_SHORT).show();
        }
        else if(v==b2){
            startActivity(intent_b2);
            Toast.makeText(this, "Veri düzenlemesi", Toast.LENGTH_SHORT).show();

        }
        else if(v==b3){
            startActivity(intent_b3);
            Toast.makeText(this, "Onaylı Veriler", Toast.LENGTH_SHORT).show();

        }
        else if(v==b4){
            startActivity(intent_b4);
            Toast.makeText(this, "Onaylanmamış veriler", Toast.LENGTH_SHORT).show();

        }
    }
}
