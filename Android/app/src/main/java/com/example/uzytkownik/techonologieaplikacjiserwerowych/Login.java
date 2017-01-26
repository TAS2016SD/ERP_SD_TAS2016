package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class Login extends Activity{

    public static final String NAME = "name";
    public static final String LOGOUT = "logout";
    public static final int LOG = 1;
    String url = "http://tas2016.azurewebsites.net/mobile/Login";
    NetworkResponse errorRes;
    String stringData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText nameET = (EditText) findViewById(R.id.login_editText);
        final EditText passwordET = (EditText) findViewById(R.id.haslo_editText);
        final TextView result = (TextView) findViewById(R.id.result);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        //PRZYCISK LOGOWANIA//////
        final Button logIn = (Button) findViewById(R.id.zaloguj_button);
        logIn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                final HashMap<String, String> params = new HashMap<String, String>();

                params.put("Email", nameET.getText().toString());
                params.put("Password", passwordET.getText().toString());

                JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(params),
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                //Log.v("Response:%n %s", response.toString());
                                //System.out.println("HEJ");
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // VolleyLog.e("Error: ", error.getMessage());
                        errorRes = error.networkResponse;
                        if (errorRes != null && errorRes.data != null) {
                            try {
                                stringData = new String(errorRes.data, "UTF-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                        else{
                            Intent intent = new Intent(Login.this, Stan_magazynu.class);
                            startActivity(intent);
                        }
                        Log.e("Error", stringData);
                    }
                });
                odp(req);



               /* StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Result handling
                                System.out.println(response.substring(0,100));
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("Something went wrong!");
                        error.printStackTrace();
                    }
                });
                odp2(stringRequest);*/


               /* JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        result.setText("Response: " + response.toString());
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
                odp(jsObjRequest);*/
            }
        });


    }



    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        boolean logout = intent.getBooleanExtra(LOGOUT, false);

        TextView header = (TextView) findViewById(R.id.wyl_info);

        if (logout) {
            header.setVisibility(View.VISIBLE);
        } else {
            header.setVisibility(View.INVISIBLE);
        }
    }



   private void showSuccessToast() {
        Toast.makeText(this, R.string.toast_zalogowano, Toast.LENGTH_SHORT).show();
    }

    private void showSuccessNetworkToast() {
        Toast.makeText(this, R.string.polaczono, Toast.LENGTH_SHORT).show();
    }

    private void showErrorToast() {
        Toast.makeText(this, R.string.brak, Toast.LENGTH_SHORT).show();
}
    private void odp(JsonObjectRequest postRequest)
    {
        Volley.newRequestQueue(this).add(postRequest);
    }

    private void odp2(StringRequest postRequest)
    {
        Volley.newRequestQueue(this).add(postRequest);
    }
}
