package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.util.HashMap;
public class Logowanie extends Activity{

    public static final String NAME = "name";
    public static final String LOGOUT = "logout";

    String url = "http://tas2016.azurewebsites.net/mobile/Login";

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


        ///////////////////////////////PRZYCISK LOGOWANIA////////////////////////////////////////////
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

                                Intent intent = new Intent(Logowanie.this, Zalogowany.class);
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

}
