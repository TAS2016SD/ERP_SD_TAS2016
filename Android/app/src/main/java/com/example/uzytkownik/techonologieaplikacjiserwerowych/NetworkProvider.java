package com.example.uzytkownik.techonologieaplikacjiserwerowych;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by uzytkownik on 11.01.2017.
 */

public class NetworkProvider {

   private static final String RECIPES_URL = "http://tas2016.azurewebsites.net/mobile/client";

    private final Context context;

    private final List<String> users = new ArrayList<>();

    private String name;

    private String login = "mateusz.dajerling@gmail.com";
    private String password = "###########";

   // public interface OnLoginDownloadedListener {
    //    void onLoginDownloaded();
    //}

    public NetworkProvider(Context context) {
        this.context = context;
    }



   /* public void getUsers(OnLoginDownloadedListener listener) throws IOException, JSONException{
        if(isOnline())
        {
            String s = downloadUsers();
            JSONObject usersObject = new JSONObject(s);
            JSONArray usersArray = usersObject.getJSONArray("");

            for (int i = 0; i < usersArray.length(); ++i) {
                JSONObject recipeObject = usersArray.getJSONObject(i);

                name = recipeObject.getString("name");
                recipeObject.getString("adress");

                users.add(name);
            }

            listener.onLoginDownloaded();
        } else {
            Toast.makeText(context, context.getString(R.string.brak), Toast.LENGTH_LONG).show();
        }
    }

    public List<String> getAllUsers() { return users; }

    private String downloadUsers() throws IOException {
        return new NetworkRequest(RECIPES_URL, HttpMethod.POST, login, password).execute();
    }
*/

    ////////SPRAWDZENIE DOSTEPNOSCI POLACZENIA///////////////////////
    public boolean isOnline() {
        ConnectivityManager connMgr = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    //////////////////////////////////////////////////////////////////
}
