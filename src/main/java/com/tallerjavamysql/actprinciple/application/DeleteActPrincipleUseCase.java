package com.tallerjavamysql.actprinciple.application;

import com.tallerjavamysql.actprinciple.domain.service.ActPrincipleService;

public class DeleteActPrincipleUseCase {
    private final ActPrincipleService actPrincipleService;

    public DeleteActPrincipleUseCase(ActPrincipleService actPrincipleService) {
        this.actPrincipleService = actPrincipleService;
    }

    public void execute(int idap) {
        actPrincipleService.deleteActPrinciple(idap);
    }
}
