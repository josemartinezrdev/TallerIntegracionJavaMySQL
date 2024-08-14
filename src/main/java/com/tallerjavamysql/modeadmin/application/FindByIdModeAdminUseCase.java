package com.tallerjavamysql.modeadmin.application;

import com.tallerjavamysql.modeadmin.domain.entity.ModeAdmin;
import com.tallerjavamysql.modeadmin.domain.service.ModeAdminService;

public class FindByIdModeAdminUseCase {
    private final ModeAdminService modeAdminService;

    public FindByIdModeAdminUseCase(ModeAdminService modeAdminService) {
        this.modeAdminService = modeAdminService;
    }

    public ModeAdmin execute(int id) {
        return modeAdminService.findByIdModeAdmin(id);
    }

}
