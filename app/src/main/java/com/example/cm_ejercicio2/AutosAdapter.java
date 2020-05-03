package com.example.cm_ejercicio2;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AutosAdapter extends BaseAdapter {

    Context contexto;

    private ArrayList<Autos> autos;

    private int [] logos = {
            R.drawable.ford,
            R.drawable.vw,
            R.drawable.chevrolet,
            R.drawable.audi,
            R.drawable.peugeot,
            R.drawable.kia,
            R.drawable.bmw
    };

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


        //TextView tvID_item = v.findViewById(R.id.tvID_item);
        TextView tvModel_item = v.findViewById(R.id.tvModel_item);
        TextView tvBrand_item = v.findViewById(R.id.tvBrand_item);
        TextView tvYear_item = v.findViewById(R.id.tvYear_item);
        TextView tvStatus_item = v.findViewById(R.id.tvStatus_item);

        ImageView ivLogo = v.findViewById(R.id.ivLogo);


        String y = Integer.toString(autos.get(position).getYear());

        //tvID_item.setText(autos.get(position).getID());
        tvModel_item.setText(autos.get(position).getModel());
        tvBrand_item.setText(autos.get(position).getBrand());
        tvYear_item.setText(y);
        tvStatus_item.setText(autos.get(position).getStatus());

        //ivLogo.setImageResource(R.drawable.ford);


        Log.d(contexto.getResources().getString(R.string.ma),contexto.getResources().getString(R.string.ma_brand)+autos.get(position).getBrand());
        if (autos.get(position).getBrand().equals(contexto.getResources().getString(R.string.ford)))
        {


            ivLogo.setImageBitmap(LoadImage.decodeSampledBitmapFromResource(contexto.getResources(),logos[0],50,50));
        }
        if (autos.get(position).getBrand().equals(contexto.getResources().getString(R.string.vw)))
        {


            ivLogo.setImageBitmap(LoadImage.decodeSampledBitmapFromResource(contexto.getResources(),logos[1],50,50));
        }
        if (autos.get(position).getBrand().equals(contexto.getResources().getString(R.string.chevrolet)))
        {


            ivLogo.setImageBitmap(LoadImage.decodeSampledBitmapFromResource(contexto.getResources(),logos[2],30,30));
        }
        if (autos.get(position).getBrand().equals(contexto.getResources().getString(R.string.audi)))
        {


            ivLogo.setImageBitmap(LoadImage.decodeSampledBitmapFromResource(contexto.getResources(),logos[3],50,50));
        }
        if (autos.get(position).getBrand().equals(contexto.getResources().getString(R.string.peugeot)))
        {


            ivLogo.setImageBitmap(LoadImage.decodeSampledBitmapFromResource(contexto.getResources(),logos[4],50,50));
        }
        if (autos.get(position).getBrand().equals(contexto.getResources().getString(R.string.kia)))
        {


            ivLogo.setImageBitmap(LoadImage.decodeSampledBitmapFromResource(contexto.getResources(),logos[5],50,50));
        }
        if (autos.get(position).getBrand().equals(contexto.getResources().getString(R.string.bmw)))
        {


            ivLogo.setImageBitmap(LoadImage.decodeSampledBitmapFromResource(contexto.getResources(),logos[6],50,50));
        }





        return v;
    }
}
