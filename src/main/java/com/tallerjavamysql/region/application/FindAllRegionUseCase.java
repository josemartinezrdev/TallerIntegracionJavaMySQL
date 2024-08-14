package com.tallerjavamysql.region.application;

import java.util.List;

import com.tallerjavamysql.region.domain.entity.Region;
import com.tallerjavamysql.region.domain.service.RegionService;

public class FindAllRegionUseCase {
    private final RegionService regionService;

    public FindAllRegionUseCase(RegionService regionService) {
        this.regionService = regionService;
    }

    public List<Region> execute() {
        return regionService.findAllRegions();
    }

}
