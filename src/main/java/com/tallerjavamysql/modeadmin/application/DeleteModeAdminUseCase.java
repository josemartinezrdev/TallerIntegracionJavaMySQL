package com.tallerjavamysql.modeadmin.application;

import com.tallerjavamysql.modeadmin.domain.service.ModeAdminService;

public class DeleteModeAdminUseCase {
    private final ModeAdminService modeAdminService;

    public DeleteModeAdminUseCase(ModeAdminService modeAdminService) {
        this.modeAdminService = modeAdminService;
    }

    public void execute(int id) {
        modeAdminService.deleteModeAdmin(id);
    }
}
