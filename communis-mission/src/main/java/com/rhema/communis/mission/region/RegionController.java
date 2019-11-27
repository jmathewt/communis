package com.rhema.communis.mission.region;

import com.rhema.communis.common.AbstractController;
import com.rhema.communis.mission.domain.Region;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mission/region")
@Api(tags = "Mission")
public class RegionController extends AbstractController<Region, String> {
}
