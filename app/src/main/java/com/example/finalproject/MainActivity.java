package com.example.finalproject;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Soccer> soccerList;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        fetchSoccer();
    }

    private void fetchSoccer() {

        String url = "https://www.scorebat.com/video-api/v1/";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                for (int i=0 ; i< response.length(); i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String title = jsonObject.getString("title");
                        String url = jsonObject.getString("url");
                        String date = jsonObject.getString("date");
                        String thumbnail = jsonObject.getString("thumbnail");
                        String competition = jsonObject.getString("competition");

                        Soccer soccer = new Soccer(title, thumbnail, url, date, competition);

                        soccerList.add(soccer);

                    } catch (JSONException e){
                        e.printStackTrace();
                    }
                    SoccerAdapter adapter = new SoccerAdapter(MainActivity.this,soccerList);

                    recyclerView.setAdapter(adapter);
                }

            }

            }, new Response.ErrorListener(){
                @Override
                        public void onErrorResponse(VolleyError error){
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                }

        });

        requestQueue.add(jsonArrayRequest);
    }
}
