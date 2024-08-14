package com.tallerjavamysql.region.application;

import com.tallerjavamysql.region.domain.entity.Region;
import com.tallerjavamysql.region.domain.service.RegionService;

public class CreateRegionUseCase {
    private final RegionService regionService;

    public CreateRegionUseCase(RegionService regionService) {
        this.regionService = regionService;
    }

    public void execute(Region region) {
        regionService.createRegion(region);
    }
}
