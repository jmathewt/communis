package com.rhema.communis.mission.organization;

import com.rhema.communis.common.AbstractController;
import com.rhema.communis.mission.domain.program.Organization;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mission/organization")
@Api(tags = "Mission - Organization")
public class OrganizationController extends AbstractController<Organization, String> {

    @Autowired
    private OrganizationService service;
}
