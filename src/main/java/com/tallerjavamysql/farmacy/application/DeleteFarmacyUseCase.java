package com.tallerjavamysql.farmacy.application;

import com.tallerjavamysql.farmacy.domain.service.FarmacyService;

public class DeleteFarmacyUseCase {
    private final FarmacyService farmacyService;

    public DeleteFarmacyUseCase(FarmacyService farmacyService) {
        this.farmacyService = farmacyService;
    }

    public void execute(int idfarmacy) {
        farmacyService.deleteFarmacy(idfarmacy);
    }
}
