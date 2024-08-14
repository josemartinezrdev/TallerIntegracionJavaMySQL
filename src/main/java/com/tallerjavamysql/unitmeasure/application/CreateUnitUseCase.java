package com.tallerjavamysql.unitmeasure.application;

import com.tallerjavamysql.unitmeasure.domain.entity.Unit;
import com.tallerjavamysql.unitmeasure.domain.service.UnitService;

public class CreateUnitUseCase {
    private final UnitService unitService;

    public CreateUnitUseCase(UnitService unitService) {
        this.unitService = unitService;
    }

    public void execute(Unit unit) {
        unitService.createUnit(unit);
    }
}
