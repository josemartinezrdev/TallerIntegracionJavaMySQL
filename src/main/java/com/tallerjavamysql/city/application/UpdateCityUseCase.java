package com.tallerjavamysql.city.application;

import com.tallerjavamysql.city.domain.entity.City;
import com.tallerjavamysql.city.domain.service.CityService;

public class UpdateCityUseCase {
    private final CityService cityService;

    public UpdateCityUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public void execute(City city, String codecity) {
        cityService.updateCity(city, codecity);
    }
}
