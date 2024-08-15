package com.tallerjavamysql.farmamedicine.application;

import com.tallerjavamysql.farmamedicine.domain.service.FarmaMedicineService;

public class DeleteFarmaMedicineUseCase {
    private final FarmaMedicineService farmaMedicineService;

    public DeleteFarmaMedicineUseCase(FarmaMedicineService farmaMedicineService) {
        this.farmaMedicineService = farmaMedicineService;
    }

    public void execute(int idfarmacy, int idmedicine) {
        farmaMedicineService.deleteFarmaMedicine(idfarmacy, idmedicine);
    }
}
