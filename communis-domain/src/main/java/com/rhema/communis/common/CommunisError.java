package com.rhema.communis.common;


import javax.validation.constraints.NotNull;

public class CommunisError {
    @NotNull
    private Object exception;

    public CommunisError(@NotNull Object exception) {
        this.exception = exception;
    }

    public Object getException() {
        return exception;
    }

    public void setException(Object exception) {
        this.exception = exception;
    }
}
