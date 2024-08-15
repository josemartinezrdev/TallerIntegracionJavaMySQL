package com.tallerjavamysql.farmacy.domain.service;

import java.util.List;

import com.tallerjavamysql.farmacy.domain.entity.Farmacy;

public interface FarmacyService {

    public void createFarmacy(Farmacy farmacy);

    public void updateFarmacy(Farmacy farmacy);

    public void deleteFarmacy(int idfarmacy);

    public List<Farmacy> findAllFarmacies();

    public Farmacy findByIdFarmacy(int idfarmacy);

}
