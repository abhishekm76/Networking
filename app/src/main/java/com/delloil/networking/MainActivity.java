package com.delloil.networking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private RequestQueue requestQueue;
    private String url, urlarray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
        url ="https://jsonplaceholder.typicode.com/todos/1";
        urlarray ="https://jsonplaceholder.typicode.com/todos";



        /*

        public JsonObjectRequest(
            int method,
            String url,
            @Nullable JSONObject jsonRequest,
            Listener<JSONObject> listener,
            @Nullable ErrorListener errorListener)
         */

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("JSOSN","response "+ response);
                    }
                },
                new Response.ErrorListener() {
                      @Override
                     public void onErrorResponse(VolleyError error) { }
        });

       requestQueue.add(jsonObjectRequest);

            /*

                public JsonArrayRequest(
            int method,
            String url,
            @Nullable JSONArray jsonRequest,
            Listener<JSONArray> listener,
            @Nullable ErrorListener errorListener) {

             */
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                urlarray,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("JSOSN","Array response "+ response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {  Log.d("JSOSN","Array error " );}
                });

        requestQueue.add(jsonArrayRequest);

    }




}
