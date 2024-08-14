package com.tallerjavamysql.laboratory.domain.service;

import java.util.List;

import com.tallerjavamysql.laboratory.domain.entity.Laboratory;

public interface LaboratoryService {

    public void createLaboratory(Laboratory laboratory);

    public void updateLaboratory(Laboratory laboratory);

    public void deleteLaboratory(int id);

    public List<Laboratory> findAllLaboratories();

    public Laboratory findByIdLaboratory(int id);

}
