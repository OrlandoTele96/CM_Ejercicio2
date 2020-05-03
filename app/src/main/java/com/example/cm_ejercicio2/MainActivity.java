package com.example.cm_ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView tvTitle,tvModel,tvBrand,tvYear,tvStatus;
    EditText etModel,etYear;
    Spinner spBrand;
    RadioGroup radioGroup;
    RadioButton rbtnStatus;
    ImageButton ibtnAdd;

    Button btnCheckList;

    String brand;
    String status_choice;
    String ID;

    int i=4543554;

    Autos auto;

    ArrayList<Autos> autos = new ArrayList<Autos>();

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

        radioGroup=findViewById(R.id.radioGroup);

        ibtnAdd=findViewById(R.id.ibtnAdd);

        btnCheckList=findViewById(R.id.btnCheckList);


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


        ibtnAdd.setImageResource(R.drawable.add);

        spBrand.setOnItemSelectedListener(this);
        ibtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String year = etYear.getText().toString();
                String ID ="0";
                if(Validate(year,ID)){
                    i++;
                    ID=Integer.toString(i);
                    auto.setID(ID);
                    autos.add(auto);
                    Toast.makeText(MainActivity.this,getResources().getString(R.string.addcar),Toast.LENGTH_SHORT).show();
                    Log.d(getResources().getString(R.string.ma),getResources().getString(R.string.ma_item));

                }
                else {
                    Toast.makeText(MainActivity.this,getResources().getString(R.string.Error),Toast.LENGTH_SHORT).show();

                }


            }
        });

        btnCheckList.setText(getResources().getString(R.string.checklist));

        btnCheckList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (autos.size()==0){
                    Toast.makeText(MainActivity.this,getResources().getString(R.string.Error2),Toast.LENGTH_SHORT).show();
                    Log.d(getResources().getString(R.string.ma),getResources().getString(R.string.ma_error));
                }
                else {
                    //New activity
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(getResources().getString(R.string.autos), autos);
                    intent.putExtras(bundle);

                    startActivity(intent);
                }
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        brand = parent.getItemAtPosition(position).toString();

        Toast.makeText(this,brand,Toast.LENGTH_SHORT).show();

    }

    public void checkChoice(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();

        rbtnStatus = findViewById(radioId);

        status_choice=rbtnStatus.getText().toString();

        Toast.makeText(this,rbtnStatus.getText(),Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private boolean Validate(String year,String ID){
        if (etModel.getText().length()==0 || etYear.getText().length()==0){

            return false;
        }
        else{
            try {
                int y = Integer.parseInt(year);
                auto = new Autos(ID,etModel.getText().toString(),brand,status_choice,y);

            }catch (Exception e){

                return false;
            }
            if(auto.getYear()<=2020 && auto.getYear()>=1960)
            {
                return true;
            }
            else {
                Toast.makeText(MainActivity.this,getResources().getString(R.string.erroryear),Toast.LENGTH_SHORT).show();
                return false;
            }
        }
    }
}
