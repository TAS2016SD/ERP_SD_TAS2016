package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    public static final String NAME = "name";
    public static final String LOGOUT = "logout";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            final EditText name = (EditText) findViewById(R.id.login_editText);

            Button logIn = (Button) findViewById(R.id.zaloguj_button);
            logIn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Login.this, Zalogowany.class);
                    intent.putExtra(NAME, name.getText().toString());
                    startActivity(intent);
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
}
