package com.example.doctormedicineapp.Login;

import android.content.SharedPreferences;

import com.example.doctormedicineapp.entities.AccessToken;



public class TokenManager {

    public SharedPreferences prefss;
    public SharedPreferences.Editor editors;

    public static TokenManager INSTANCE = null;

   public TokenManager(SharedPreferences prefs) {
        this.prefss = prefs;
        this.editors = prefs.edit();
    }

    public static synchronized TokenManager getInstance(SharedPreferences prefs) {
        if (INSTANCE == null) {
            INSTANCE = new TokenManager(prefs);
        }
        return INSTANCE;
    }

    public void saveToken(AccessToken token) {
        editors.putString("ACCESS_TOKEN", token.getAccessToken()).commit();
        editors.putString("REFRESH_TOKEN", token.getRefreshToken()).commit();
    }

    public void deleteToken() {
        editors.remove("ACCESS_TOKEN").commit();
        editors.remove("REFRESH_TOKEN").commit();
    }

    public AccessToken getToken() {
        AccessToken token = new AccessToken();
        token.setAccessToken(prefss.getString("ACCESS_TOKEN", null));
        token.setRefreshToken(prefss.getString("REFRESH_TOKEN", null));
        return token;
    }
}
