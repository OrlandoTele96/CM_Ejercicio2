package com.example.cm_ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView tvTitle,tvModel,tvBrand,tvYear,tvStatus;
    EditText etModel,etYear;
    Spinner spBrand,spStatus;
    ImageButton ibtnAdd;

    String brand;

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

        spBrand=findViewById(R.id.spBrand);
        spStatus=findViewById(R.id.spStatus);

        ibtnAdd=findViewById(R.id.ibtnAdd);


        tvTitle.setText(getResources().getString(R.string.instruction));
        tvModel.setText(getResources().getString(R.string.model));
        tvBrand.setText(getResources().getString(R.string.selectbrand));
        tvYear.setText(getResources().getString(R.string.year));
        tvStatus.setText(getResources().getString(R.string.selectstatus));

        etModel.setHint(getResources().getString(R.string.modexa));
        etYear.setHint(getResources().getString(R.string.exyear));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Brands,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBrand.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.Status,android.R.layout.simple_spinner_item);
        spStatus.setAdapter(adapter2);

        ibtnAdd.setImageResource(R.drawable.add);

        spBrand.setOnItemSelectedListener(this);
        ibtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(MainActivity.this,brand,Toast.LENGTH_SHORT).show();
                }
                catch(Exception e)
                {
                    Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        brand = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
