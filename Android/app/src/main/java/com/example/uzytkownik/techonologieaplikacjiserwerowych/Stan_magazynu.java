package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import java.net.CookieHandler;
import java.net.CookieManager;


/**
 * Created by uzytkownik on 04.01.2017.
 */

public class Stan_magazynu extends Activity{

    String url = "http://tas2016.azurewebsites.net/warehousestatus";
    RequestQueue requestQueue;
    NetworkResponse errorRes;
    String stringData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.stan_magazynu);

        final CookieManager manager = new CookieManager();
        CookieHandler.setDefault( manager  );

        requestQueue = Volley.newRequestQueue(this);

        //final TextView sprawdzenie = (TextView) findViewById(R.id.sprawdzenie);

        Intent intent = getIntent();


        // PRZYCISK WROC W STAN MAGAZYNU
        /*Button wroc2 = (Button) findViewById(R.id.wroc_stan_button);
        wroc2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Stan_magazynu.this, Zalogowany.class);
                startActivity(intent);
                finish();
            }
        });

        Button szukaj = (Button) findViewById(R.id.szukaj_button);
        szukaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///////////////////////////////////GET - SZUKAJ////////////////////////////////////////////////
                JsonArrayRequest req2 = new JsonArrayRequest(Request.Method.GET, url,
                        new Response.Listener<JSONArray>() {

                            @Override
                            public void onResponse(JSONArray response) {
                                try {
                                   // for(int i = 0; i < response.length(); i++) {

                                        JSONObject jresponse = response.getJSONObject(0);
                                        String id = jresponse.getString("materialId");
                                        Log.d("id: ", id);
                                        sprawdzenie.setText(id);
                                    //}
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
            }
        });*/
    }


    private void odp(JsonArrayRequest postRequest)
    {
        Volley.newRequestQueue(this).add(postRequest);
    }

}
