package com.tallerjavamysql.actprinciple.domain.entity;

public class ActPrinciple {
    private int idap;
    private String nameap;

    public ActPrinciple() {
    }

    public ActPrinciple(int idap, String nameap) {
        this.idap = idap;
        this.nameap = nameap;
    }

    public int getIdap() {
        return this.idap;
    }

    public void setIdap(int idap) {
        this.idap = idap;
    }

    public String getNameap() {
        return this.nameap;
    }

    public void setNameap(String nameap) {
        this.nameap = nameap;
    }

}