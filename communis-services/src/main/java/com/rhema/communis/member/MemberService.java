package com.rhema.communis.member;

import com.rhema.communis.common.AbstractService;
import com.rhema.communis.domain.Address;
import com.rhema.communis.mission.domain.family.Family;
import com.rhema.communis.mission.domain.family.FamilyMember;
import com.rhema.communis.mission.domain.person.Member;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

@Service
public class MemberService extends AbstractService<Member, String> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MongoRepository<Member, String> personRepository;
    private final AddressService addressService;
    private final FamilyService familyService;

    @Autowired
    public MemberService(MongoRepository<Member, String> personRepository,
                         AddressService addressService, FamilyService familyService){
        this.personRepository = personRepository;
        this.addressService = addressService;
        this.familyService = familyService;
    }

    @Transactional
    public Member create(Member person){
        if(CollectionUtils.isNotEmpty(person.getAddress())){
            Set<Address> addressToBeCreated = person.getAddress().stream()
                    .filter(address -> StringUtils.isEmpty(address.getId()))
                    .collect(Collectors.toSet());
            person.getAddress().addAll(addressService.createAddresses(addressToBeCreated));
        }
        Family family = person.getFamily();
        person.setFamily(null);
        person = saveOrUpdate(person);
        if(family != null && family.getMembers() != null && family.getMembers().size()>1){
            throw new IllegalArgumentException("Family members should only include one entry");
        }else if(family != null && CollectionUtils.isNotEmpty(family.getMembers())){
            FamilyMember familyMember = family.getMembers().iterator().next();
            familyMember.setPersonId(person.getId());
            if(StringUtils.isEmpty(family.getId())){
                person.setFamily(familyService.createFamily(family));
            }else{
                person.setFamily(familyService.updateFamilyMembers(family, person.getId()));
            }
            person = saveOrUpdate(person);
        }
        return person;
    }

    public Member update(Member person) {
        Member existingPerson = this.find(person.getId());
        if(existingPerson == null){
            throw new IllegalArgumentException("Person - " + person.getId() + " not found");
        }
        fillExistingProperties().accept(person, existingPerson);
        BeanUtils.copyProperties(person, existingPerson);
        this.saveOrUpdate(existingPerson);
        return this.find(person.getId());
    }

    private BiConsumer<Member, Member> fillExistingProperties(){
        return (updateMember, existingMember) -> {
            updateMember.setFamily(existingMember.getFamily());
            updateMember.setAddress(existingMember.getAddress());
        };
    }

    public Member createAddress(Set<Address> newAddresses, String personId){
        Member existingPerson = this.find(personId);
        if(CollectionUtils.isNotEmpty(newAddresses)){
            existingPerson.getAddress()
                    .addAll(addressService.checkAndCreateNonExistentAddresses().apply(newAddresses));
        }
        return this.saveOrUpdate(existingPerson);
    }

}
