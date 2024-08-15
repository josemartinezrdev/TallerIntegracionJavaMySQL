package com.tallerjavamysql.farmacy.application;

import com.tallerjavamysql.farmacy.domain.entity.Farmacy;
import com.tallerjavamysql.farmacy.domain.service.FarmacyService;

public class UpdateFarmacyUseCase {
    private final FarmacyService farmacyService;

    public UpdateFarmacyUseCase(FarmacyService farmacyService) {
        this.farmacyService = farmacyService;
    }

    public void execute(Farmacy farmacy) {
        farmacyService.updateFarmacy(farmacy);
    }

}
