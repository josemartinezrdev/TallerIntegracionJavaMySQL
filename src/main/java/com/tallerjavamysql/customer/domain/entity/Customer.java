package com.tallerjavamysql.customer.domain.entity;

public class Customer {
    private String idcustomer;
    private String namecustomer;
    private String lasnamecustomer;
    private String emailcustomer;
    private String birthdate;
    private float longitud;
    private float latitud;
    private String codecitycustomer;

    public Customer() {
    }

    public Customer(String idcustomer, String namecustomer, String lasnamecustomer, String emailcustomer,
            String birthdate, float longitud, float latitud, String codecitycustomer) {
        this.idcustomer = idcustomer;
        this.namecustomer = namecustomer;
        this.lasnamecustomer = lasnamecustomer;
        this.emailcustomer = emailcustomer;
        this.birthdate = birthdate;
        this.longitud = longitud;
        this.latitud = latitud;
        this.codecitycustomer = codecitycustomer;
    }

    public String getIdcustomer() {
        return this.idcustomer;
    }

    public void setIdcustomer(String idcustomer) {
        this.idcustomer = idcustomer;
    }

    public String getNamecustomer() {
        return this.namecustomer;
    }

    public void setNamecustomer(String namecustomer) {
        this.namecustomer = namecustomer;
    }

    public String getLasnamecustomer() {
        return this.lasnamecustomer;
    }

    public void setLasnamecustomer(String lasnamecustomer) {
        this.lasnamecustomer = lasnamecustomer;
    }

    public String getEmailcustomer() {
        return this.emailcustomer;
    }

    public void setEmailcustomer(String emailcustomer) {
        this.emailcustomer = emailcustomer;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public float getLongitud() {
        return this.longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getLatitud() {
        return this.latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public String getCodecitycustomer() {
        return this.codecitycustomer;
    }

    public void setCodecitycustomer(String codecitycustomer) {
        this.codecitycustomer = codecitycustomer;
    }

}
