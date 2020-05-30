package com.rhema.communis.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseEntity {

    @Id
    private String id;
    @CreatedBy
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String createdBy;
    @CreatedDate
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime createdDate;
    @LastModifiedBy
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String lastModifiedBy;
    @LastModifiedDate
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime lastModifiedDate;
    @Version
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long version;

}
