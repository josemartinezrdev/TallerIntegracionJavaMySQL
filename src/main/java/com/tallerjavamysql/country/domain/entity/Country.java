package com.tallerjavamysql.country.domain.entity;

public class Country {

    private String codecountry;
    private String namecountry;

    public Country() {
    }

    public Country(String codecountry, String namecountry) {
        this.codecountry = codecountry;
        this.namecountry = namecountry;
    }

    public String getCodecountry() {
        return this.codecountry;
    }

    public void setCodecountry(String codecountry) {
        this.codecountry = codecountry;
    }

    public String getNamecountry() {
        return this.namecountry;
    }

    public void setNamecountry(String namecountry) {
        this.namecountry = namecountry;
    }

}
