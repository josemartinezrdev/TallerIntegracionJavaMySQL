package com.tallerjavamysql.country.application;

import com.tallerjavamysql.country.domain.entity.Country;
import com.tallerjavamysql.country.domain.service.CountryService;

public class UpdateCountryUseCase {

    private final CountryService countryService;

    public UpdateCountryUseCase(CountryService countryService) {
        this.countryService = countryService;
    }

    public void execute(Country country, String codecountry) {
        countryService.updateCountry(country, codecountry);
    }

}
