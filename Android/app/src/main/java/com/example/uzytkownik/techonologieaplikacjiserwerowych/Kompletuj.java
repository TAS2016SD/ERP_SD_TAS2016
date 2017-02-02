package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;

/**
 * Created by domir on 2/2/2017.
 */

public class Kompletuj extends Activity{

    NetworkResponse errorRes;
    String stringData = "";
    RequestQueue requestQueue;
    String url = "http://tas2016.azurewebsites.net/mobile/order";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.kompletuj_zamowienie);

        final CookieManager manager = new CookieManager();
        CookieHandler.setDefault(manager);

        requestQueue = Volley.newRequestQueue(this);
        ///////////////////////////////////GET - SZUKAJ////////////////////////////////////////////////
        JsonObjectRequest req2 = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject client = response.getJSONObject("client");
                            String id = response.getString("id");
                            String name = client.getString("name");
                            TextView textView = (TextView) findViewById(R.id.id_zamowienia);
                            TextView textView2 = (TextView) findViewById(R.id.nazwa_clienta);
                            textView.setText(id);
                            textView2.setText(name);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                errorRes = error.networkResponse;
                if (errorRes != null && errorRes.data != null) {
                    try {
                        stringData = new String(errorRes.data, "UTF-8");
                        //showErrorToast();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                Log.e("Error", stringData);
            }
        });
        odp(req2);

        Button complement = (Button) findViewById(R.id.wybierz);
        complement.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kompletuj.this, Szczegoly.class);
                startActivity(intent);
            }
        });
    }


    private void odp(JsonObjectRequest postRequest)
    {
        Volley.newRequestQueue(this).add(postRequest);
        //setListAdapter(null);

    }
}
