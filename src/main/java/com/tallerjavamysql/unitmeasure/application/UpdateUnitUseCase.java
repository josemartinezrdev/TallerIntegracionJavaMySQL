package com.tallerjavamysql.unitmeasure.application;

import com.tallerjavamysql.unitmeasure.domain.entity.Unit;
import com.tallerjavamysql.unitmeasure.domain.service.UnitService;

public class UpdateUnitUseCase {
    private final UnitService unitService;

    public UpdateUnitUseCase(UnitService unitService) {
        this.unitService = unitService;
    }

    public void execute(Unit unit) {
        unitService.updateUnit(unit);
    }
}
