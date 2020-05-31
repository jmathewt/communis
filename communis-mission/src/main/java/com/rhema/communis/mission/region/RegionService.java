package com.rhema.communis.mission.region;

import com.rhema.communis.address.AddressService;
import com.rhema.communis.common.AbstractService;
import com.rhema.communis.domain.Address;
import com.rhema.communis.mission.domain.region.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RegionService extends AbstractService<Region, String> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private RegionRepository regionRepository;
    private AddressService addressService;

    @Autowired
    public RegionService(RegionRepository regionRepository, AddressService addressService) {
        this.regionRepository = regionRepository;
        this.addressService = addressService;
    }

    public Region createSubRegion(String parentRegionId, Region subRegion) {

        Region parent = this.find(parentRegionId);
        if (parent == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Region " + parentRegionId + " not found");
        }
        subRegion.setParentRegion(parentRegionId);
        this.save(subRegion);

        parent.getSubRegions().add(subRegion.getId());
        this.update(parent);
        logger.info("Created new Sub Region with sub region name " + subRegion.getName());
        return subRegion;
    }

    public List<Region> findSubRegions(String regionId) {
        Region parent = this.find(regionId);
        return this.regionRepository.findByIds(parent.getSubRegions());
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Region> event) {
        Address address = event.getSource().getAddress();
        if (address != null && address.getId() == null) {
            addressService.save(event.getSource().getAddress());
        }
    }
}
