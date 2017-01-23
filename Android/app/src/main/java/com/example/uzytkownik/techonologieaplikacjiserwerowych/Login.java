package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.StrictMode;
import android.service.voice.VoiceInteractionSession;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;


public class Login extends Activity{

    public static final String NAME = "name";
    public static final String LOGOUT = "logout";
    public static final int LOG = 1;
    private static final String USERS_URL = "http://tas2016.azurewebsites.net/client";
    private static final String TAG = Login.class.getSimpleName();


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
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                String result = new NetworkRequest(USERS_URL, HttpMethod.POST,
                                String.valueOf(nameET.getText()), String.valueOf(passwordET.getText())).execute();
                                Log.v(TAG, " result " + result);
                                showSuccessNetworkToast();
                            } catch (IOException e) {
                                //TODO handle this exception properly
                                Log.e(TAG, "IOException while sending rating", e);
                                showErrorToast();
                            } finally {
                               // switchRateVa(view, rateVa);
                            }
                        }
                        });


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
}
