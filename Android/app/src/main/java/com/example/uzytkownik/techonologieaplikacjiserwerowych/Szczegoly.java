package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.HashMap;

/**
 * Created by domir on 2/2/2017.
 */

public class Szczegoly extends Activity {


    NetworkResponse errorRes;
    String stringData = "";
    RequestQueue requestQueue;
    String url = "http://tas2016.azurewebsites.net/mobile/order";

    public static final String ID = "id";
    String id = null;
    String cena = null, client_name = null, client_adress = null, client_phone = null, client_nip = null, name_seller = null;
    String seller_adress = null, seller_nip = null, payer_name = null, payer_adress = null, payer_phone = null, payer_nip = null, status = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.szczegoly_zamowienia);

        final CookieManager manager = new CookieManager();
        CookieHandler.setDefault(manager);

        requestQueue = Volley.newRequestQueue(this);
        ///////////////////////////////////GET - SZUKAJ////////////////////////////////////////////////
        JsonArrayRequest req2 = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Intent intent = getIntent();
                        int stringExtra = intent.getIntExtra(ID,0);

                        try {
                            JSONObject jresponse = response.getJSONObject(stringExtra);
                            id = jresponse.getString("id");
                            cena = jresponse.getString("orderPrice");
                            status = jresponse.getString("status");

                            JSONObject client = jresponse.getJSONObject("client");
                            client_name = client.getString("name");     //dane klienta
                            client_adress = client.getString("adress");
                            client_phone = client.getString("phoneNumber");
                            client_nip = client.getString("nip");

                            JSONObject seller = jresponse.getJSONObject("seller");
                            name_seller = seller.getString("name");
                            seller_adress = seller.getString("adress");
                            seller_nip = seller.getString("nip");

                            JSONObject payer = jresponse.getJSONObject("payer");
                            payer_name = payer.getString("name");     //dane klienta
                            payer_adress = payer.getString("adress");
                            payer_phone = payer.getString("phoneNumber");
                            payer_nip = payer.getString("nip");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        TextView id_zamowienie = (TextView) findViewById(R.id.id);
                        TextView client_name2 = (TextView) findViewById(R.id.client_name2);
                        TextView client_adress2 = (TextView) findViewById(R.id.client_adress2);
                        TextView client_phone2 = (TextView) findViewById(R.id.phone_number2);
                        TextView client_nip2 = (TextView) findViewById(R.id.client_nip2);

                        TextView seller_name2 = (TextView) findViewById(R.id.seller_name2);
                        TextView seller_adress2 = (TextView) findViewById(R.id.seller_adress2);
                        TextView seller_nip2 = (TextView) findViewById(R.id.seller_nip2);

                        TextView payer_name2 = (TextView) findViewById(R.id.payer_name2);
                        TextView payer_adress2 = (TextView) findViewById(R.id.payer_adress2);
                        TextView payer_phone2 = (TextView) findViewById(R.id.payer_phone2);
                        TextView payer_nip2 = (TextView) findViewById(R.id.payer_nip2);

                        TextView cena2 = (TextView) findViewById(R.id.cena2);

                        id_zamowienie.setText("Id zamówienia: "+id);
                            client_name2.setText(client_name);
                            client_adress2.setText(client_adress);
                            client_phone2.setText(client_phone);
                            client_nip2.setText(client_nip);

                            seller_name2.setText(name_seller);
                            seller_adress2.setText(seller_adress);
                            seller_nip2.setText(seller_nip);

                            payer_name2.setText(payer_name);
                            payer_adress2.setText(payer_adress);
                            payer_phone2.setText(payer_phone);
                            payer_nip2.setText(payer_nip);

                            cena2.setText(cena);


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
                showDialog();

            }
        });
    }

    private void showSuccessToast() {
        Toast.makeText(this, R.string.kompletowanie, Toast.LENGTH_SHORT).show();
    }


    private void odp(JsonArrayRequest postRequest)
    {
        Volley.newRequestQueue(this).add(postRequest);
    }

    /////////////OKIENKO DIALOG - POTWIERDZENIE ZAMOWIENIA/////////////
    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(R.string.potwierdzenie_wyslania)
                .setTitle(R.string.potwierdzenie_title);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                final HashMap<String, String> params = new HashMap<String, String>();
                final CookieManager manager = new CookieManager();
                CookieHandler.setDefault(manager);

                params.put("status", "S");

                String url2 = "http://tas2016.azurewebsites.net/order/"+id;

                JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, url2, new JSONObject(params),
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                Log.v("Response:%n %s", response.toString());
                                Log.v("Cookies: $s $n", manager.getCookieStore().toString());
                                System.out.println(response);
                                Intent intent = new Intent(Szczegoly.this, Zalogowany.class);
                                startActivity(intent);
                                showSuccessToast();
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        errorRes = error.networkResponse;
                        if (errorRes != null && errorRes.data != null) {
                            try {
                                stringData = new String(errorRes.data, "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                        Log.e("Error", stringData);
                    }
                });
                odp2(req);
            }
        });

        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Szczegoly.this, Szczegoly.class);
                startActivity(intent);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void odp2(JsonObjectRequest postRequest)
    {
        Volley.newRequestQueue(this).add(postRequest);
    }
}
