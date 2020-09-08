package com.example.doctormedicineapp.model;

public class UserModel {
    private int id;
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private String address;
    public UserModel(int id,String email, String name , String password, String phone_number, String address) {
        super();
        this.id=id;
        this.email=email;
        this.name=name;
        this.password=password;
        this.phone_number=phone_number;
        this.address=address;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
