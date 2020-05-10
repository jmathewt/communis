package com.rhema.communis.person;

import com.rhema.communis.common.CommunisResponse;
import com.rhema.communis.domain.Address;
import com.rhema.communis.member.AddressService;
import com.rhema.communis.mission.domain.person.PersonDerived;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    private final AddressService addressService;

    @Autowired
    public PersonController(PersonService personService, AddressService addressService){
        this.personService = personService;
        this.addressService = addressService;
    }

    @PostMapping("")
    public ResponseEntity<CommunisResponse> create(@RequestBody PersonDerived person){
        if(person == null){
            return new ResponseEntity<>(BAD_REQUEST);
        }
        return personService.saveOrUpdate(person);
    }

    @PutMapping("/{id}")
    public PersonDerived updateAddress(@PathVariable String id,
                                       @RequestBody List<Address> address){
        List<Address> createdAddresses =  address
                .stream()
                .map(addressService::saveOrUpdate)
                .collect(Collectors.toList());
        PersonDerived person = personService.find(id);
        person.setAddress(createdAddresses);
        personService.saveOrUpdate(person);
        return personService.find(id);
    }

    @GetMapping("/{id}")
    public PersonDerived find(@PathVariable String id){
        return personService.find(id);
    }
}
