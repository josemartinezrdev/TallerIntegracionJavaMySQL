package com.tallerjavamysql.unitmeasure.application;

import java.util.List;

import com.tallerjavamysql.unitmeasure.domain.entity.Unit;
import com.tallerjavamysql.unitmeasure.domain.service.UnitService;

public class FindAllUnitUseCase {
    private final UnitService unitService;

    public FindAllUnitUseCase(UnitService unitService) {
        this.unitService = unitService;
    }

    public List<Unit> execute() {
        return unitService.findAllUnits();
    }
}
