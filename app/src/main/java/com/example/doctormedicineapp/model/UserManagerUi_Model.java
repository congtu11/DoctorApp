package com.example.doctormedicineapp.model;

public class UserManagerUi_Model {
    private int icon;
    private String title;
    private int id_event;

    public UserManagerUi_Model(int icon,String title,int id_event) {
        super();
        this.icon=icon;
        this.title=title;
        this.id_event=id_event;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }
}
