package com.tallerjavamysql.country.application;

import java.util.List;

import com.tallerjavamysql.country.domain.entity.Country;
import com.tallerjavamysql.country.domain.service.CountryService;

public class FindAllCountryUseCase {
    
    private final CountryService countryService;

    public FindAllCountryUseCase(CountryService countryService) {
        this.countryService = countryService;
    }

    public List<Country> execute() {
        return countryService.findAllCountries();
    }
}
