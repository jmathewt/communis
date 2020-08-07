package com.rhema.communis.mission.region;

import com.rhema.communis.common.AbstractController;
import com.rhema.communis.common.CommunisError;
import com.rhema.communis.common.CommunisResponse;
import com.rhema.communis.mission.domain.ministry.Frequency;
import com.rhema.communis.mission.domain.region.Region;
import com.rhema.communis.mission.domain.region.RegionTier;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/mission/region")
@Api(tags = "Mission - Region")
public class RegionController extends AbstractController<Region, String> {

    @Autowired
    private RegionService service;

    @RequestMapping(value = "/{regionId}/subRegion", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<CommunisResponse<Region>> createSubregion(@RequestBody @Valid Region region, @PathVariable String regionId) {
        this.logger.debug("Request to CREATE object : " + region);
        try {
            return new ResponseEntity<CommunisResponse<Region>>(new CommunisResponse(this.service.createSubRegion(regionId, region)), HttpStatus.OK);
        } catch (ResponseStatusException r) {
            return new ResponseEntity<CommunisResponse<Region>>(new CommunisResponse(new CommunisError(r.getMessage())), r.getStatus());
        } catch (Exception e) {
            this.logger.error("Exception creating a SubRegion ", e);
            return new ResponseEntity<CommunisResponse<Region>>(new CommunisResponse(new CommunisError(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{regionId}/subRegion", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CommunisResponse<List<Region>>> getSubregions(@PathVariable String regionId) {
        try {
            return new ResponseEntity<CommunisResponse<List<Region>>>(new CommunisResponse(this.service.findSubRegions(regionId)), HttpStatus.OK);
        } catch (ResponseStatusException r) {
            return new ResponseEntity<CommunisResponse<List<Region>>>(new CommunisResponse(new CommunisError(r.getMessage())), r.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<CommunisResponse<List<Region>>>(new CommunisResponse(new CommunisError(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/tiers", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CommunisResponse<RegionTier[]>> getRegionTiers() {
        return new ResponseEntity<CommunisResponse<RegionTier[]>>(new CommunisResponse(RegionTier.values()), HttpStatus.OK);
    }

    @RequestMapping(value = "/ministryFrequency", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CommunisResponse<Frequency[]>> getMinistryTypes() {
        return new ResponseEntity<CommunisResponse<Frequency[]>>(new CommunisResponse(Frequency.values()), HttpStatus.OK);
    }
}
