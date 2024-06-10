package com.in28minutes.springboot.core.exception.enums;

public enum ErrorCodeEnum {

    ON0001("", "");
    
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
