package com.tallerjavamysql.farmamedicine.domain.service;

import java.util.List;

import com.tallerjavamysql.farmamedicine.domain.entity.FarmaMedicine;

public interface FarmaMedicineService {

    public void createFarmaMedicine(FarmaMedicine farmaMedicine);

    public void updateFarmaMedicine(FarmaMedicine farmaMedicine, int idfarmacy, int idmedicine);

    public void deleteFarmaMedicine(int idfarmacy, int idmedicine);

    public List<FarmaMedicine> findAllFarmaMedicines();

    public FarmaMedicine findByIdFarmaMedicine(int idfarmacy, int idmedicine);

}
