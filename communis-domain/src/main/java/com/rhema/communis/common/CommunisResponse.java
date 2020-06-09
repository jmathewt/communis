package com.rhema.communis.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class CommunisResponse<T> {
    public T data;
    public CommunisError error;

    public CommunisResponse(T data) {
        this.data = data;
    }

    public CommunisResponse(CommunisError error) {
        this.error = error;
    }
}
