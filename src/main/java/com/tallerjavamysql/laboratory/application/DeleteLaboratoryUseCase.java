package com.tallerjavamysql.laboratory.application;

import com.tallerjavamysql.laboratory.domain.service.LaboratoryService;

public class DeleteLaboratoryUseCase {
    private final LaboratoryService laboratoryService;

    public DeleteLaboratoryUseCase(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public void execute(int id) {
        laboratoryService.deleteLaboratory(id);
    }
}
