package com.example.abhi.rajasthantourplan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class tourschedule extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourschedule);
        t1=(TextView)findViewById(R.id.city);
        t2=(TextView)findViewById(R.id.journey);
        t3=(TextView)findViewById(R.id.tourist);
        t4=(TextView)findViewById(R.id.placetype);
        t5=(TextView)findViewById(R.id.events);
        t6=(TextView)findViewById(R.id.eventtime);

        t1.setText(""+touristplaces.city);
        t2.setText(""+tourdates.startdate+" - "+tourdates.enddate);
        t3.setText(""+completejsondata.place[listview.choiceplaceindex]);
        t4.setText(""+completejsondata.place_type[listview.choiceplaceindex]);
        t5.setText(""+secondcompletejsondata.title[Events.choiceeventindex]);
        t6.setText(""+secondcompletejsondata.start[Events.choiceeventindex]+"  -  "+secondcompletejsondata.end[Events.choiceeventindex]);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
