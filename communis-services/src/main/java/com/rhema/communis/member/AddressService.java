package com.rhema.communis.member;

import com.rhema.communis.common.AbstractService;
import com.rhema.communis.domain.Address;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.Set;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

@Service
public class AddressService extends AbstractService<Address, String> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public UnaryOperator<Set<Address>> checkAndCreateNonExistentAddresses(){
        return newAddresses -> {
            if(CollectionUtils.isEmpty(newAddresses)){
                return Collections.emptySet();
            }
            Set<Address> nonExistingAddresses = newAddresses.stream()
                    .filter(address -> StringUtils.isEmpty(address.getId()))
                    .collect(Collectors.toSet());
            Set<Address> createdAddresses = CollectionUtils.isNotEmpty(nonExistingAddresses) ?
                    createAddresses(nonExistingAddresses) : Collections.emptySet();
            return createdAddresses;
        };
    }

    public Set<Address> createAddresses(Set<Address> addresses) {
        return addresses
                .stream()
                .map(this::save)
                .collect(Collectors.toSet());
    }
}
