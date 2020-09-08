package com.example.doctormedicineapp.entities;

import com.squareup.moshi.Json;

public class IDUser {
    @Json(name = "id")
    int ID_USER;

    public int getID_USER() {
        return ID_USER;
    }

    public void setID_USER(int ID_USER) {
        this.ID_USER = ID_USER;
    }
}
