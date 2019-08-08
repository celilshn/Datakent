package cengcelil.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import cengcelil.Model.Datalar;
import cengcelil.datakent.R;

public class MyAdapter extends BaseAdapter {
    Context context;
    SharedPreferences sharedPreferences;
    int count;
    String table_1,table_2,table_3,table_4,table_5,table_6;

    public MyAdapter(Context context, ArrayList<Datalar> arrayList,int activity) {
        this.context = context;
        this.arrayList = arrayList;
        this.activity=activity;
    }

    ArrayList<Datalar> arrayList;
    int activity;
    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        sharedPreferences= context.getSharedPreferences("key", Context.MODE_PRIVATE);
        count=sharedPreferences.getInt("key_count",0);
        table_1=sharedPreferences.getString("key_table1","0");
        table_2=sharedPreferences.getString("key_table2","0");
        table_3=sharedPreferences.getString("key_table3","0");
        table_4=sharedPreferences.getString("key_table4","0");
        table_5=sharedPreferences.getString("key_table5","0");
        table_6=sharedPreferences.getString("key_table6","0");
        TextView txt_id = null, txt_h = null, txt_1 = null, txt_2 = null, txt_3 = null, txt_4 = null, txt_5 = null, txt_log_id = null, txt_date = null, txt_edit = null;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Datalar datalar = arrayList.get(position);

        if (activity == 1) {
            convertView = layoutInflater.inflate(R.layout.list_items_button1, null);
            txt_id = convertView.findViewById(R.id.textView_bt1_id);
            txt_h = convertView.findViewById(R.id.textView_bt1_h);
            txt_1 = convertView.findViewById(R.id.textView12);
            txt_1.setText(datalar.getData1());
            txt_id.setText(datalar.getId() + ".");
            txt_h.setText(datalar.getDatah());
        }else if (activity == 2 || activity==3) {
            convertView = layoutInflater.inflate(R.layout.list_items_button2, null);
            txt_id = convertView.findViewById(R.id.textView);
            txt_id.setText(datalar.getId() + ".");
            if(count == 0){
                txt_h = convertView.findViewById(R.id.textViewh);
                txt_h.setText(table_1+": "+datalar.getDatah());

            }
            else if(count == 1){
                txt_h = convertView.findViewById(R.id.textViewh);
                txt_h.setText(table_1+": "+datalar.getDatah());
                txt_1 = convertView.findViewById(R.id.textView1);
                txt_1.setVisibility(View.VISIBLE);

                txt_1.setText(table_2+": "+datalar.getData1());

            }
            else if(count == 2){
                txt_h = convertView.findViewById(R.id.textViewh);
                txt_h.setText(table_1+": "+datalar.getDatah());

                txt_1 = convertView.findViewById(R.id.textView1);
                txt_1.setVisibility(View.VISIBLE);

                txt_2 = convertView.findViewById(R.id.textView2);
                txt_2.setVisibility(View.VISIBLE);

                txt_1.setText(table_2+": "+datalar.getData1());
                txt_2.setText(table_3+": "+datalar.getData2());
            }

            else if(count == 3){
                txt_h = convertView.findViewById(R.id.textViewh);
                txt_h.setText(table_1+": "+datalar.getDatah());

                txt_1 = convertView.findViewById(R.id.textView1);
                txt_1.setVisibility(View.VISIBLE);

                txt_2 = convertView.findViewById(R.id.textView2);
                txt_2.setVisibility(View.VISIBLE);

                txt_3 = convertView.findViewById(R.id.textView3);
                txt_3.setVisibility(View.VISIBLE);

                txt_1.setText(table_2+": "+datalar.getData1());
                txt_2.setText(table_3+": "+datalar.getData2());
                txt_3.setText(table_4+": "+datalar.getData3());
            }

            else if(count == 4){
                txt_h = convertView.findViewById(R.id.textViewh);
                txt_h.setText(table_1+": "+datalar.getDatah());

                txt_1 = convertView.findViewById(R.id.textView1);
                txt_1.setVisibility(View.VISIBLE);

                txt_2 = convertView.findViewById(R.id.textView2);
                txt_2.setVisibility(View.VISIBLE);

                txt_3 = convertView.findViewById(R.id.textView3);
                txt_3.setVisibility(View.VISIBLE);

                txt_4 = convertView.findViewById(R.id.textView31);
                txt_4.setVisibility(View.VISIBLE);

                txt_1.setText(table_2+": "+datalar.getData1());
                txt_2.setText(table_3+": "+datalar.getData2());
                txt_3.setText(table_4+": "+datalar.getData3());
                txt_4.setText(table_5+": "+datalar.getData4());
            }
            else if(count == 5){
                txt_h = convertView.findViewById(R.id.textViewh);
                txt_h.setText(table_1+": "+datalar.getDatah());

                txt_1 = convertView.findViewById(R.id.textView1);
                txt_1.setVisibility(View.VISIBLE);

                txt_2 = convertView.findViewById(R.id.textView2);
                txt_2.setVisibility(View.VISIBLE);

                txt_3 = convertView.findViewById(R.id.textView3);
                txt_3.setVisibility(View.VISIBLE);

                txt_4 = convertView.findViewById(R.id.textView31);
                txt_4.setVisibility(View.VISIBLE);

                txt_5 = convertView.findViewById(R.id.textView32);
                txt_5.setVisibility(View.VISIBLE);

                txt_1.setText(table_2+": "+datalar.getData1());
                txt_2.setText(table_3+": "+datalar.getData2());
                txt_3.setText(table_4+": "+datalar.getData3());
                txt_4.setText(table_5+": "+datalar.getData4());
                txt_5.setText(table_6+": "+datalar.getData5());
            }


        } else if (activity == 4) {
            convertView = layoutInflater.inflate(R.layout.list_items_button4, null);
            txt_log_id = convertView.findViewById(R.id.textView23);
            txt_h = convertView.findViewById(R.id.textView9);
            txt_1 = convertView.findViewById(R.id.textView24);
            txt_edit = convertView.findViewById(R.id.textView26);
            txt_date = convertView.findViewById(R.id.textView27);
            String dh=datalar.getDatah();
            String d1=datalar.getData1();
            if (dh.equals(""))
                txt_h.setText("-");
            else
                txt_h.setText(dh);
            if (d1.equals(""))
                txt_1.setText("-");
            else
                txt_1.setText(d1);
            txt_log_id.setText(datalar.getLog_id());
            txt_edit.setText(datalar.getLog());
            txt_date.setText(datalar.getDate());
        }

        return convertView;
    }
}
