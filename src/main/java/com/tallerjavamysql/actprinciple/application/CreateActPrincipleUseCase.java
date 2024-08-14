package com.tallerjavamysql.actprinciple.application;

import com.tallerjavamysql.actprinciple.domain.entity.ActPrinciple;
import com.tallerjavamysql.actprinciple.domain.service.ActPrincipleService;

public class CreateActPrincipleUseCase {
    private final ActPrincipleService actPrincipleService;

    public CreateActPrincipleUseCase(ActPrincipleService actPrincipleService) {
        this.actPrincipleService = actPrincipleService;
    }

    public void execute(ActPrinciple actPrinciple) {
        actPrincipleService.createActPrinciple(actPrinciple);
    }
}
