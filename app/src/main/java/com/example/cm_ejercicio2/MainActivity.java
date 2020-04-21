package com.example.cm_ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle,tvModel,tvBrand,tvYear,tvStatus;
    EditText etModel,etYear;
    Button btnselectBrand,btnSelectStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle=findViewById(R.id.tvTitle);
        tvModel=findViewById(R.id.tvModel);
        tvBrand=findViewById(R.id.tvBrand);
        tvYear=findViewById(R.id.tvYear);
        tvStatus=findViewById(R.id.tvStatus);

        etModel=findViewById(R.id.etModel);
        etYear=findViewById(R.id.etYear);

        btnselectBrand=findViewById(R.id.btnSelectBrand);
        btnSelectStatus=findViewById(R.id.btnSelectStatus);


        tvTitle.setText(getResources().getString(R.string.instruction));
        tvModel.setText(getResources().getString(R.string.model));
        tvBrand.setText(getResources().getString(R.string.selectbrand));
        tvYear.setText(getResources().getString(R.string.year));
        tvStatus.setText(getResources().getString(R.string.selectstatus));

        etModel.setHint(getResources().getString(R.string.modexa));
        etYear.setHint(getResources().getString(R.string.exyear));

        btnselectBrand.setText(getResources().getString(R.string.btnbrand));
        btnSelectStatus.setText(getResources().getString(R.string.btnstat));


    }
}
