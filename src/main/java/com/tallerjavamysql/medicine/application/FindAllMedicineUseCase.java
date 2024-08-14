package com.tallerjavamysql.medicine.application;

import java.util.List;

import com.tallerjavamysql.medicine.domain.entity.Medicine;
import com.tallerjavamysql.medicine.domain.service.MedicineService;

public class FindAllMedicineUseCase {
    private final MedicineService medicineService;

    public FindAllMedicineUseCase(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public List<Medicine> execute() {
        return medicineService.findAllMedicines();
    }
}
