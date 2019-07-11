package cengcelil.datakent;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;
    ImageView imageView;
    EditText et_username,et_pass;
    Handler handler=new Handler();
    Button log_button;
    String username, password;
    Intent i;
    String url_ip="192.168.1.101";
    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";


    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            linearLayout.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.INVISIBLE);

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i=new Intent(this,SecondActivity.class);


        relativeLayout=findViewById(R.id.relative);
        linearLayout=findViewById(R.id.linear);
        imageView=findViewById(R.id.imageView2);
        et_username=findViewById(R.id.et_username);
        et_pass=findViewById(R.id.et_pass);
        log_button=findViewById(R.id.button);
        handler.postDelayed(runnable,2000);



        log_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username=et_username.getText().toString().trim();
                password=et_pass.getText().toString().trim();
                if(username.length()==0)
                {
                    et_username.setError("Kullanıcı adı kısmı boş bırakılamaz.");
                }
                else if(password.length() ==0)
                    et_pass.setError("Şifre kısmı boş bırakılamaz.");
                else{        finish();
                    startActivity(i);
                }

                    //veri_oku();
            }
        });


    }
    private void veri_oku(){
        String url="http://"+url_ip+"/datakent/datakent_login.php";

        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){

                    //go to next page}
                    finish();
                    startActivity(i);
                }
                else
                    Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put(KEY_USERNAME,username);
                map.put(KEY_PASSWORD,password);
                return map;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);

    }
}