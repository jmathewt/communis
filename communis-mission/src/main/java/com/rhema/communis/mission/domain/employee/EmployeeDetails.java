package com.rhema.communis.mission.domain.employee;

import lombok.Getter;
import lombok.Setter;

import java.util.EnumMap;

@Getter @Setter
public class EmployeeDetails {

    private EnumMap<Details, Object> employeeDetails;

}
