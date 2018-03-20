package com.example.abhi.rajasthantourplan;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class transport_new extends AppCompatActivity {

    LinearLayout air, rail, road;
    Button b1;
    static int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_new);
        air = findViewById(R.id.air);
        b1=(Button)findViewById(R.id.button);
        rail = findViewById(R.id.rail);
        road = findViewById(R.id.road);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(transport_new.this,hotels.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
            }
        });
        air.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 1;
                Intent i = new Intent(transport_new.this, webview.class);
                startActivity(i);
            }
        });
        rail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 2;
                Intent i = new Intent(transport_new.this, webview.class);
                startActivity(i);
            }
        });
        road.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 3;
                Intent i = new Intent(transport_new.this, webview.class);
                startActivity(i);
            }
        });
    }
}
