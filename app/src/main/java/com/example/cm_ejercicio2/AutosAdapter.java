package com.example.cm_ejercicio2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AutosAdapter extends BaseAdapter {

    Context contexto;

    private ArrayList<Autos> autos;

    public AutosAdapter(Context contexto, ArrayList<Autos> autos) {
        this.contexto = contexto;
        this.autos = autos;
    }

    @Override
    public int getCount() {
        return autos.size();
    }

    @Override
    public Object getItem(int position) {
        return autos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(contexto,R.layout.item_list,null);

        TextView tvModel_item = v.findViewById(R.id.tvModel_item);
        TextView tvBrand_item = v.findViewById(R.id.tvBrand_item);
        TextView tvYear_item = v.findViewById(R.id.tvYear_item);
        TextView tvStatus_item = v.findViewById(R.id.tvStatus_item);


        String y = Integer.toString(autos.get(position).getYear());

        tvModel_item.setText(autos.get(position).getModel());
        tvBrand_item.setText(autos.get(position).getBrand());
        tvYear_item.setText(y);
        tvStatus_item.setText(autos.get(position).getStatus());




        return v;
    }
}
