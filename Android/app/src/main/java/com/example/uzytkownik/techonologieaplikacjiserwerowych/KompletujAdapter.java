package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by domir on 2/1/2017.
 */

public class KompletujAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final List<String> nazwa_clienta;
    private final List<String> id_zamowienia;


    public KompletujAdapter(Context context, List<String> nazwa_clienta, List<String> id_zamowienia) {
        super(context, R.layout.kompletuj_zamowienie, nazwa_clienta);
        this.context = context;
        this.nazwa_clienta = nazwa_clienta;
        this.id_zamowienia = id_zamowienia;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.kompletuj_zamowienie, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.nazwa_clienta);
        TextView textView2 = (TextView) rowView.findViewById(R.id.id_zamowienia);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.zdjZamowienie);
        textView.setText("Klient: "+ nazwa_clienta.get(position));
        textView2.setText("Id zamówienia: " + id_zamowienia.get(position));
        imageView.setImageResource(R.drawable.zakupy);

        return rowView;
    }
}
