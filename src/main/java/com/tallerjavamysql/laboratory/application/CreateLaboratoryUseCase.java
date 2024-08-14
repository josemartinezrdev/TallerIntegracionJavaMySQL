package com.tallerjavamysql.laboratory.application;

import com.tallerjavamysql.laboratory.domain.entity.Laboratory;
import com.tallerjavamysql.laboratory.domain.service.LaboratoryService;

public class CreateLaboratoryUseCase {
    private final LaboratoryService laboratoryService;

    public CreateLaboratoryUseCase(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public void execute(Laboratory laboratory) {
        laboratoryService.createLaboratory(laboratory);
    }
}
