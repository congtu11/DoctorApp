package com.example.doctormedicineapp.model;

public class MedicineModel {
    private int id,amount,price,id_category;
    private  String name_medicine,quickreview,avatar,name_category ;
    public  MedicineModel() {

    }

    public MedicineModel(int id,String name_medicine, int id_category, int amount, int price,String qickreview, String avatar,String name_category ) {
        this.id=id;
        this.name_medicine=name_medicine;
        this.id_category=id_category;
        this.amount=amount;
        this.price=price;
        this.quickreview=qickreview;
        this.avatar=avatar;
        this.name_category=name_category;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName_medicine() {
        return name_medicine;
    }

    public void setName_medicine(String name_medicine) {
        this.name_medicine = name_medicine;
    }

    public String getQickreview() {
        return quickreview;
    }

    public void setQickreview(String qickreview) {
        this.quickreview = qickreview;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }
}
