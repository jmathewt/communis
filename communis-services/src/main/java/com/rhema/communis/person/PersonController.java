package com.rhema.communis.person;

import com.rhema.communis.domain.Address;
import com.rhema.communis.member.AddressService;
import com.rhema.communis.mission.domain.person.PersonDerived;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public PersonDerived create(@RequestBody PersonDerived person){
        if (null != person.getAddress()) {
            List<Address> createdAddresses = addressService.createAddresses(person.getAddress());
            person.setAddress(createdAddresses);
        }
        return personService.saveOrUpdate(person);
    }

    @PutMapping("/{id}/address")
    public PersonDerived updateAddress(@PathVariable String id,
                                       @RequestBody List<Address> addresses){
        List<Address> createdAddresses = addressService.createAddresses(addresses);
        return personService.updateAddress(id, createdAddresses);
    }

    @GetMapping("/{id}")
    public PersonDerived find(@PathVariable String id){
        return personService.find(id);
    }
}
