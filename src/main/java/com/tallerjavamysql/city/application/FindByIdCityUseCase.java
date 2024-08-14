package com.tallerjavamysql.city.application;

import com.tallerjavamysql.city.domain.entity.City;
import com.tallerjavamysql.city.domain.service.CityService;

public class FindByIdCityUseCase {
    private final CityService cityService;

    public FindByIdCityUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public City execute(String codecity) {
        return cityService.findByIdCity(codecity);
    }

}
