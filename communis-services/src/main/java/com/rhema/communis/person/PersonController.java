package com.rhema.communis.person;

import com.rhema.communis.common.CommunisResponse;
import com.rhema.communis.mission.domain.person.PersonDerived;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping("")
    public ResponseEntity<CommunisResponse> create(@RequestBody PersonDerived person){
        if(person == null) {
            return new ResponseEntity<>(BAD_REQUEST);
        }
        return new ResponseEntity<CommunisResponse>(new CommunisResponse(
                personService.create(person)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommunisResponse> update(@PathVariable String id, @RequestBody PersonDerived person) {
        return new ResponseEntity<CommunisResponse>(new CommunisResponse(
                personService.update(person)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PersonDerived find(@PathVariable String id){
        return personService.find(id);
    }
}
