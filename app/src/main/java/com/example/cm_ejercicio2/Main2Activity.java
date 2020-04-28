package com.example.cm_ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<Autos> autos = new ArrayList<Autos>();

    ListView lvAutos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lvAutos =(ListView) findViewById(R.id.lvAutos);

        Bundle bundle = new Bundle();

        bundle = getIntent().getExtras();

        autos = (ArrayList<Autos>) bundle.getSerializable("Autos");

        Log.d("MainActivity","Successful");

        AutosAdapter adaptador = new AutosAdapter(getApplicationContext(),autos);

        lvAutos.setAdapter(adaptador);

    }
}
