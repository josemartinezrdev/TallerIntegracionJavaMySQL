package com.tallerjavamysql.actprinciple.application;

import com.tallerjavamysql.actprinciple.domain.entity.ActPrinciple;
import com.tallerjavamysql.actprinciple.domain.service.ActPrincipleService;

public class FindByIdActPrincipleUseCase {
    private final ActPrincipleService actPrincipleService;

    public FindByIdActPrincipleUseCase(ActPrincipleService actPrincipleService) {
        this.actPrincipleService = actPrincipleService;
    }

    public ActPrinciple execute(int idap) {
        return actPrincipleService.findByIdActPrinciple(idap);
    }
}
