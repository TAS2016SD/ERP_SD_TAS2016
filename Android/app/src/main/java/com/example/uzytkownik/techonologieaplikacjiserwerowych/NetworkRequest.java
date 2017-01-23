package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by uzytkownik on 17.01.2017.
 */

public class NetworkRequest {

    private final String url;
    private final HttpMethod method;
    private final String login;
    private final String password;
    private final Context context = null;

    public NetworkRequest(String url, HttpMethod method, String login, String password) {
        this.url = url;
        this.method = method;
        this.login = login;
        this.password = password;
    }

    /////////////TWORZENIE POLACZENIA///////////////////////////////////////////////////////
    public String execute() throws IOException {
        InputStream is = null;

        try {
            URL url = new URL(this.url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod(method.getMethod());
            conn.setDoInput(true);

            /*if (body != null) {
                conn.getOutputStream().write(body.getBytes());
            }
*/
            conn.connect();
            //is = conn.getInputStream();

            return readStream(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////




    /////////////////////////////INPUT STREAM//////////////////////////////////////////////////
    public String readStream(InputStream stream) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(stream));
        StringBuilder total = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            total.append(line);
        }
        return total.toString();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////

    ////////SPRAWDZENIE DOSTEPNOSCI POLACZENIA///////////////////////
    public boolean isOnline() {
        ConnectivityManager connMgr = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}
