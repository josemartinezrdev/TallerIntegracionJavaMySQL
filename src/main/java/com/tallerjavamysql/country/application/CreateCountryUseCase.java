package com.tallerjavamysql.country.application;

import com.tallerjavamysql.country.domain.entity.Country;
import com.tallerjavamysql.country.domain.service.CountryService;

public class CreateCountryUseCase {
    
    private final CountryService countryService;

    public CreateCountryUseCase(CountryService countryService) {
        this.countryService = countryService;
    }

    public void execute(Country country) {
        countryService.createCountry(country);
    }

}
