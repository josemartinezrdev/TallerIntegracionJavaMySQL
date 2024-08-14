package com.tallerjavamysql.modeadmin.application;

import com.tallerjavamysql.modeadmin.domain.entity.ModeAdmin;
import com.tallerjavamysql.modeadmin.domain.service.ModeAdminService;

public class CreateModeAdminUseCase {
    private final ModeAdminService modeAdminService;

    public CreateModeAdminUseCase(ModeAdminService modeAdminService) {
        this.modeAdminService = modeAdminService;
    }

    public void execute(ModeAdmin modeAdmin) {
        modeAdminService.createModeAdmin(modeAdmin);
    }
}
