package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.app.Activity;
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

/**
 * Created by uzytkownik on 04.01.2017.
 */

public class Kompletuj_zamowienie extends Activity{

    String stringData = "";
    String url2 = "http://tas2016.azurewebsites.net/Client";
    NetworkResponse errorRes;
    RequestQueue requestQueue;
    String url3 = "http://demo5481117.mockable.io/recipes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.kompletuj_zamowienie);
        CookieHandler cookie = CookieHandler.getDefault();
        CookieManager.setDefault(CookieHandler.getDefault());
        requestQueue = Volley.newRequestQueue(this);

        Intent intent = getIntent();

        TextView header = (TextView) findViewById(R.id.imie);
        header.setText("Zalogowany: " + Zalogowany.Name);
        final TextView get = (TextView) findViewById(R.id.get);

        // PRZYCISK WROC W KOMPLETUJ ZAMOWIENIE
        Button wroc1 = (Button) findViewById(R.id.wroc_button);
        wroc1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Kompletuj_zamowienie.this, Zalogowany.class);
                //startActivity(intent);
                //finish();
                /////////////GET////////////////////////////////////////////////////////////////
                JsonArrayRequest req2 = new JsonArrayRequest(Request.Method.GET, url2,
                        new Response.Listener<JSONArray>() {

                            @Override
                            public void onResponse(JSONArray response) {
                                try {
                                    for(int i = 0; i < response.length(); i++) {

                                        JSONObject jresponse = response.getJSONObject(i);
                                        String nickname = jresponse.getString("id");
                                        Log.d("nickname", nickname);
                                        get.setText(nickname);
                                    }
                                }catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // VolleyLog.e("Error: ", error.getMessage());
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
        });
    }

    private void odp(JsonArrayRequest postRequest)
    {
        Volley.newRequestQueue(this).add(postRequest);
    }

}
