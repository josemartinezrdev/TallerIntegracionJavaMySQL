package com.tallerjavamysql.city.application;

import com.tallerjavamysql.city.domain.entity.City;
import com.tallerjavamysql.city.domain.service.CityService;

public class CreateCityUseCase {
    private final CityService cityService;

    public CreateCityUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public void execute(City city) {
        cityService.createCity(city);
    }

}
