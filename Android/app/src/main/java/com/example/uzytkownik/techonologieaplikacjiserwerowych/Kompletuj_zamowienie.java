package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
 * Created by uzytkownik on 04.01.2017.
 */

public class Kompletuj_zamowienie  extends Activity {

    String url = "http://tas2016.azurewebsites.net/mobile/order";
    RequestQueue requestQueue;
    NetworkResponse errorRes;
    String stringData = "";
    public static final String ID = "id";

    static final List<String> nazwa_clienta = new ArrayList<String>();
    static final List<String> id_zamowienia = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kompletuj);
        final ListView listView = (ListView) findViewById(R.id.lista_kompletuj);
        ArrayAdapter adapter;

        final CookieManager manager = new CookieManager();
        CookieHandler.setDefault( manager  );
        requestQueue = Volley.newRequestQueue(this);

        ///////////////////////////////////GET - SZUKAJ////////////////////////////////////////////////
        JsonArrayRequest req2 = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jresponse = response.getJSONObject(i);
                                JSONObject client = jresponse.optJSONObject("client");
                                String name = client.getString("name");
                                String id = client.getString("id");
                                nazwa_clienta.add(name);
                                id_zamowienia.add(id);
                            }
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
        adapter = new ArrayAdapter<String>(this, R.layout.wiersz, R.id.id_zamowienia, id_zamowienia);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Kompletuj_zamowienie.this, Szczegoly.class);
                //String value = listView.getItemAtPosition(position).toString();

                int liczba = position;
                intent.putExtra(ID,position);
                startActivity(intent);
            }
        });

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nazwa_clienta.clear();
        id_zamowienia.clear();

    }

    private void odp(JsonArrayRequest postRequest)
    {
        Volley.newRequestQueue(this).add(postRequest);
    }
}
