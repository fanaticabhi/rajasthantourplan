package com.example.abhi.rajasthantourplan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
import java.util.ArrayList;

public class apionlinedata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apionlinedata);
    }


    public void getjsondata() {

        JsonArrayRequest st = new JsonArrayRequest("http://www.rajasthantourplan.esy.es/phpfiles/demo.py", new Response.Listener<JSONArray>() {
            // @Override
            public void onResponse(JSONArray response) {
                get_response(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(apionlinedata.this, "fatal error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue q = Volley.newRequestQueue(apionlinedata.this);
        q.add(st);
    }


    public void get_response(JSONArray response) {
    /*    city = new String[response.length()];
        place = new String[response.length()];
        place_type = new String[response.length()];

        try {
            //printing length of JSONArray
            // t.setText("" + response.length());
            for (int i = 0; i < response.length(); i++) {
                JSONObject object = (JSONObject) response.get(i);
                String city1 = object.getString("city");
                String place1 = object.getString("place");
                String place_type1 = object.getString("place_type");
                city[i] = city1;
                place[i] = place1;
                place_type[i] = place_type1;
                // setdata(i);

            }
        } catch (Exception e) {
            Toast.makeText(completejsondata.this, "fatal error" + e.toString(), Toast.LENGTH_SHORT).show();
        }
    }*/
    }
}
