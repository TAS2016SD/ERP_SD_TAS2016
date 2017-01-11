package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by uzytkownik on 23.11.2016.
 */

public class Zalogowany extends Activity{

    public static String Name = "name1";
    public static String Name2 = "name2";

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
                //finish();
            }
        });



        //PRZYCISK WYLOGOWANIA
        Button logOut = (Button) findViewById(R.id.wyloguj_button);
        logOut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Zalogowany.this, Login.class);
                intent.putExtra(Login.LOGOUT, true);
                startActivity(intent);
                finish();
            }
        });

    }
}
