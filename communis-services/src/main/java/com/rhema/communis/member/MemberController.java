package com.rhema.communis.member;

import com.rhema.communis.common.CommunisError;
import com.rhema.communis.common.CommunisResponse;
import com.rhema.communis.mission.domain.person.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/person")
public class MemberController {

    private final MemberService personService;

    @Autowired
    public MemberController(MemberService personService){
        this.personService = personService;
    }

    @PostMapping("")
    public ResponseEntity<CommunisResponse> create(@RequestBody Member person){
        if(person == null) {
            return new ResponseEntity<>(BAD_REQUEST);
        }
        return new ResponseEntity<CommunisResponse>(new CommunisResponse(
                personService.create(person)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommunisResponse> update(@PathVariable String id,
                                                   @RequestBody Member person) {
        try {
            if(person == null) {
                return new ResponseEntity<>(BAD_REQUEST);
            }
            person.setId(id);
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(
                    personService.update(person)), HttpStatus.OK);
        }catch(IllegalArgumentException e){
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(
                    new CommunisError(e.getMessage())), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<CommunisResponse> find(@PathVariable String id){
        Member retrievedPerson = personService.find(id);
        if(StringUtils.isEmpty(retrievedPerson.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CommunisResponse>(new CommunisResponse(retrievedPerson),
                HttpStatus.OK);
    }
}
