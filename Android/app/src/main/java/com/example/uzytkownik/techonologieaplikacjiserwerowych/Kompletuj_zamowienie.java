package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by uzytkownik on 04.01.2017.
 */

public class Kompletuj_zamowienie  extends ListActivity {

    String url = "http://tas2016.azurewebsites.net/mobile/order";
    RequestQueue requestQueue;
    NetworkResponse errorRes;
    String stringData = "";


    static final List<String> nazwa_clienta = new ArrayList<String>();
    static final List<String> id_zamowienia = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final CookieManager manager = new CookieManager();
        CookieHandler.setDefault( manager  );
        requestQueue = Volley.newRequestQueue(this);

        ///////////////////////////////////GET - SZUKAJ////////////////////////////////////////////////
        JsonObjectRequest req2 = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject client = response.getJSONObject("client");
                            String name = client.getString("name");
                            String id = response.getString("id");
                            nazwa_clienta.add(name);
                            id_zamowienia.add(id);
                            //System.out.println(name);
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
    }

    private void odp(JsonObjectRequest postRequest)
    {
        Volley.newRequestQueue(this).add(postRequest);
        setListAdapter(new KompletujAdapter(this, nazwa_clienta, id_zamowienia));

    }
}
