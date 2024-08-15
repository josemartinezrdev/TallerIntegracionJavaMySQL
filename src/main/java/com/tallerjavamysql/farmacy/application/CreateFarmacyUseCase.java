package com.tallerjavamysql.farmacy.application;

import com.tallerjavamysql.farmacy.domain.entity.Farmacy;
import com.tallerjavamysql.farmacy.domain.service.FarmacyService;

public class CreateFarmacyUseCase {
    private final FarmacyService farmacyService;

    public CreateFarmacyUseCase(FarmacyService farmacyService) {
        this.farmacyService = farmacyService;
    }

    public void execute(Farmacy farmacy) {
        farmacyService.createFarmacy(farmacy);
    }
}
