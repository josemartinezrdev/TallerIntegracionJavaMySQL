package com.tallerjavamysql.farmacy.application;

import com.tallerjavamysql.farmacy.domain.entity.Farmacy;
import com.tallerjavamysql.farmacy.domain.service.FarmacyService;

public class FindByIdFarmacyUseCase {
    private final FarmacyService farmacyService;

    public FindByIdFarmacyUseCase(FarmacyService farmacyService) {
        this.farmacyService = farmacyService;
    }

    public Farmacy execute(int idfarmacy) {
        return farmacyService.findByIdFarmacy(idfarmacy);
    }
}
