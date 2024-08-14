package com.tallerjavamysql.medicine.application;

import com.tallerjavamysql.medicine.domain.service.MedicineService;

public class DeleteMedicineUseCase {
    private final MedicineService medicineService;

    public DeleteMedicineUseCase(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public void execute(int id) {
        medicineService.deleteMedicine(id);
    }

}
