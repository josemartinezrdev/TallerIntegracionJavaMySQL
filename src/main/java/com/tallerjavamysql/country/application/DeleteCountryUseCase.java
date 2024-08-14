package com.tallerjavamysql.country.application;

import com.tallerjavamysql.country.domain.service.CountryService;

public class DeleteCountryUseCase {
    
    private final CountryService countryService;

    public DeleteCountryUseCase(CountryService countryService) {
        this.countryService = countryService;
    }

    public void execute(String codecontry) {
        countryService.deleteCountry(codecontry);
    }
}
