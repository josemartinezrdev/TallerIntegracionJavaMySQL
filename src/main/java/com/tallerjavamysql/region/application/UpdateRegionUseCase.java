package com.tallerjavamysql.region.application;

import com.tallerjavamysql.region.domain.entity.Region;
import com.tallerjavamysql.region.domain.service.RegionService;

public class UpdateRegionUseCase {
    private final RegionService regionService;

    public UpdateRegionUseCase(RegionService regionService) {
        this.regionService = regionService;
    }

    public void execute(Region region, String codereg) {
        regionService.updateRegion(region, codereg);
    }

}
