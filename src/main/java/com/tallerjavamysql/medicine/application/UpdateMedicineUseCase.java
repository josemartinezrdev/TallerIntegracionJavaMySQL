package com.tallerjavamysql.medicine.application;

import com.tallerjavamysql.medicine.domain.entity.Medicine;
import com.tallerjavamysql.medicine.domain.service.MedicineService;

public class UpdateMedicineUseCase {

    private final MedicineService medicineService;

    public UpdateMedicineUseCase(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public void execute(Medicine medicine) {
        medicineService.updateMedicine(medicine);
    }
}
