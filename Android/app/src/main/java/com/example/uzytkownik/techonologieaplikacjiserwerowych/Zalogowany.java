package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by uzytkownik on 23.11.2016.
 */

public class Zalogowany extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zalogowany);

        Intent intent = getIntent();

        String name = intent.getStringExtra(Login.NAME);

        TextView header = (TextView) findViewById(R.id.witaj_textView);
        header.setText(name);

        Button logIn = (Button) findViewById(R.id.wyloguj_button);
        logIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Zalogowany.this, Login.class);
                intent.putExtra(Login.LOGOUT, true);
                startActivity(intent);

               /* Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.menu, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
                spinner.setAdapter(adapter);
//                finish();*/
            }
        });
    }
}
