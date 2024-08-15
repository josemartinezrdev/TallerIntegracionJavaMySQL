package com.tallerjavamysql.farmacy.application;

import java.util.List;

import com.tallerjavamysql.farmacy.domain.entity.Farmacy;
import com.tallerjavamysql.farmacy.domain.service.FarmacyService;

public class FindAllFarmacyUseCase {
    private final FarmacyService farmacyService;

    public FindAllFarmacyUseCase(FarmacyService farmacyService) {
        this.farmacyService = farmacyService;
    }

    public List<Farmacy> execute() {
        return farmacyService.findAllFarmacies();
    }
}
