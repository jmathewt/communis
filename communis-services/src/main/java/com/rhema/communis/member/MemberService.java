package com.rhema.communis.member;

import com.rhema.communis.address.AddressService;
import com.rhema.communis.common.AbstractService;
import com.rhema.communis.domain.Address;
import com.rhema.communis.domain.users.Contact;
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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;

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
        if(CollectionUtils.isNotEmpty(person.getContacts())){
            Set<Contact> contacts = person.getContacts();
            boolean isMoreThanOnePrimaryContact = contacts.stream().filter(contact -> contact.isPrimary()).count() > 1;
            if(isMoreThanOnePrimaryContact){
                throw new IllegalArgumentException("There is more than one primary contact information!");
            }
        }
        if (CollectionUtils.isNotEmpty(person.getAddress())) {
            person.getAddress().addAll(addressService.createOrUpdateAddresses(person.getAddress()));
        }
        Family family = person.getFamily();
        person.setFamily(null);
        person = save(person);
        if(family != null && family.getMembers() != null && family.getMembers().size()>1){
            throw new IllegalArgumentException("Family members should only include one entry");
        }else if(family != null && CollectionUtils.isNotEmpty(family.getMembers())){
            createOrUpdateFamily().accept(family, person);
            person = save(person);
        }
        return person;
    }

    @Transactional
    public void updateMember(Member person) {
        Family familyToUpdate = person.getFamily();
        Set<Address> addressToUpdate = person.getAddress();
        Member existingPerson = this.find(person.getId());
        if(existingPerson == null){
            throw new IllegalArgumentException("Person - " + person.getId() + " not found");
        }
        BeanUtils.copyProperties(person, existingPerson);
        if(familyToUpdate != null){
            addMemberToAFamily(familyToUpdate, person.getId());
        }
        if(CollectionUtils.isNotEmpty(addressToUpdate)){
            createOrUpdateAddress(addressToUpdate, person.getId());
        }
        this.update(existingPerson);
    }

    private BiConsumer<Member, Member> fillExistingMemberProperties(){
        return (updateMember, existingMember) -> {
            updateMember.setFamily(existingMember.getFamily());
            updateMember.setAddress(existingMember.getAddress());
        };
    }

    @Transactional
    public Member createOrUpdateAddress(Collection<Address> addresses, String personId){
        Member existingPerson = this.find(personId);
        if(existingPerson == null){
            throw new IllegalArgumentException("Unable to find person with id - " + personId);
        }
        existingPerson.setAddress(addressService.createOrUpdateAddresses(new HashSet<>(addresses)));
        Set<Address> existingAddress = CollectionUtils.isEmpty(existingPerson.getAddress()) ?
                new HashSet<>() : existingPerson.getAddress();
        existingPerson.setAddress(existingAddress);

        return this.update(existingPerson);
    }

    public Member addMemberToAFamily(Family family, String personId){
        Member existingMember = this.find(personId);
        createOrUpdateFamily().accept(family, existingMember);
        return this.update(existingMember);
    }

    private BiConsumer<Family, Member> createOrUpdateFamily(){
        return (family, person) -> {
            FamilyMember familyMember = family.getMembers().iterator().next();
            familyMember.setPersonId(person.getId());
            if(StringUtils.isEmpty(family.getId())){
                person.setFamily(familyService.createFamily(family));
            }else{
                familyService.update(family);
                person.setFamily(familyService.addOrUpdateFamilyMember(family, person.getId()));
            }
        };
    }

}
