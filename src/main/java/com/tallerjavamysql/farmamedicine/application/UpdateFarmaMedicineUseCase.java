package com.tallerjavamysql.farmamedicine.application;

import com.tallerjavamysql.farmamedicine.domain.entity.FarmaMedicine;
import com.tallerjavamysql.farmamedicine.domain.service.FarmaMedicineService;

public class UpdateFarmaMedicineUseCase {
    private final FarmaMedicineService farmaMedicineService;

    public UpdateFarmaMedicineUseCase(FarmaMedicineService farmaMedicineService) {
        this.farmaMedicineService = farmaMedicineService;
    }

    public void execute(FarmaMedicine farmaMedicine, int idfarmacy, int idmedicine) {
        farmaMedicineService.updateFarmaMedicine(farmaMedicine, idfarmacy, idmedicine);
    }
}
