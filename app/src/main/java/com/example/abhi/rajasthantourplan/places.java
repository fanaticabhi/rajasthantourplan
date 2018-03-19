package com.example.abhi.rajasthantourplan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class places extends AppCompatActivity {
    ListView l1;
    TextView t1,t2;
    Button b1;
    static String city[];
    static String place[];
    static String place_type[];
    CustomAdapter ca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        getjsondata();
        l1 = (ListView) findViewById(R.id.listview1);

       // b1=(Button)findViewById(R.id.buton);
        //createlist();
      /*  b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createlist();
            }
        });
*/


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
                Toast.makeText(places.this,"fatal error" + error.toString(),Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue q = Volley.newRequestQueue(places.this);
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
            Toast.makeText(places.this,"fatal error" + e.toString(),Toast.LENGTH_SHORT).show();
        }
    }



    public void createlist() {
        ca = new CustomAdapter();
        l1.setAdapter(ca);
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return place.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customrow, null);

          //  TextView t1 = (TextView) view.findViewById(R.id.textView1);
          //  TextView t2 = (TextView) view.findViewById(R.id.textView2);
         //   t1.setText("" + place[i]);
          //  t2.setText("" + place_type[i]);


            return null;
        }
    }
}


