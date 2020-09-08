package com.example.doctormedicineapp.Login;

import android.content.SharedPreferences;

import com.example.doctormedicineapp.entities.IDUser;

public class IDUerManager {
    private SharedPreferences prefdoc;
    private SharedPreferences.Editor doceditor;

    private static IDUerManager INSTANCE = null;

    private IDUerManager(SharedPreferences prefs) {
        this.prefdoc = prefs;
        this.doceditor = prefs.edit();
    }

    public static synchronized IDUerManager getInstance(SharedPreferences prefs) {
        if (INSTANCE == null) {
            INSTANCE = new IDUerManager(prefs);
        }
        return INSTANCE;
    }

    public void saveID(IDUser idUser) {
        doceditor.putInt("ID_USER", idUser.getID_USER()).commit();

    }

    public void deleteID() {
        doceditor.remove("ID_USER").commit();

    }

    public IDUser getID() {
        IDUser idUser = new IDUser();
        idUser.setID_USER(prefdoc.getInt("ID_USER",0));
        return idUser;
    }
}
