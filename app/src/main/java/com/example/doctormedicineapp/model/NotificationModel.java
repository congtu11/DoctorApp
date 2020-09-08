package com.example.doctormedicineapp.model;

public class NotificationModel {
    private int id;
    private int id_ticket;
    private int id_videocall;
    private String notification_1;
    private String notification_2;
    private int check_code;
    private int checkvideocode;
    private String icon_image;
    private String  created_at;
    private String update_at;
    private int id_uer;
    public  NotificationModel (){

    }

    public NotificationModel(int id, int id_ticket,int id_videocall, String notification_1,String notification_2, int check_code,int checkvideocode,int id_uer, String icon_image, String created_at, String update_at) {
        super();
        this.id=id;
        this.id_ticket=id_ticket;
        this.id_videocall=id_videocall;
        this.notification_1=notification_1;
        this.notification_2=notification_2;
        this.check_code=check_code;
        this.icon_image=icon_image;
        this.created_at=created_at;
        this.update_at=update_at;
        this.id_uer=id_uer;
        this.checkvideocode=checkvideocode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public String getNotification_1() {
        return notification_1;
    }

    public void setNotification_1(String notification_1) {
        this.notification_1 = notification_1;
    }

    public String getNotification_2() {
        return notification_2;
    }

    public void setNotification_2(String notification_2) {
        this.notification_2 = notification_2;
    }

    public int getCheck_code() {
        return check_code;
    }

    public void setCheck_code(int check_code) {
        this.check_code = check_code;
    }

    public String getIcon_image() {
        return icon_image;
    }

    public void setIcon_image(String icon_image) {
        this.icon_image = icon_image;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public int getId_uer() {
        return id_uer;
    }

    public void setId_uer(int id_uer) {
        this.id_uer = id_uer;
    }

    public int getId_videocall() {
        return id_videocall;
    }

    public void setId_videocall(int id_videocall) {
        this.id_videocall = id_videocall;
    }

    public int getCheckvideocode() {
        return checkvideocode;
    }

    public void setCheckvideocode(int checkvideocode) {
        this.checkvideocode = checkvideocode;
    }
}
