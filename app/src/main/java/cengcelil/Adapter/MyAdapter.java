package cengcelil.Adapter;

import android.content.Context;
import android.graphics.Color;
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

        TextView txt_id = null, txt_h = null, txt_1 = null, txt_2 = null, txt_3 = null, txt_log_id = null, txt_date = null, txt_edit = null;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Datalar datalar = arrayList.get(position);

        if (activity == 1) {
            convertView = layoutInflater.inflate(R.layout.list_items_button1, null);
            txt_id = convertView.findViewById(R.id.textView_bt1_id);
            txt_h = convertView.findViewById(R.id.textView_bt1_h);
        } else if (activity == 4) {
            convertView = layoutInflater.inflate(R.layout.list_items_button4, null);
            txt_log_id = convertView.findViewById(R.id.textView23);
            txt_id = convertView.findViewById(R.id.textView24);
            txt_h = convertView.findViewById(R.id.textView25);
            txt_edit = convertView.findViewById(R.id.textView26);
            txt_date = convertView.findViewById(R.id.textView27);


        } else {
            convertView = layoutInflater.inflate(R.layout.list_items_button2, null);
            txt_id = convertView.findViewById(R.id.textView);
            txt_h = convertView.findViewById(R.id.textViewh);
            txt_1 = convertView.findViewById(R.id.textView1);
            txt_2 = convertView.findViewById(R.id.textView2);
            txt_3 = convertView.findViewById(R.id.textView3);
        }
        if (activity != 4) {
            txt_id.setText(datalar.getId() + ".");
            txt_h.setText(datalar.getDatah());
        }
        else
        {
            txt_log_id.setText(datalar.getLog_id());
            txt_id.setText(datalar.getId());
            txt_h.setText(datalar.getDatah());
            txt_edit.setText(datalar.getLog());
            txt_date.setText(datalar.getDate());
        }
        if(activity==2 || activity==3){
        txt_1.setText(datalar.getData1());
        txt_2.setText(datalar.getData2());
        txt_3.setText(datalar.getData3());}
        return convertView;
    }
}
