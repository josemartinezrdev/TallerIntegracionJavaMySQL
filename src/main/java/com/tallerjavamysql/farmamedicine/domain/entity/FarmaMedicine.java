package com.tallerjavamysql.farmamedicine.domain.entity;

public class FarmaMedicine {
    private int idfarmacy;
    private int idmedicine;
    private float price;

    public FarmaMedicine() {
    }

    public FarmaMedicine(int idfarmacy, int idmedicine, float price) {
        this.idfarmacy = idfarmacy;
        this.idmedicine = idmedicine;
        this.price = price;
    }

    public int getIdfarmacy() {
        return this.idfarmacy;
    }

    public void setIdfarmacy(int idfarmacy) {
        this.idfarmacy = idfarmacy;
    }

    public int getIdmedicine() {
        return this.idmedicine;
    }

    public void setIdmedicine(int idmedicine) {
        this.idmedicine = idmedicine;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
