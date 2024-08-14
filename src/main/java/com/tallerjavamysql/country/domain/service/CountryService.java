package com.tallerjavamysql.country.domain.service;

import java.util.List;

import com.tallerjavamysql.country.domain.entity.Country;

public interface CountryService {

    public void createCountry(Country country);

    public void updateCountry(Country country, String codecountry);

    public void deleteCountry(String codecountry);

    public List<Country> findAllCountries();

    public Country findByIdCountry(String codecountry);

}
