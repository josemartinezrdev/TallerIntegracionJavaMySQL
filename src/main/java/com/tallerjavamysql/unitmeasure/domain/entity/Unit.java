package com.tallerjavamysql.unitmeasure.domain.entity;

public class Unit {
    private int idum;
    private String nameum;

    public Unit() {
    }

    public Unit(int idum, String nameum) {
        this.idum = idum;
        this.nameum = nameum;
    }

    public int getIdum() {
        return this.idum;
    }

    public void setIdum(int idum) {
        this.idum = idum;
    }

    public String getNameum() {
        return this.nameum;
    }

    public void setNameum(String nameum) {
        this.nameum = nameum;
    }
}
