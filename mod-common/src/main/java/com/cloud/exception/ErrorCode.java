package com.cloud.exception;

public enum ErrorCode {
    INVALID_REQUEST_PARAMETER(2001, "Invalid request parameter"),
    RESOURCE_NOT_FOUND(2002, "Requested resource not found"),
    INSUFFICIENT_PERMISSION(2003, "Insufficient permission to access resource"),
    DATABASE_OPERATION_FAILED(2004, "Database operation failed"),
    NETWORK_CONNECTION_ERROR(2005, "Network connection error"),
    FILE_UPLOAD_FAILED(2006, "File upload failed"),
    USER_ALREADY_EXISTS(2007, "User already exists"),
    USER_NOT_FOUND(2008, "User not found"),
    INVALID_PASSWORD(2009, "Invalid password"),
    INVALID_CAPTCHA(2010, "Invalid captcha");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
