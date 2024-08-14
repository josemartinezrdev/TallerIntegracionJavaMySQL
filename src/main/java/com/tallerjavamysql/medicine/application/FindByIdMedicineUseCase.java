package com.tallerjavamysql.medicine.application;

import com.tallerjavamysql.medicine.domain.entity.Medicine;
import com.tallerjavamysql.medicine.domain.service.MedicineService;

public class FindByIdMedicineUseCase {
    private final MedicineService medicineService;

    public FindByIdMedicineUseCase(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public Medicine execute(int id) {
        return medicineService.findByIdMedicine(id);
    }
}
