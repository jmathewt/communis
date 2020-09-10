package com.rhema.communis.address;

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

    public Set<Address> createOrUpdateAddresses(Set<Address> addresses) {
        return addresses.stream().map(address -> {
            if(StringUtils.isEmpty(address.getId())){
                return this.save(address);
            }
            return this.update(address);
        }).collect(Collectors.toSet());
    }
}
