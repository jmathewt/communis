package com.rhema.communis.mission.missionary;

import com.rhema.communis.common.AbstractController;
import com.rhema.communis.mission.domain.Missionary;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mission/missionary")
@Api(tags = "Mission - Missionary")
public class MissionaryController extends AbstractController<Missionary, String> {
}
