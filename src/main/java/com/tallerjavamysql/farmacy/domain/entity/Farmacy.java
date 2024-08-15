package com.tallerjavamysql.farmacy.domain.entity;

public class Farmacy {

    private int idfarmacy;
    private String namefarmacy;
    private String addresfarmacy;
    private float longitud;
    private float latitud;
    private String logofarmacy;
    private String codecityfarmacy;

    public Farmacy() {
    }

    public Farmacy(int idfarmacy, String namefarmacy, String addresfarmacy, float longitud, float latitud,
            String logofarmacy, String codecityfarmacy) {
        this.idfarmacy = idfarmacy;
        this.namefarmacy = namefarmacy;
        this.addresfarmacy = addresfarmacy;
        this.longitud = longitud;
        this.latitud = latitud;
        this.logofarmacy = logofarmacy;
        this.codecityfarmacy = codecityfarmacy;
    }

    public int getIdfarmacy() {
        return this.idfarmacy;
    }

    public void setIdfarmacy(int idfarmacy) {
        this.idfarmacy = idfarmacy;
    }

    public String getNamefarmacy() {
        return this.namefarmacy;
    }

    public void setNamefarmacy(String namefarmacy) {
        this.namefarmacy = namefarmacy;
    }

    public String getAddresfarmacy() {
        return this.addresfarmacy;
    }

    public void setAddresfarmacy(String addresfarmacy) {
        this.addresfarmacy = addresfarmacy;
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

    public String getLogofarmacy() {
        return this.logofarmacy;
    }

    public void setLogofarmacy(String logofarmacy) {
        this.logofarmacy = logofarmacy;
    }

    public String getCodecityfarmacy() {
        return this.codecityfarmacy;
    }

    public void setCodecityfarmacy(String codecityfarmacy) {
        this.codecityfarmacy = codecityfarmacy;
    }

}
