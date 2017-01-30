package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;

public class Login extends Activity{

    public static final String NAME = "name";
    public static final String LOGOUT = "logout";
    public static final int LOG = 1;
    private static String TAG = "tag";
    String url3 = "http://demo5481117.mockable.io/recipes";
    String url = "http://tas2016.azurewebsites.net/mobile/Login";
    String url2 = "http://tas2016.azurewebsites.net/Client";
    private CookieStore mStore;

    private Context mContext;
    NetworkResponse errorRes;
    String stringData = "";
    RequestQueue requestQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final CookieManager manager = new CookieManager();
        CookieHandler.setDefault( manager  );

        requestQueue = Volley.newRequestQueue(this);

        final EditText nameET = (EditText) findViewById(R.id.login_editText);
        final EditText passwordET = (EditText) findViewById(R.id.haslo_editText);
        final TextView result = (TextView) findViewById(R.id.result);


        final StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
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
                                Log.v("Response:%n %s", response.toString());
                                Log.v("Cookies: $s $n", manager.getCookieStore().toString());

                                Intent intent = new Intent(Login.this, Zalogowany.class);
                                startActivity(intent);
                            }


                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // VolleyLog.e("Error: ", error.getMessage());
                        errorRes = error.networkResponse;
                        if (errorRes != null && errorRes.data != null) {
                            try {
                                stringData = new String(errorRes.data, "UTF-8");
                                showErrorToast();
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        } else {


                        }
                        Log.e("Error", stringData);

                    }
                });
                odp(req);


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


    ///COOKIE/////////////////////////////////////////////////////////
    private static String sessionCookie = "s=12342342352354234";

   /* public static void get(String url) {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        if(sessionCookie != null){
            Log.d(TAG, "Setting Cookie: "+sessionCookie);
            request.setHeader("Cookie", sessionCookie);
        } else {
            Log.i(TAG, "Null session request get()");
        }
        HttpResponse response = null;
        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Header[] headers = response.getAllHeaders();
        for (int i=0; i < headers.length; i++) {
            Header h = headers[i];
            Log.i(TAG, "Header names: "+h.getName());
            Log.i(TAG, "Header Value: "+h.getValue());
        }
    }*/

    /////////////////////////////////////////////////////////////////
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
