package com.rhema.communis.common;

public class CommunisResponse<T> {
    public T data;
    public CommunisError error;

    public CommunisResponse(T data) {
        this.data = data;
    }

    public CommunisResponse(CommunisError error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CommunisError getError() {
        return error;
    }

    public void setError(CommunisError error) {
        this.error = error;
    }
}
