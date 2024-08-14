package com.tallerjavamysql.medicine.application;

import com.tallerjavamysql.medicine.domain.entity.Medicine;
import com.tallerjavamysql.medicine.domain.service.MedicineService;

public class CreateMedicineUseCase {
    private final MedicineService medicineService;

    public CreateMedicineUseCase(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public void execute(Medicine medicine) {
        medicineService.createMedicine(medicine);
    }

}
