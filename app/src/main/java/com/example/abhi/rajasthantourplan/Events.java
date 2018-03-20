package com.example.abhi.rajasthantourplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Events extends AppCompatActivity {

    static int choiceeventindex;
    ListView lt;
    ArrayList<String> ttl, cat, label, duration, start, end, loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        lt = findViewById(R.id.events);
        ttl = new ArrayList<String>();
        cat = new ArrayList<String>();
        label = new ArrayList<String>();
        duration = new ArrayList<String>();
        start = new ArrayList<String>();
        end = new ArrayList<String>();
        loc = new ArrayList<String>();

        //Code to add data to the dynamic list.

        for (int i = 0; i < secondcompletejsondata.title.length; i++) {
            // if (secondcompletejsondata.location[i].equals(completejsondata.city)) {
            //Toast.makeText(this, "Hey I am there", Toast.LENGTH_SHORT).show();
            ttl.add(secondcompletejsondata.title[i]);
            cat.add(secondcompletejsondata.category[i]);
            label.add(secondcompletejsondata.labels[i]);
            duration.add(secondcompletejsondata.duration[i]);
            start.add(secondcompletejsondata.start[i]);
            end.add(secondcompletejsondata.end[i]);
            loc.add(secondcompletejsondata.location[i]);

            // Toast.makeText(this, completejsondata.city[i], Toast.LENGTH_SHORT).show();
        }

        EventsListDesign e = new EventsListDesign(getApplicationContext(), ttl, cat, label, duration, start, end, loc);
        lt.setAdapter(e);


        lt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String s = lt.getItemAtPosition(i).toString();
                choiceeventindex = i;

                Toast.makeText(Events.this, s, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Events.this, tourschedule.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);

                // adapter.dismiss(); // If you want to close the adapter
            }
        });
    }
}
