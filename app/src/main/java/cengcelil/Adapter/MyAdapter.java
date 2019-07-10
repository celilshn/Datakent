package cengcelil.Adapter;

import android.content.Context;
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

    public MyAdapter(Context context, ArrayList<Datalar> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    ArrayList<Datalar> arrayList;

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

        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(R.layout.list_items,null);
        TextView txt_id=convertView.findViewById(R.id.textView);
        TextView txt_h=convertView.findViewById(R.id.textViewh);
        TextView txt_1=convertView.findViewById(R.id.textView1);
        TextView txt_2=convertView.findViewById(R.id.textView2);
        TextView txt_3=convertView.findViewById(R.id.textView3);

        Datalar datalar=arrayList.get(position);
        txt_id.setText(datalar.getId());
        txt_1.setText(datalar.getData1());
        txt_2.setText(datalar.getData2());
        txt_3.setText(datalar.getData3());
        txt_h.setText(datalar.getDatah());
        return convertView;
    }
}
