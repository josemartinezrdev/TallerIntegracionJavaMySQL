package com.tallerjavamysql.laboratory.domain.entity;

public class Laboratory {
    private int id;
    private String namelab;
    private String codecityreg;

    public Laboratory() {
    }

    public Laboratory(int id, String namelab, String codecityreg) {
        this.id = id;
        this.namelab = namelab;
        this.codecityreg = codecityreg;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamelab() {
        return this.namelab;
    }

    public void setNamelab(String namelab) {
        this.namelab = namelab;
    }

    public String getCodecityreg() {
        return this.codecityreg;
    }

    public void setCodecityreg(String codecityreg) {
        this.codecityreg = codecityreg;
    }

}
