package com.tallerjavamysql.farmamedicine.application;

import com.tallerjavamysql.farmamedicine.domain.entity.FarmaMedicine;
import com.tallerjavamysql.farmamedicine.domain.service.FarmaMedicineService;

public class FindByIdFarmaMedicineUseCase {
    private final FarmaMedicineService farmaMedicineService;

    public FindByIdFarmaMedicineUseCase(FarmaMedicineService farmaMedicineService) {
        this.farmaMedicineService = farmaMedicineService;
    }

    public FarmaMedicine execute(int idfarmacy, int idmedicine) {
        return farmaMedicineService.findByIdFarmaMedicine(idfarmacy, idmedicine);
    }
}
