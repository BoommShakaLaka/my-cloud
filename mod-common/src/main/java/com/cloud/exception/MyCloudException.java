package com.cloud.exception;

import io.swagger.models.auth.In;

public class MyCloudException extends Exception {
    private int errorCode;

    public MyCloudException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
