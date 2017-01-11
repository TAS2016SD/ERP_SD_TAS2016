package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by uzytkownik on 04.01.2017.
 */

public class Kompletuj_zamowienie extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.kompletuj_zamowienie);

        Intent intent = getIntent();

        TextView header = (TextView) findViewById(R.id.imie);
        header.setText("Zalogowany: " + Zalogowany.Name);

        // PRZYCISK WROC W KOMPLETUJ ZAMOWIENIE
        Button wroc1 = (Button) findViewById(R.id.wroc_kompletuj_button);
        wroc1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kompletuj_zamowienie.this, Zalogowany.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
