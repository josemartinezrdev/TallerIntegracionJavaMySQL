package com.tallerjavamysql.city.application;

import com.tallerjavamysql.city.domain.service.CityService;

public class DeleteCityUseCase {
    private final CityService cityService;

    public DeleteCityUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public void execute(String codecity) {
        cityService.deleteCity(codecity);
    }
}
