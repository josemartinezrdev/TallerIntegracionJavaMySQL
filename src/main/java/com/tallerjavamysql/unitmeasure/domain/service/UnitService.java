package com.tallerjavamysql.unitmeasure.domain.service;

import java.util.List;

import com.tallerjavamysql.unitmeasure.domain.entity.Unit;

public interface UnitService {
    public void createUnit(Unit unit);

    public void updateUnit(Unit unit);

    public void deleteUnit(int idum);

    public List<Unit> findAllUnits();

    public Unit findByIdUnit(int idum);
}
