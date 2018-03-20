package com.example.abhi.rajasthantourplan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class secondcompletejsondata extends AppCompatActivity {
    static String title[];
    static String category[];
    static String labels[];
    static String duration[];
    static String start[];
    static String end[];
    static String location[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondcompletejsondata);


        getjsondata();


        Intent i = new Intent(secondcompletejsondata.this,listview.class);
        startActivity(i);


    }


    public void getjsondata() {

        JsonArrayRequest st = new JsonArrayRequest("http://www.rajasthantourplan.esy.es/phpfiles/eventsretrieve.php", new Response.Listener<JSONArray>() {
            // @Override
            public void onResponse(JSONArray response) {
                get_response(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(secondcompletejsondata.this, "fatal error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue q = Volley.newRequestQueue(secondcompletejsondata.this);
        q.add(st);
    }


    public void get_response(JSONArray response) {
        title = new String[response.length()];
        category = new String[response.length()];
        labels = new String[response.length()];
        duration = new String[response.length()];
        start = new String[response.length()];
        end = new String[response.length()];
        location = new String[response.length()];

        try {
            //printing length of JSONArray

            for (int i = 0; i < response.length(); i++) {
                JSONObject object = (JSONObject) response.get(i);
                String title1 = object.getString("title");
                String category1 = object.getString("category");
                String label1 = object.getString("labels");
                String duration1 = object.getString("duration");
                String start1 = object.getString("start");
                String end1 = object.getString("end");
                String location1 = object.getString("location");
                title[i] = title1;
                category[i] = category1;
                labels[i] = label1;
                duration[i] = duration1;
                start[i] = start1;
                end[i] = end1;
                location[i] = location1;


            }
        } catch (Exception e) {
            Toast.makeText(secondcompletejsondata.this, "fatal error" + e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}





