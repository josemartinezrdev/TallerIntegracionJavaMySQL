package com.tallerjavamysql.unitmeasure.application;

import com.tallerjavamysql.unitmeasure.domain.entity.Unit;
import com.tallerjavamysql.unitmeasure.domain.service.UnitService;

public class FindByIdUnitUseCase {

    private final UnitService unitService;

    public FindByIdUnitUseCase(UnitService unitService) {
        this.unitService = unitService;
    }

    public Unit execute(int idum) {
        return unitService.findByIdUnit(idum);
    }
}
