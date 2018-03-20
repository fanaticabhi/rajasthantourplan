package com.example.abhi.rajasthantourplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class hotels extends AppCompatActivity {

    Button book,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);
        book = findViewById(R.id.book_hotel);
        b2=(Button)findViewById(R.id.skip);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(hotels.this, secondcompletejsondata.class);
                startActivity(i);

            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transport_new.count = 4;
                Intent i = new Intent(hotels.this, webview.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(i);
            }
        });
    }
}
