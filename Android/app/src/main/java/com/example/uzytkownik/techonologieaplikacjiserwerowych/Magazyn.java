package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
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
 * Created by domir on 2/1/2017.
 */

public class Magazyn extends ListActivity {

    String url = "http://tas2016.azurewebsites.net/warehousestatus";
    RequestQueue requestQueue;
    NetworkResponse errorRes;
    String stringData = "";


    static final List<String> nazwa_materialu = new ArrayList<String>();
    static final List<String> liczba = new ArrayList<String>();
    static final List<String> koszt = new ArrayList<String>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final CookieManager manager = new CookieManager();
        CookieHandler.setDefault( manager  );
        requestQueue = Volley.newRequestQueue(this);

        ///////////////////////////////////GET - SZUKAJ////////////////////////////////////////////////
        JsonArrayRequest req2 = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                             for(int i = 0; i < response.length(); i++) {
                                JSONObject jresponse = response.getJSONObject(i);
                                String id = jresponse.getString("materialId");
                                 String liczba2 = jresponse.getString("amount");

                                 ///////ODBIERANIE NAZW MATERIALOW ///////////////
                                 JSONObject material = jresponse.getJSONObject("material");
                                 String material2 = material.getString("name");

                                 //////ODBIERANIE CENY/////////////////////////////////
                                 String koszt2 = material.getString("basePrice");
                                 Log.d("id: ", id);

                                 nazwa_materialu.add(material2.toString());
                                 liczba.add(liczba2.toString());
                                 koszt.add(koszt2.toString());

                                // System.out.println(koszt.get(i)+ "rozmiar: "+nazwa_materialu.size());
                            }
                        }catch (JSONException e) {
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
        setListAdapter(new MagazynAdapter(this, nazwa_materialu, liczba, koszt));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nazwa_materialu.clear();
        liczba.clear();
        koszt.clear();
    }

    private void odp(JsonArrayRequest postRequest)
    {
        Volley.newRequestQueue(this).add(postRequest);
    }
}