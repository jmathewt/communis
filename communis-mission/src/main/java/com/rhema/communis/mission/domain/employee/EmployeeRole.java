package com.rhema.communis.mission.domain.employee;

import com.rhema.communis.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "employeeRole")
@Getter
@Setter
public class EmployeeRole extends BaseEntity {

    private String name;
    private String description;

    @Override
    public String toString() {
        return "EmployeeRole{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
