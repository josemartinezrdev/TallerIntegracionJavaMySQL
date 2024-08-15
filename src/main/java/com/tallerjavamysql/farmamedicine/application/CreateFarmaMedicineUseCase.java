package com.tallerjavamysql.farmamedicine.application;

import com.tallerjavamysql.farmamedicine.domain.entity.FarmaMedicine;
import com.tallerjavamysql.farmamedicine.domain.service.FarmaMedicineService;

public class CreateFarmaMedicineUseCase {
    private final FarmaMedicineService farmaMedicineService;

    public CreateFarmaMedicineUseCase(FarmaMedicineService farmaMedicineService) {
        this.farmaMedicineService = farmaMedicineService;
    }

    public void execute(FarmaMedicine farmaMedicine) {
        farmaMedicineService.createFarmaMedicine(farmaMedicine);
    }
}
