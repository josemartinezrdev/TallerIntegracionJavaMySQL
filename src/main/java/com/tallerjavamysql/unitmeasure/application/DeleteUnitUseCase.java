package com.tallerjavamysql.unitmeasure.application;

import com.tallerjavamysql.unitmeasure.domain.service.UnitService;

public class DeleteUnitUseCase {
    private final UnitService unitService;

    public DeleteUnitUseCase(UnitService unitService) {
        this.unitService = unitService;
    }

    public void execute(int idum) {
        unitService.deleteUnit(idum);
    }
}
