package cengcelil.datakent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Locale;
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
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static Boolean firstTime = null;
    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";
    public static final String URL_IP="192.168.1.102";


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

                username=et_username.getText() .toString().trim();
                password=et_pass.getText() .toString().trim();
                if(username.length()==0)
                {
                    et_username.setError("Kullanıcı adı kısmı boş bırakılamaz.");
                }
                else if(password.length() ==0)
                    et_pass.setError("Şifre kısmı boş bırakılamaz.");
                else{

                    veri_oku();
                }

            }
        });


    }


    private void veri_oku(){
        String url="http://"+URL_IP+"/datakent/datakent_login.php";

        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){

                    isFirstTime();

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
    private boolean isFirstTime() {
        if (firstTime == null) {
            final SharedPreferences mPreferences = this.getSharedPreferences("first_time_", Context.MODE_PRIVATE);
            firstTime = mPreferences.getBoolean("firstTime", true);
            if (firstTime) {
                // Code to run once
                String spinner_select[]= new String[2];
                String spinner_list[] = new String[6];
                spinner_list[0] = "1 Kolon";
                spinner_list[1] = "2 Kolon";
                spinner_list[2] = "3 Kolon";
                spinner_list[3] = "4 Kolon";
                spinner_list[4] = "5 Kolon";
                spinner_list[5] = "6 Kolon";
                spinner_select[0]="Metin";
                spinner_select[1]="Tarih";

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_options, null);

                final Spinner spinner = mView.findViewById(R.id.spinner);
                ArrayAdapter spinner_adapter = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, spinner_list);
                spinner.setAdapter(spinner_adapter);
                final Spinner spinner3 = mView.findViewById(R.id.spinner3);
                final Spinner spinner4 = mView.findViewById(R.id.spinner4);
                final Spinner spinner5 = mView.findViewById(R.id.spinner5);
                final Spinner spinner6 = mView.findViewById(R.id.spinner6);
                final Spinner spinner7 = mView.findViewById(R.id.spinner7);
                final Spinner spinner8 = mView.findViewById(R.id.spinner8);
                ArrayAdapter spa= new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, spinner_select);
                spinner3.setAdapter(spa);
                spinner4.setAdapter(spa);
                spinner5.setAdapter(spa);
                spinner6.setAdapter(spa);
                spinner7.setAdapter(spa);
                spinner8.setAdapter(spa);
                final EditText col_name_1 = mView.findViewById(R.id.editText9);
                final EditText col_name_2 = mView.findViewById(R.id.editText10);
                final EditText col_name_3 = mView.findViewById(R.id.editText11);
                final EditText col_name_4 = mView.findViewById(R.id.editText12);
                final EditText col_name_5 = mView.findViewById(R.id.editText13);
                final EditText col_name_6 = mView.findViewById(R.id.editText14);




                final Button button = mView.findViewById(R.id.button6);


                builder.setView(mView);
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        int selected = parent.getSelectedItemPosition();

                        if (selected == 0) {
                            col_name_1.setVisibility(View.VISIBLE);
                            col_name_2.setVisibility(View.INVISIBLE);
                            col_name_3.setVisibility(View.INVISIBLE);
                            col_name_4.setVisibility(View.INVISIBLE);
                            col_name_5.setVisibility(View.INVISIBLE);
                            col_name_6.setVisibility(View.INVISIBLE);

                            spinner3.setVisibility(View.VISIBLE);
                            spinner4.setVisibility(View.INVISIBLE);
                            spinner5.setVisibility(View.INVISIBLE);
                            spinner6.setVisibility(View.INVISIBLE);
                            spinner7.setVisibility(View.INVISIBLE);
                            spinner8.setVisibility(View.INVISIBLE);

                            col_name_1.setText("a");
                        } else if (selected == 1) {
                            col_name_1.setVisibility(View.VISIBLE);
                            col_name_2.setVisibility(View.VISIBLE);
                            col_name_3.setVisibility(View.INVISIBLE);
                            col_name_4.setVisibility(View.INVISIBLE);
                            col_name_5.setVisibility(View.INVISIBLE);
                            col_name_6.setVisibility(View.INVISIBLE);

                            spinner3.setVisibility(View.VISIBLE);
                            spinner4.setVisibility(View.VISIBLE);
                            spinner5.setVisibility(View.INVISIBLE);
                            spinner6.setVisibility(View.INVISIBLE);
                            spinner7.setVisibility(View.INVISIBLE);
                            spinner8.setVisibility(View.INVISIBLE);
                            col_name_1.setText("a");
                            col_name_2.setText("b");


                        } else if (selected == 2) {
                            col_name_1.setVisibility(View.VISIBLE);
                            col_name_2.setVisibility(View.VISIBLE);
                            col_name_3.setVisibility(View.VISIBLE);
                            col_name_4.setVisibility(View.INVISIBLE);
                            col_name_5.setVisibility(View.INVISIBLE);
                            col_name_6.setVisibility(View.INVISIBLE);

                            spinner3.setVisibility(View.VISIBLE);
                            spinner4.setVisibility(View.VISIBLE);
                            spinner5.setVisibility(View.VISIBLE);
                            spinner6.setVisibility(View.INVISIBLE);
                            spinner7.setVisibility(View.INVISIBLE);
                            spinner8.setVisibility(View.INVISIBLE);

                            col_name_1.setText("a");
                            col_name_2.setText("b");
                            col_name_3.setText("c");


                        } else if (selected == 3) {
                            col_name_1.setVisibility(View.VISIBLE);
                            col_name_2.setVisibility(View.VISIBLE);
                            col_name_3.setVisibility(View.VISIBLE);
                            col_name_4.setVisibility(View.VISIBLE);
                            col_name_5.setVisibility(View.INVISIBLE);
                            col_name_6.setVisibility(View.INVISIBLE);

                            spinner3.setVisibility(View.VISIBLE);
                            spinner4.setVisibility(View.VISIBLE);
                            spinner5.setVisibility(View.VISIBLE);
                            spinner6.setVisibility(View.VISIBLE);
                            spinner7.setVisibility(View.INVISIBLE);
                            spinner8.setVisibility(View.INVISIBLE);

                            col_name_1.setText("a");
                            col_name_2.setText("b");
                            col_name_3.setText("c");
                            col_name_4.setText("d");

                        } else if (selected == 4) {
                            col_name_1.setVisibility(View.VISIBLE);
                            col_name_2.setVisibility(View.VISIBLE);
                            col_name_3.setVisibility(View.VISIBLE);
                            col_name_4.setVisibility(View.VISIBLE);
                            col_name_5.setVisibility(View.VISIBLE);
                            col_name_6.setVisibility(View.INVISIBLE);

                            spinner3.setVisibility(View.VISIBLE);
                            spinner4.setVisibility(View.VISIBLE);
                            spinner5.setVisibility(View.VISIBLE);
                            spinner6.setVisibility(View.VISIBLE);
                            spinner7.setVisibility(View.VISIBLE);
                            spinner8.setVisibility(View.INVISIBLE);

                            col_name_1.setText("a");
                            col_name_2.setText("b");
                            col_name_3.setText("c");
                            col_name_4.setText("d");
                            col_name_5.setText("e");

                        } else if (selected == 5) {
                            col_name_1.setVisibility(View.VISIBLE);
                            col_name_2.setVisibility(View.VISIBLE);
                            col_name_3.setVisibility(View.VISIBLE);
                            col_name_4.setVisibility(View.VISIBLE);
                            col_name_5.setVisibility(View.VISIBLE);
                            col_name_6.setVisibility(View.VISIBLE);

                            spinner3.setVisibility(View.VISIBLE);
                            spinner4.setVisibility(View.VISIBLE);
                            spinner5.setVisibility(View.VISIBLE);
                            spinner6.setVisibility(View.VISIBLE);
                            spinner7.setVisibility(View.VISIBLE);
                            spinner8.setVisibility(View.VISIBLE);

                            col_name_1.setText("a");
                            col_name_2.setText("b");
                            col_name_3.setText("c");
                            col_name_4.setText("d");
                            col_name_5.setText("e");
                            col_name_6.setText("f");


                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                sharedPreferences = getSharedPreferences("key", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selected = spinner.getSelectedItemPosition();
                        Locale trlocale = new Locale("tr-TR");

                        if (selected == 0) {

                            editor.putString("key_table1", String.valueOf(String.valueOf(col_name_1.getText()).replaceAll(" ", "_").toCharArray()).toLowerCase(trlocale));
                            editor.putInt("key_count", selected);


                        } else if (selected == 1) {
                            editor.putString("key_table1", String.valueOf(String.valueOf(col_name_1.getText()).replaceAll(" ", "_").toCharArray()).toLowerCase(trlocale));
                            editor.putString("key_table2", String.valueOf(String.valueOf(col_name_2.getText()).replaceAll(" ", "_").toCharArray()).toLowerCase(trlocale));
                            editor.putInt("key_count", selected);


                        } else if (selected == 2) {
                            editor.putString("key_table1", String.valueOf(String.valueOf(col_name_1.getText()).replaceAll(" ", "_").toCharArray()).toLowerCase(trlocale));
                            editor.putString("key_table2", String.valueOf(String.valueOf(col_name_2.getText()).replaceAll(" ", "_").toCharArray()).toLowerCase(trlocale));
                            editor.putString("key_table3", String.valueOf(String.valueOf(col_name_3.getText()).replaceAll(" ", "_").toCharArray()));
                            editor.putInt("key_count", selected);

                        } else if (selected == 3) {
                            editor.putString("key_table1", String.valueOf(String.valueOf(col_name_1.getText()).replaceAll(" ", "_").toCharArray()));
                            editor.putString("key_table2", String.valueOf(String.valueOf(col_name_2.getText()).replaceAll(" ", "_").toCharArray()));
                            editor.putString("key_table3", String.valueOf(String.valueOf(col_name_3.getText()).replaceAll(" ", "_").toCharArray()));
                            editor.putString("key_table4", String.valueOf(String.valueOf(col_name_4.getText()).replaceAll(" ", "_").toCharArray()));
                            editor.putInt("key_count", selected);


                        } else if (selected == 4) {
                            editor.putString("key_table1", String.valueOf(String.valueOf(col_name_1.getText()).replaceAll(" ", "_").toCharArray()).toLowerCase(trlocale));
                            editor.putString("key_table2", String.valueOf(String.valueOf(col_name_2.getText()).replaceAll(" ", "_").toCharArray()).toLowerCase(trlocale));
                            editor.putString("key_table3", String.valueOf(String.valueOf(col_name_3.getText()).replaceAll(" ", "_").toCharArray()).toLowerCase(trlocale));
                            editor.putString("key_table4", String.valueOf(String.valueOf(col_name_4.getText()).replaceAll(" ", "_").toCharArray()).toLowerCase(trlocale));
                            editor.putString("key_table5", String.valueOf(String.valueOf(col_name_5.getText()).replaceAll(" ", "_").toCharArray()).toLowerCase(trlocale));
                            editor.putInt("key_count", selected);


                        } else if (selected == 5) {
                            editor.putString("key_table1", String.valueOf(String.valueOf(col_name_1.getText()).replaceAll(" ", "_").toCharArray()).toLowerCase(trlocale));
                            editor.putString("key_table2", String.valueOf(String.valueOf(col_name_2.getText()).replaceAll(" ", "_").toCharArray()).toLowerCase(trlocale));
                            editor.putString("key_table3", String.valueOf(String.valueOf(col_name_3.getText()).replaceAll(" ", "_").toCharArray()).toLowerCase(trlocale));
                            editor.putString("key_table4", String.valueOf(String.valueOf(col_name_4.getText()).replaceAll(" ", "_").toCharArray()).toLowerCase(trlocale));
                            editor.putString("key_table5", String.valueOf(String.valueOf(col_name_5.getText()).replaceAll(" ", "_").toCharArray()).toLowerCase(trlocale));
                            editor.putString("key_table6", String.valueOf(String.valueOf(col_name_6.getText()).replaceAll(" ", "_").toCharArray()).toLowerCase(trlocale));
                            editor.putInt("key_count", selected);
                        }

                        if(spinner3.getSelectedItemPosition()==0)
                            editor.putString("key_type1","String");
                        else
                            editor.putString("key_type1","Date");

                        if(spinner4.getSelectedItemPosition()==0)
                            editor.putString("key_type2","String");
                        else
                            editor.putString("key_type2","Date");

                        if(spinner5.getSelectedItemPosition()==0)
                            editor.putString("key_type3","String");
                        else
                            editor.putString("key_type3","Date");

                        if(spinner6.getSelectedItemPosition()==0)
                            editor.putString("key_type4","String");
                        else
                            editor.putString("key_type4","Date");

                        if(spinner7.getSelectedItemPosition()==0)
                            editor.putString("key_type5","String");
                        else
                            editor.putString("key_type5","Date");

                        if(spinner8.getSelectedItemPosition()==0)
                            editor.putString("key_type6","String");
                        else
                            editor.putString("key_type6","Date");
                        editor.commit();
                        //JUST SHOW FİRST TİME
                        alertDialog.dismiss();
                        SharedPreferences.Editor editor = mPreferences.edit();
                        editor.putBoolean("firstTime", false);
                        editor.commit();

                        finish();
                        startActivity(i);

                    }
                });
            }
            else
            {

                finish();
                startActivity(i);
            }


        }
        return firstTime;
    }

}