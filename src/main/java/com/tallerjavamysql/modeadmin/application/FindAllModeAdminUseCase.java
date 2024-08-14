package com.tallerjavamysql.modeadmin.application;

import java.util.List;

import com.tallerjavamysql.modeadmin.domain.entity.ModeAdmin;
import com.tallerjavamysql.modeadmin.domain.service.ModeAdminService;

public class FindAllModeAdminUseCase {
    private final ModeAdminService modeAdminService;

    public FindAllModeAdminUseCase(ModeAdminService modeAdminService) {
        this.modeAdminService = modeAdminService;
    }

    public List<ModeAdmin> execute() {
        return modeAdminService.findAllModesAdmin();
    }
}
