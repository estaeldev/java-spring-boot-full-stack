package com.in28minutes.springboot.core.exception.enums;

public enum ErrorCodeEnum {

    // Error Todo Exception
    TO0001("Error Create Todo", "TO-0001"),
    TO0002("Error Delete Todo", "TO-0002"),
    TO0003("Error Delete By Id Todo", "TO-0003"),
    TO0004("Error Find Todo", "TO-0004"),
    TO0005("Error Find By Id Todo", "TO-0005"),
    TO0006("Error Update Todo", "TO-0006"),
    
    // Error User Exception
    US0001("Error Create User", "US-0001"),
    US0002("Error Find User", "US-0002"),
    US0003("Error Find By Id User", "US-0003"),
    US0004("Error Create User Exist By Id", "US-0004");

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
