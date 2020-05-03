package com.example.cm_ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Activity_splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread timer = new Thread(){
          public void run()
          {
              try {
                sleep(3000);
              }catch(Exception e){

              }finally {
                  Intent intent = new Intent(Activity_splash.this, MainActivity.class);
                  startActivity(intent);
                  finish();
              }
          }
        };

        timer.start();
    }
}
