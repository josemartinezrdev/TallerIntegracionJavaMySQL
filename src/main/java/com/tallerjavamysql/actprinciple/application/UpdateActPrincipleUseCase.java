package com.tallerjavamysql.actprinciple.application;

import com.tallerjavamysql.actprinciple.domain.entity.ActPrinciple;
import com.tallerjavamysql.actprinciple.domain.service.ActPrincipleService;

public class UpdateActPrincipleUseCase {
    private final ActPrincipleService actPrincipleService;

    public UpdateActPrincipleUseCase(ActPrincipleService actPrincipleService) {
        this.actPrincipleService = actPrincipleService;
    }

    public void execute(ActPrinciple actprinciple) {
        actPrincipleService.updateActPrinciple(actprinciple);
    }
}
