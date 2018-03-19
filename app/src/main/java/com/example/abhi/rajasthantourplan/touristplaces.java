package com.example.abhi.rajasthantourplan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class touristplaces extends AppCompatActivity {
    Spinner s1;
    static String data[];
    static String city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touristplaces);

        s1 = (Spinner) findViewById(R.id.spinner);
        getjsondata();


 }


    public void spinnerarray(){
        ArrayAdapter<String> arr = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, data);
        s1.setAdapter(arr);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Toast.makeText(touristplaces.this,"Please Select a City",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(touristplaces.this, "" + data[i], Toast.LENGTH_SHORT).show();

                    city = (String)s1.getItemAtPosition(i);
                    Toast.makeText(touristplaces.this, "Hey I selected " + city, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(touristplaces.this, completejsondata.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });
    }


    public void getjsondata() {

        JsonArrayRequest st = new JsonArrayRequest("http://www.rajasthantourplan.esy.es/phpfiles/retrievecity.php", new Response.Listener<JSONArray>() {
            // @Override
            public void onResponse(JSONArray response) {
                get_response(response);
                spinnerarray();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(touristplaces.this,"fatal error" + error.toString(),Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue q = Volley.newRequestQueue(touristplaces.this);
        q.add(st);
    }


    public void get_response(JSONArray response) {
        data = new String[response.length()+1];
        data[0]="select city";

        try {
            //printing length of JSONArray
            // t.setText("" + response.length());
            for (int i = 0; i < response.length(); i++) {
                JSONObject object = (JSONObject) response.get(i);
                String name = object.getString("city");
                data[i+1] = name;
            //    t.setText(t.getText() + "\n" + name);
            }
        } catch (Exception e) {
            Toast.makeText(touristplaces.this,"fatal error" + e.toString(),Toast.LENGTH_SHORT).show();
        }
    }
}
