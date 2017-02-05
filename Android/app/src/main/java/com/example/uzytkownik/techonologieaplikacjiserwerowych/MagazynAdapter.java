package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
        super(context, R.layout.lista_magazyn, nazwa_materialu);
        this.context = context;
        this.nazwa_materialu = nazwa_materialu;
        this.liczba = liczba;
        this.koszta = koszta;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.wiersz_magazyn, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.material_nazwa);
        TextView textView2 = (TextView) rowView.findViewById(R.id.material_liczba);
        TextView textView3 = (TextView) rowView.findViewById(R.id.material_cena);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.zdjMagazyn);
        textView.setText("Nazwa produktu: "+nazwa_materialu.get(position));
        textView2.setText("Liczba: " + liczba.get(position));
        textView3.setText("Koszt: " + koszta.get(position));

        // Change icon based on name
        String s = nazwa_materialu.get(position);

        if (s.equals("Mleko 3,2%")) {
            imageView.setImageResource(R.drawable.mleko);
        }
        else if(s.equals("orange juice"))
        {
            imageView.setImageResource(R.drawable.sok_pomaranczowy);
        }else if(s.equals("Apple juice"))
        {
            imageView.setImageResource(R.drawable.sok_jablowy);
        }
        else if(s.equals("Grape juice"))
        {
            imageView.setImageResource(R.drawable.sok_winogronowy);
        }
        else if(s.equals("Carrot juice"))
        {
            imageView.setImageResource(R.drawable.sok_marchwiowy);
        }
        else if(s.equals("Strawberry juice"))
        {
            imageView.setImageResource(R.drawable.sok_truskawkowy);
        }
        else if(s.equals("Mango juice"))
        {
            imageView.setImageResource(R.drawable.mango_juice);
        }
        else if(s.equals("Orange juice"))
        {
            imageView.setImageResource(R.drawable.sok_pomaranczowy);
        }
        else if(s.equals("Cherry juice"))
        {
            imageView.setImageResource(R.drawable.sok_wisniowy);
        }
        else if(s.equals("Pineapple juice"))
        {
           imageView.setImageResource(R.drawable.sok_ananasowy);
        }
        else if(s.equals("Banana juice"))
        {
            imageView.setImageResource(R.drawable.sok_bananowy);
        }
        else if(s.equals("Raspberry juice"))
        {
            imageView.setImageResource(R.drawable.sok_malinowy);
        }
        else if(s.equals("Peach juice"))
        {
           imageView.setImageResource(R.drawable.sok_brzoskwiniowy);
        }
        else if(s.equals("Pineapple"))
        {
            imageView.setImageResource(R.drawable.ananas);
        }
        /*else if(s.equals("Apple"))
        {
            imageView.setImageResource(R.drawable.jablko);
        }
        else if(s.equals("Carrot"))
        {
            imageView.setImageResource(R.drawable.marchew);
        }
        else if(s.equals("Raspberry"))
        {*/
            /*try {
                obrazek = drawableFromUrl("https://valenzanowine.com/wp-content/uploads/2016/03/redraspberries.png");
                imageView.setImageDrawable(obrazek);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            //imageView.setImageResource(R.drawable.malina);
       /* }
        else if(s.equals("Peach"))
        {
            imageView.setImageResource(R.drawable.brzoskwinia);
        }
        else if(s.equals("Orange"))
        {
            imageView.setImageResource(R.drawable.pomaranczki);
        }
        else if(s.equals("Cherry"))
        {
            imageView.setImageResource(R.drawable.wisnie);
        }*/
        else {
            imageView.setImageResource(R.drawable.owoce);
        }

        return rowView;
    }

    enum ViewType {
        SZUKAJ, TEXT;
    }


    @Override
    public int getItemViewType(int position) {
        return position == 0 ? ViewType.SZUKAJ.ordinal() : ViewType.TEXT.ordinal();
    }


    public static Drawable drawableFromUrl(String url) throws IOException {
        Bitmap x;

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.connect();
        InputStream input = connection.getInputStream();

        x = BitmapFactory.decodeStream(input);
        return new BitmapDrawable(x);
    }
}