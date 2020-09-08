package com.example.doctormedicineapp.model;

public class BookCallModel {
    private int id;
    private int id_user;
    private int id_doctor;
    private String date;
    private String time;
    private String codecall;
    private String updated_at;
    private String created_at;
     public BookCallModel(int id, int id_user, int id_doctor, String date, String time,String codecall, String updated_at, String created_at) {
         this.id=id;
         this.id_user=id_user;
         this.id_doctor=id_doctor;
         this.date=date;
         this.time=time;
         this.codecall=codecall;
         this.updated_at=updated_at;
         this.created_at=created_at;
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCodecall() {
        return codecall;
    }

    public void setCodecall(String codecall) {
        this.codecall = codecall;
    }
}
