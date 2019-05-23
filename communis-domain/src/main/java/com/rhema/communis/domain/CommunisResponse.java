package com.rhema.communis.domain;

public class CommunisResponse {
    public Object data;
    public String error;

    public CommunisResponse() {

    }

    public CommunisResponse(Object data) {
        this.data = data;
    }

    public CommunisResponse(String error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
