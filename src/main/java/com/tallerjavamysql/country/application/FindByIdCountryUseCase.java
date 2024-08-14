package com.tallerjavamysql.country.application;

import com.tallerjavamysql.country.domain.entity.Country;
import com.tallerjavamysql.country.domain.service.CountryService;

public class FindByIdCountryUseCase {
    
    private final CountryService countryService;

    public FindByIdCountryUseCase(CountryService countryService) {
        this.countryService = countryService;
    }

    public Country execute(String codecountry) {
        return countryService.findByIdCountry(codecountry);
    }

}
