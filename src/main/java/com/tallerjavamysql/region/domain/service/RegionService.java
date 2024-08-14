package com.tallerjavamysql.region.domain.service;

import java.util.List;

import com.tallerjavamysql.region.domain.entity.Region;

public interface RegionService {
    public void createRegion(Region region);

    public void updateRegion(Region region, String codereg);

    public void deleteRegion(String codereg);

    public List<Region> findAllRegions();

    public Region findByIdRegion(String codereg);
}
