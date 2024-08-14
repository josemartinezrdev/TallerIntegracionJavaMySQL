package com.tallerjavamysql.laboratory.application;

import com.tallerjavamysql.laboratory.domain.entity.Laboratory;
import com.tallerjavamysql.laboratory.domain.service.LaboratoryService;

public class FindByIdLaboratoryUseCase {
    private final LaboratoryService laboratoryService;

    public FindByIdLaboratoryUseCase(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public Laboratory execute(int id) {
        return laboratoryService.findByIdLaboratory(id);
    }
}
