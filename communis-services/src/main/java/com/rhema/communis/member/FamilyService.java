package com.rhema.communis.member;

import com.rhema.communis.common.AbstractService;
import com.rhema.communis.mission.domain.family.Family;
import com.rhema.communis.mission.domain.family.FamilyMember;
import org.springframework.stereotype.Service;

@Service
public class FamilyService extends AbstractService<Family, String> {

    public Family createFamily(Family nonExistantFamily) {
        return this.saveOrUpdate(nonExistantFamily);
    }

    public Family updateFamilyMembers(Family family, String memberId){
        Family existingFamily = this.find(family.getId());
        FamilyMember familyMember = family.getMembers().iterator().next();
        familyMember.setPersonId(memberId);
        existingFamily.getMembers().add(familyMember);
        return this.saveOrUpdate(existingFamily);
    }
}
