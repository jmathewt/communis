package com.rhema.communis.mission.domain.employee;

import com.rhema.communis.domain.BaseEntity;
import com.rhema.communis.domain.users.Person;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "employee")
@Getter @Setter
public class Employee extends BaseEntity {

    private Person personId;

    private Double salary;

    private Set<EmployeeRole> roles;

    private EmployeeDetails details;


}
