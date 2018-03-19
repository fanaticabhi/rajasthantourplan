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

public class completejsondata extends AppCompatActivity {
    TextView t1;
    Button b1;
    static String city[];
    static String place[];
    static String place_type[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completejsondata);
        t1 = (TextView) findViewById(R.id.textview);
        b1 = (Button) findViewById(R.id.clickme);
        getjsondata();

        //Intent i=new Intent(completejsondata.this,listview.class);
        //startActivity(i);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setdata();
                Intent i = new Intent(completejsondata.this, listview.class);
                startActivity(i);

            }
        });


    }

    public void setdata() {
        for (int i = 0; i < place.length; i++)
            t1.setText(t1.getText() + "\n\n" + place[i] + "\t" + city[i]);
        // Intent i=new Intent(this,listview.class);
        // startActivity(i);
    }


    public void getjsondata() {

        JsonArrayRequest st = new JsonArrayRequest("http://www.rajasthantourplan.esy.es/phpfiles/retrieve.php", new Response.Listener<JSONArray>() {
            // @Override
            public void onResponse(JSONArray response) {
                get_response(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(completejsondata.this, "fatal error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue q = Volley.newRequestQueue(completejsondata.this);
        q.add(st);
    }


    public void get_response(JSONArray response) {
        city = new String[response.length()];
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
    }
}


