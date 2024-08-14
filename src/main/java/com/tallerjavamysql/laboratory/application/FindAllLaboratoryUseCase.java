package com.tallerjavamysql.laboratory.application;

import java.util.List;

import com.tallerjavamysql.laboratory.domain.entity.Laboratory;
import com.tallerjavamysql.laboratory.domain.service.LaboratoryService;

public class FindAllLaboratoryUseCase {
    private final LaboratoryService laboratoryService;

    public FindAllLaboratoryUseCase(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    public List<Laboratory> execute() {
        return laboratoryService.findAllLaboratories();
    }
}
