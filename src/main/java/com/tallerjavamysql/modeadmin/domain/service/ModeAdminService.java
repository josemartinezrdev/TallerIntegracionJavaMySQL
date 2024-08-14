package com.tallerjavamysql.modeadmin.domain.service;

import com.tallerjavamysql.modeadmin.domain.entity.ModeAdmin;
import java.util.List;

public interface ModeAdminService {

    public void createModeAdmin(ModeAdmin modeAdmin);

    public void updateModeAdmin(ModeAdmin modeAdmin);

    public void deleteModeAdmin(int id);

    public List<ModeAdmin> findAllModesAdmin();

    public ModeAdmin findByIdModeAdmin(int id);

}
