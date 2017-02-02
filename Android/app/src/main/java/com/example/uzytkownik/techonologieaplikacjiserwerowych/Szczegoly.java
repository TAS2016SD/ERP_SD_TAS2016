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

public class Szczegoly extends Activity {


    NetworkResponse errorRes;
    String stringData = "";
    RequestQueue requestQueue;
    String url = "http://tas2016.azurewebsites.net/mobile/order";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.szczegoly_zamowienia);

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
                            String id = client.getString("name");

                            String name = response.getString("id");

                            String order = response.getString("orderPrice");

                            JSONObject payer = response.getJSONObject("payer");
                            String name_payer = payer.getString("name");

                            JSONObject seller = response.getJSONObject("seller");
                            String name_seller = seller.getString("name");


                            TextView textView = (TextView) findViewById(R.id.id);
                            TextView textView2 = (TextView) findViewById(R.id.client);
                            TextView textView3 = (TextView) findViewById(R.id.payer);
                            TextView textView4 = (TextView) findViewById(R.id.seller);
                            //TextView textView5 = (TextView) findViewById(R.id.orderPrice);
                            textView.setText(id);
                            textView2.setText(name);
                            textView3.setText(name_payer);
                            textView4.setText(name_seller);
                            //textView5.setText(order);

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

       Button complement = (Button) findViewById(R.id.wyslij);
        complement.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
    }


    private void odp(JsonObjectRequest postRequest)
    {
        Volley.newRequestQueue(this).add(postRequest);
        //setListAdapter(null);

    }
}
