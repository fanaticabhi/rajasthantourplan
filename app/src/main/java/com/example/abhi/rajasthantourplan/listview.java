package com.example.abhi.rajasthantourplan;

import android.content.Intent;
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
    static int choiceplaceindex;

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

       }
         customadapter ca = new customadapter(getApplicationContext(), place, place_type);
        lt.setAdapter(ca);

        lt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String s = lt.getItemAtPosition(i).toString();
                choiceplaceindex=i;

                Toast.makeText(listview.this, s, Toast.LENGTH_LONG).show();
                Intent intent=new Intent(listview.this,Events.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);

               // adapter.dismiss(); // If you want to close the adapter
            }
        });

    }


}
