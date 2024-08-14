package com.tallerjavamysql.region.domain.entity;

public class Region {
    private String codereg;
    private String namereg;
    private String codecountry;

    public Region() {
    }

    public Region(String codereg, String namereg, String codecountry) {
        this.codereg = codereg;
        this.namereg = namereg;
        this.codecountry = codecountry;
    }

    public String getCodereg() {
        return this.codereg;
    }

    public void setCodereg(String codereg) {
        this.codereg = codereg;
    }

    public String getNamereg() {
        return this.namereg;
    }

    public void setNamereg(String namereg) {
        this.namereg = namereg;
    }

    public String getCodecountry() {
        return this.codecountry;
    }

    public void setCodecountry(String codecountry) {
        this.codecountry = codecountry;
    }

}
