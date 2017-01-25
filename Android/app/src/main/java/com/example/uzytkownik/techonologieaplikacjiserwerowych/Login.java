package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;


public class Login extends Activity{

    public static final String NAME = "name";
    public static final String LOGOUT = "logout";
    public static final int LOG = 1;
    private static final String USERS_URL = "http://tas2016.azurewebsites.net/mobile/Login";
    private static final String TAG = Login.class.getSimpleName();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            final EditText nameET = (EditText) findViewById(R.id.login_editText);
            final EditText passwordET = (EditText) findViewById(R.id.haslo_editText);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        //PRZYCISK LOGOWANIA//////
            final Button logIn = (Button) findViewById(R.id.zaloguj_button);
            logIn.setOnClickListener(new View.OnClickListener() {
            

                @Override
                public void onClick(View v) {
                    String url = "http://tas2016.azurewebsites.net/mobile/Login";
                    //Network network;
                    final TextView result = (TextView) findViewById(R.id.result);

                    HashMap<String, String> params = new HashMap<String, String>();
                    params.put("Content-Type", "application/json");

                    JsonObjectRequest req = new JsonObjectRequest(url, new JSONObject(params),
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        VolleyLog.v("Response:%n %s", response.toString(4));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            VolleyLog.e("Error: ", error.getMessage());
                        }
                    });
                       /* final StringRequest postRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {

                                JSONObject jsonResponse = new JSONObject(response).getJSONObject("");
                                String site = jsonResponse.getString("Email");
                                        String network = jsonResponse.getString("Password");
                                System.out.println("Site: " + site + "\nNetwork: " + network);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    error.printStackTrace();
                                   }
                            }
                    ) {
                        protected Map<String,String> getParams() {
                            Map<String, String> params = new HashMap<>();
                            {
                                params.put("Content-Type","application/json");
                                return params;
                            }
                        }
                    };*/
                    context= getApplicationContext();
                    Volley.newRequestQueue(context).add(req);
                    //odp(postRequest);
                    //Volley.newRequestQueue(context).add(postRequest);
                    //Volley.newRequestQueue(this).add(postRequest);


                   /* Intent intent = new Intent(Login.this, Zalogowany.class);
                    intent.putExtra(NAME, nameET.getText().toString());
                    setResult(RESULT_OK);
                    startActivityForResult(intent, LOG);
                    showSuccessToast();
                    finish();*/
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
    private void odp(StringRequest postRequest)
    {
        Volley.newRequestQueue(this).add(postRequest);
    }
}
