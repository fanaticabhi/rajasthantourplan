package com.example.abhi.rajasthantourplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        Thread th=new Thread(){
            public void run(){
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent i=new Intent(launcher.this,touristplaces.class);
                    startActivity(i);
                }
            }
        };
        th.start();
    }
}
