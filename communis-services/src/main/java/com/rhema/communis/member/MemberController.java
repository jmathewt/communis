package com.rhema.communis.member;

import com.rhema.communis.common.CommunisError;
import com.rhema.communis.common.CommunisResponse;
import com.rhema.communis.domain.Address;
import com.rhema.communis.mission.domain.family.Family;
import com.rhema.communis.mission.domain.person.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/person")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping("")
    public ResponseEntity<CommunisResponse> create(@RequestBody Member person){
        if(person == null) {
            return new ResponseEntity<>(BAD_REQUEST);
        }
        return new ResponseEntity<CommunisResponse>(new CommunisResponse(
                memberService.create(person)), HttpStatus.OK);
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
                    memberService.updateMember(person)), HttpStatus.OK);
        }catch(IllegalArgumentException e){
            return new ResponseEntity<CommunisResponse>(new CommunisResponse(
                    new CommunisError(e.getMessage())), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<CommunisResponse> find(@PathVariable String id){
        Member retrievedPerson = memberService.find(id);
        if(retrievedPerson == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CommunisResponse>(new CommunisResponse(retrievedPerson),
                HttpStatus.OK);
    }

    @PutMapping("/{id}/address")
    public ResponseEntity<CommunisResponse> createAddress(@PathVariable String id,
                                                          @RequestBody Collection<Address> address){
        return new ResponseEntity<CommunisResponse>(
                new CommunisResponse(memberService.createAddress(address, id)), HttpStatus.OK);
    }

    @PutMapping("/{id}/family")
    public ResponseEntity<CommunisResponse> createFamily(@PathVariable String id,
                                                          @RequestBody Family family){
        return new ResponseEntity<CommunisResponse>(
                new CommunisResponse(memberService.addMemberToAFamily(family, id)), HttpStatus.OK);
    }
}
