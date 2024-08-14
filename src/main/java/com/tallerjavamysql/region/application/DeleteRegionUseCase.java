package com.tallerjavamysql.region.application;

import com.tallerjavamysql.region.domain.service.RegionService;

public class DeleteRegionUseCase {
    private final RegionService regionService;

    public DeleteRegionUseCase(RegionService regionService) {
        this.regionService = regionService;
    }

    public void execute(String codereg) {
        regionService.deleteRegion(codereg);
    }
}
