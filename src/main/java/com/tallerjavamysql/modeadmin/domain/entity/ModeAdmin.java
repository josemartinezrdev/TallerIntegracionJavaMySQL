package com.tallerjavamysql.modeadmin.domain.entity;

public class ModeAdmin {
    private int id;
    private String descriptionmode;

    public ModeAdmin() {
    }

    public ModeAdmin(int id, String descriptionmode) {
        this.id = id;
        this.descriptionmode = descriptionmode;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptionmode() {
        return this.descriptionmode;
    }

    public void setDescriptionmode(String descriptionmode) {
        this.descriptionmode = descriptionmode;
    }

}
