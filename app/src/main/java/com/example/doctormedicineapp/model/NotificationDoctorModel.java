package com.example.doctormedicineapp.model;

public class NotificationDoctorModel {
     private int id;
     private String content;
     private int id_ticket;
     private int id_videocall;
     private int id_notification;
     private int checkcode;
     private String created_at;
     private String updated_at;
     public NotificationDoctorModel(){}
     public NotificationDoctorModel(int id,String content,int id_ticket,int id_videocall,int id_notification,int checkcode,String updated_at,String created_at) {
         super();
         this.id=id;
         this.content=content;
         this.id_ticket=id_ticket;
         this.id_videocall=id_videocall;
         this.id_notification=id_notification;
         this.created_at=created_at;
         this.updated_at=updated_at;
         this.checkcode=checkcode;
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(int checkcode) {
        this.checkcode = checkcode;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public int getId_videocall() {
        return id_videocall;
    }

    public void setId_videocall(int id_videocall) {
        this.id_videocall = id_videocall;
    }

    public int getId_notification() {
        return id_notification;
    }

    public void setId_notification(int id_notification) {
        this.id_notification = id_notification;
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
