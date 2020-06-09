package com.rhema.communis.member;

import com.rhema.communis.common.AbstractController;
import com.rhema.communis.common.CommunisError;
import com.rhema.communis.common.CommunisResponse;
import com.rhema.communis.domain.Address;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
@Api(tags = "Core Apis")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommunisResponse> find (@PathVariable String id){
        Address address = addressService.find(id);
        if(address == null){
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(
                    new CommunisError("Unable to find address with id - " + id)),
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<CommunisResponse>(new CommunisResponse(address),
                HttpStatus.OK);
    }

}
