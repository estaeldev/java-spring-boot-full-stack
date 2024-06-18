package com.in28minutes.rest.webservices.core.exception.enums;

public enum ErrorCodeEnum {
    
    // BUSINESS EXCEPTION
    BU0001("error create post", "BU-0001"),
    BU0002("error create user", "BU-0002"),
    
    // USER EXCEPTION
    US0001("error delete user", "US-0001"),
    US0002("error find user", "US-0002"),
    
    // POST EXCEPTION
    PO0001("error delete post", "PO-0001"),
    PO0002("error find post", "PO-0002");

    private final String message;
    private final String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

}
