package com.tallerjavamysql.city.domain.service;

import java.util.List;

import com.tallerjavamysql.city.domain.entity.City;

public interface CityService {

    public void createCity(City city);

    public void updateCity(City city, String codecity);

    public void deleteCity(String codecity);

    public List<City> findAllCities();

    public City findByIdCity(String codecity);
}
