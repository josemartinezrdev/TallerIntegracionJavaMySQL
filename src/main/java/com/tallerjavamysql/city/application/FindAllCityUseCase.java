package com.tallerjavamysql.city.application;

import java.util.List;

import com.tallerjavamysql.city.domain.entity.City;
import com.tallerjavamysql.city.domain.service.CityService;

public class FindAllCityUseCase {
    private final CityService cityService;

    public FindAllCityUseCase(CityService cityService) {
        this.cityService = cityService;
    }

    public List<City> execute() {
        return cityService.findAllCities();
    }
}
