package com.rhema.communis.mission.family;

import com.rhema.communis.mission.domain.family.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/family")
public class FamilyController {

    private final FamilyService familyService;

    @Autowired
    public FamilyController(FamilyService familyService){
        this.familyService = familyService;
    }

    @PostMapping("")
    public Family create(@RequestBody Family family){
        return familyService.saveOrUpdate(family);
    }

    @GetMapping("/{id}")
    public Family find(@PathVariable String id){
        return familyService.find(id);
    }
}
