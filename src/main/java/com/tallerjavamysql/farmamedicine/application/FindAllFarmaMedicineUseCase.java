package com.tallerjavamysql.farmamedicine.application;

import java.util.List;

import com.tallerjavamysql.farmamedicine.domain.entity.FarmaMedicine;
import com.tallerjavamysql.farmamedicine.domain.service.FarmaMedicineService;

public class FindAllFarmaMedicineUseCase {

    private final FarmaMedicineService farmaMedicineService;

    public FindAllFarmaMedicineUseCase(FarmaMedicineService farmaMedicineService) {
        this.farmaMedicineService = farmaMedicineService;
    }

    public List<FarmaMedicine> execute() {
        return farmaMedicineService.findAllFarmaMedicines();
    }
}
