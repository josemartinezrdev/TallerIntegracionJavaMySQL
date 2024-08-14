package com.tallerjavamysql.modeadmin.application;

import com.tallerjavamysql.modeadmin.domain.entity.ModeAdmin;
import com.tallerjavamysql.modeadmin.domain.service.ModeAdminService;

public class UpdateModeAdminUseCase {
    private final ModeAdminService modeAdminService;

    public UpdateModeAdminUseCase(ModeAdminService modeAdminService) {
        this.modeAdminService = modeAdminService;
    }

    public void execute(ModeAdmin modeAdmin) {
        modeAdminService.updateModeAdmin(modeAdmin);
    }
}
