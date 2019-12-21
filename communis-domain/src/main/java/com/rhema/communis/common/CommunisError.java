package com.rhema.communis.common;

import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

public class CommunisError {

    @NotNull
    private HttpStatus status;
    @NotNull
    private String error;

    public CommunisError(@NotNull HttpStatus status, @NotNull String error) {
        this.status = status;
        this.error = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
