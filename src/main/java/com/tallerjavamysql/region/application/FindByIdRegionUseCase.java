package com.tallerjavamysql.region.application;

import com.tallerjavamysql.region.domain.entity.Region;
import com.tallerjavamysql.region.domain.service.RegionService;

public class FindByIdRegionUseCase {
    private final RegionService regionService;

    public FindByIdRegionUseCase(RegionService regionService) {
        this.regionService = regionService;
    }

    public Region execute(String codereg) {
        return regionService.findByIdRegion(codereg);
    }

}
