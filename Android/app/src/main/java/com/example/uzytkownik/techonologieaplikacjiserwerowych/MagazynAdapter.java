package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by domir on 2/1/2017.
 */

public class MagazynAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final List<String> nazwa_materialu;
    private final List<String> liczba;
    private final List<String> koszta;

    public MagazynAdapter(Context context, List<String> nazwa_materialu, List<String> liczba, List<String> koszta) {
        super(context, R.layout.stan_magazynu, nazwa_materialu);
        this.context = context;
        this.nazwa_materialu = nazwa_materialu;
        this.liczba = liczba;
        this.koszta = koszta;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.stan_magazynu, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.material_nazwa);
        TextView textView2 = (TextView) rowView.findViewById(R.id.material_liczba);
        TextView textView3 = (TextView) rowView.findViewById(R.id.material_cena);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.zdjMagazyn);
        textView.setText("Nazwa produktu: "+nazwa_materialu.get(position));
        textView2.setText("Liczba: " + liczba.get(position));
        textView3.setText("Koszt: " + koszta.get(position));

        // Change icon based on name
        String s = nazwa_materialu.get(position);

        //System.out.println(s);

        if (s.equals("Mleko 3,2%")) {
            imageView.setImageResource(R.drawable.mleko);
        } else {
            imageView.setImageResource(R.drawable.tlo);
        }

        return rowView;
    }

    enum ViewType {
        SZUKAJ, TEXT;
    }


    public int getLayoutId(int position) {
        if (getItemViewType(position) == ViewType.SZUKAJ.ordinal()) {
            return R.layout.wyszukiwanie;
        } else if (getItemViewType(position) == ViewType.TEXT.ordinal()) {
            return R.layout.stan_magazynu;
        } else {
            return R.layout.stan_magazynu;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? ViewType.SZUKAJ.ordinal() : ViewType.TEXT.ordinal();
    }
}