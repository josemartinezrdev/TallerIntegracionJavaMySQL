package com.tallerjavamysql.medicine.domain.service;

import java.util.List;

import com.tallerjavamysql.medicine.domain.entity.Medicine;

public interface MedicineService {

    public void createMedicine(Medicine medicine);

    public void updateMedicine(Medicine medicine);

    public void deleteMedicine(int id);

    public List<Medicine> findAllMedicines();

    public Medicine findByIdMedicine(int id);
}
