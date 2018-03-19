package com.example.abhi.rajasthantourplan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listview extends AppCompatActivity {

    ListView lt;
    ArrayList<String> place, place_type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

       lt = findViewById(R.id.listview1);
       place = new ArrayList<String>();
       place_type = new ArrayList<String>();
       for(int i=0;i<completejsondata.place.length;i++) {
           if(completejsondata.city[i].equals(touristplaces.city)) {
               //Toast.makeText(this, "Hey I am there", Toast.LENGTH_SHORT).show();
               place.add(completejsondata.place[i]);
               place_type.add(completejsondata.place_type[i]);
           }
          // Toast.makeText(this, completejsondata.city[i], Toast.LENGTH_SHORT).show();
       }

       //Code to add data to dynamic list.

        customadapter ca = new customadapter(getApplicationContext(), place, place_type);
        lt.setAdapter(ca);



    }
}
