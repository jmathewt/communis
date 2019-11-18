package com.rhema.communis.member;

import com.rhema.communis.common.AbstractController;
import com.rhema.communis.domain.Address;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController extends AbstractController<Address, String> {

}
