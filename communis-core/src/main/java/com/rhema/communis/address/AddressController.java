package com.rhema.communis.address;

import com.rhema.communis.common.AbstractController;
import com.rhema.communis.domain.Address;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/core/address")
@Api(tags = "Core Apis")
public class AddressController extends AbstractController<Address, String> {

}
