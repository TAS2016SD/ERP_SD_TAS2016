package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by uzytkownik on 04.01.2017.
 */

public class Stan_magazynu extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.stan_magazynu);

        Intent intent = getIntent();

        TextView header = (TextView) findViewById(R.id.imie_stan);
        header.setText("Zalogowany: " + Zalogowany.Name);

        // PRZYCISK WROC W STAN MAGAZYNU
        Button wroc2 = (Button) findViewById(R.id.wroc_stan_button);
        wroc2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Stan_magazynu.this, Zalogowany.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
