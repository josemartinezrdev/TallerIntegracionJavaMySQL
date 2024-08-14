package com.tallerjavamysql.medicine.domain.entity;

public class Medicine {
    private int id;
    private String proceedings;
    private String namemedicine;
    private String healthregister;
    private String description;
    private String descriptionshort;
    private String namerol;

    private int codemodeadmin;
    private int codeap;
    private int idum;
    private int codelab;

    public Medicine() {
    }

    public Medicine(int id, String proceedings, String namemedicine, String healthregister, String description,
            String descriptionshort, String namerol, int codemodeadmin, int codeap, int idum, int codelab) {
        this.id = id;
        this.proceedings = proceedings;
        this.namemedicine = namemedicine;
        this.healthregister = healthregister;
        this.description = description;
        this.descriptionshort = descriptionshort;
        this.namerol = namerol;
        this.codemodeadmin = codemodeadmin;
        this.codeap = codeap;
        this.idum = idum;
        this.codelab = codelab;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProceedings() {
        return this.proceedings;
    }

    public void setProceedings(String proceedings) {
        this.proceedings = proceedings;
    }

    public String getNamemedicine() {
        return this.namemedicine;
    }

    public void setNamemedicine(String namemedicine) {
        this.namemedicine = namemedicine;
    }

    public String getHealthregister() {
        return this.healthregister;
    }

    public void setHealthregister(String healthregister) {
        this.healthregister = healthregister;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionshort() {
        return this.descriptionshort;
    }

    public void setDescriptionshort(String descriptionshort) {
        this.descriptionshort = descriptionshort;
    }

    public String getNamerol() {
        return this.namerol;
    }

    public void setNamerol(String namerol) {
        this.namerol = namerol;
    }

    public int getCodemodeadmin() {
        return this.codemodeadmin;
    }

    public void setCodemodeadmin(int codemodeadmin) {
        this.codemodeadmin = codemodeadmin;
    }

    public int getCodeap() {
        return this.codeap;
    }

    public void setCodeap(int codeap) {
        this.codeap = codeap;
    }

    public int getIdum() {
        return this.idum;
    }

    public void setIdum(int idum) {
        this.idum = idum;
    }

    public int getCodelab() {
        return this.codelab;
    }

    public void setCodelab(int codelab) {
        this.codelab = codelab;
    }

}
