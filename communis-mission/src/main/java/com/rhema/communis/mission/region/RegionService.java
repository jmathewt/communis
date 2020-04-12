package com.rhema.communis.mission.region;

import com.rhema.communis.common.AbstractService;
import com.rhema.communis.mission.domain.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RegionService extends AbstractService<Region, String> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public Region createSubRegion(String parentRegionId, Region subRegion) {

        Region parent = this.find(parentRegionId);
        if (parent == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Region " + parentRegionId + " not found");
        }
        subRegion.setParentRegion(parentRegionId);
        this.saveOrUpdate(subRegion);

        parent.getSubRegions().add(subRegion.getId());
        this.saveOrUpdate(parent);
        logger.info("Created new Sub Region with sub region name " + subRegion.getMissionRegionName());
        return subRegion;
    }
}
