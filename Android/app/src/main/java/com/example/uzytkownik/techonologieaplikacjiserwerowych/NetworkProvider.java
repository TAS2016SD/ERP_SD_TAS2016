package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by uzytkownik on 11.01.2017.
 */

public class NetworkProvider {

    private final Context context;

    public NetworkProvider(Context context) {
        this.context = context;
    }

    public boolean isOnline() {
        ConnectivityManager connMgr = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}
