package com.tallerjavamysql.actprinciple.application;

import java.util.List;

import com.tallerjavamysql.actprinciple.domain.entity.ActPrinciple;
import com.tallerjavamysql.actprinciple.domain.service.ActPrincipleService;

public class FindAllActPrincipleUseCase {
    private final ActPrincipleService actPrincipleService;

    public FindAllActPrincipleUseCase(ActPrincipleService actPrincipleService) {
        this.actPrincipleService = actPrincipleService;
    }

    public List<ActPrinciple> execute() {
        return actPrincipleService.findAllActPrinciples();
    }
}
