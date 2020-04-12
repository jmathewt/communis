package com.rhema.communis.mission.region;

import com.rhema.communis.common.AbstractController;
import com.rhema.communis.common.CommunisError;
import com.rhema.communis.common.CommunisResponse;
import com.rhema.communis.mission.domain.Region;
import com.rhema.communis.mission.domain.RegionTier;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/mission/region")
@Api(tags = "Mission - Region")
public class RegionController extends AbstractController<Region, String> {

    @Autowired
    private RegionService service;

    @RequestMapping(value = "/{regionId}/subRegion", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<CommunisResponse<Region>> createSubregion(@RequestBody @Valid Region region, @PathVariable String regionId, @ApiIgnore Principal principal) {
        this.logger.debug("Request to CREATE object : " + region);
        try {
            region.setCreatedBy(principal.getName());
            region.setLastModifiedBy(principal.getName());
            return new ResponseEntity<CommunisResponse<Region>>(new CommunisResponse(this.service.createSubRegion(regionId, region)), HttpStatus.OK);
        } catch (ResponseStatusException r) {
            return new ResponseEntity<CommunisResponse<Region>>(new CommunisResponse(new CommunisError(r.getMessage())), r.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<CommunisResponse<Region>>(new CommunisResponse(new CommunisError(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{regionId}/subRegion", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CommunisResponse<Region>> getSubregions(@PathVariable String regionId, @ApiIgnore Principal principal) {
        try {
            return new ResponseEntity<CommunisResponse<Region>>(new CommunisResponse(this.service.findSubRegions(regionId)), HttpStatus.OK);
        } catch (ResponseStatusException r) {
            return new ResponseEntity<CommunisResponse<Region>>(new CommunisResponse(new CommunisError(r.getMessage())), r.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<CommunisResponse<Region>>(new CommunisResponse(new CommunisError(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/tiers", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CommunisResponse<RegionTier[]>> getRegionTiers() {
        return new ResponseEntity<CommunisResponse<RegionTier[]>>(new CommunisResponse(RegionTier.values()), HttpStatus.OK);
    }
}
