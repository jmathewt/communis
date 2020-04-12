package com.rhema.communis.mission.region;

import com.rhema.communis.common.AbstractController;
import com.rhema.communis.common.CommunisError;
import com.rhema.communis.common.CommunisResponse;
import com.rhema.communis.mission.domain.Region;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/mission/region")
@Api(tags = "Mission")
public class RegionController extends AbstractController<Region, String> {

    @Autowired
    private RegionService service;

    @RequestMapping(value = "/{regionId}/subRegion", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<CommunisResponse> createSubregion(@RequestBody @Valid Region region, @PathVariable String regionId, Principal principal) {
        this.logger.debug("Request to CREATE object : " + region);
        try {
            region.setCreatedBy(principal.getName());
            region.setLastModifiedBy(principal.getName());
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(this.service.createSubRegion(regionId, region)), HttpStatus.OK);
        } catch (ResponseStatusException r) {
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(new CommunisError(r.getMessage())), r.getStatus());
        } catch (Exception e) {
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(new CommunisError(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
