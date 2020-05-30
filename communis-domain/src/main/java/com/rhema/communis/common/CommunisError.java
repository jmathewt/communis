package com.rhema.communis.common;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CommunisError {
    @NotNull
    private Object exception;

    public CommunisError(@NotNull Object exception) {
        this.exception = exception;
    }

}
