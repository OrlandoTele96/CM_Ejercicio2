package com.example.cm_ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<Autos> autos = new ArrayList<Autos>();

    ListView lvAutos;
    Autos auto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lvAutos =(ListView) findViewById(R.id.lvAutos);

        Bundle bundle = new Bundle();

        bundle = getIntent().getExtras();

        autos = (ArrayList<Autos>) bundle.getSerializable(getResources().getString(R.string.autos));

        Log.d(getResources().getString(R.string.ma),getResources().getString(R.string.ma_succes));

        AutosAdapter adaptador = new AutosAdapter(getApplicationContext(),autos);

        lvAutos.setAdapter(adaptador);

        lvAutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                Toast.makeText(Main2Activity.this,"id : "+autos.get(position).getID(),Toast.LENGTH_SHORT).show();

            }
        });

    }
}
