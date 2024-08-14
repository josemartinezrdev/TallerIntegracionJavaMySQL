package com.tallerjavamysql.actprinciple.domain.service;

import java.util.List;

import com.tallerjavamysql.actprinciple.domain.entity.ActPrinciple;

public interface ActPrincipleService {
    public void createActPrinciple(ActPrinciple actPrinciple);

    public void updateActPrinciple(ActPrinciple actPrinciple);

    public void deleteActPrinciple(int idap);

    public List<ActPrinciple> findAllActPrinciples();

    public ActPrinciple findByIdActPrinciple(int idap);
}
