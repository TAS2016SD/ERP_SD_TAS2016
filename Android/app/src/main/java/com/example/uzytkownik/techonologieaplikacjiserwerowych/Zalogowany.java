package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.CookieManager;
import java.util.HashMap;
/**
 * Created by uzytkownik on 23.11.2016.
 */

public class Zalogowany extends Activity {
    String stringData = "";
    public static String Name = "name1";
    String url = "http://tas2016.azurewebsites.net/mobile/LogOff";
    String url2 = "http://tas2016.azurewebsites.net/Client";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zalogowany);

        Intent intent = getIntent();


        //WYPISANIE IMIENIA NA PRZYWITANIE
        String name = intent.getStringExtra(Login.NAME);
        TextView header = (TextView) findViewById(R.id.witaj_textView);
        header.setText("Zalogowany: " + name);

        Name = name;

        // PRZYCISK KOMPLETUJ ZAMOWIENIE
        Button kompletuj_zamowienie = (Button) findViewById(R.id.kompletuj_button);
        kompletuj_zamowienie.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Zalogowany.this, Kompletuj_zamowienie.class);
                startActivity(intent);
            }
        });


        // PRZYCISK STAN MAGAZYNU
        Button stan_magazynu = (Button) findViewById(R.id.stan_button);
        stan_magazynu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Zalogowany.this, Stan_magazynu.class);
                startActivity(intent);
            }
        });


        //PRZYCISK WYLOGOWANIA
        Button logOut = (Button) findViewById(R.id.wyloguj_button);

        logOut.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                final HashMap<String, String> params = new HashMap<String, String>();

                params.put("jh", "");

                JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(params),
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                //Log.v("Response:%n %s", response.toString());
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // VolleyLog.e("Error: ", error.getMessage());
                        NetworkResponse errorRes;
                        errorRes = error.networkResponse;
                        String stringData = "";
                        if (errorRes != null && errorRes.data != null) {
                            try {
                                stringData = new String(errorRes.data, "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                        else{
                            showDialog();
                        }
                        Log.e("Error", stringData);
                    }
                });
                odp(req);
            }
        });
    }


    /////////////OKIENKO DIALOG - POTWIERDZENIE WYLOGOWANIA/////////////
    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(R.string.wylogowanie_info)
                .setTitle(R.string.wylogowanie_title);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Zalogowany.this, Login.class);
                startActivity(intent);
                intent.putExtra(Login.LOGOUT, true);
                showSuccessToast();
            }
        });

        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Zalogowany.this, Zalogowany.class);
                startActivity(intent);
                intent.putExtra(Login.LOGOUT, false);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    //////////////////////////////////////////////////////////


    /////////////////////////TOAST  "WYLOGOWANO"/////////////////////////////
    private void showSuccessToast() {
        Toast.makeText(this, R.string.toast_wylogowano, Toast.LENGTH_SHORT).show();
    }
    //////////////////////////////////////////////////////////


    private void odp(JsonObjectRequest postRequest)
    {
        Volley.newRequestQueue(this).add(postRequest);
    }
}
