package com.example.doctormedicineapp.model;

public class TicketModel {
    private int id;
    private int id_doctor;
    private String fullname;
    private int age;
    private String sex;
    private int phone;
    private String date;
    private String time;
    private int id_user;
    private String created_at;
    private String updated_at;
    public TicketModel(int id, int id_doctor, String fullname, int age, String sex, int phone, String date, String time, int id_user, String created_at, String updated_at)
    {
        this.id=id;
        this.id_doctor= id_doctor;
        this.fullname=fullname;
        this.age=age;
        this.sex=sex;
        this.phone=phone;
        this.date=date;
        this.time=time;
        this.id_user=id_user;
        this.created_at=created_at;
        this.updated_at=updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
