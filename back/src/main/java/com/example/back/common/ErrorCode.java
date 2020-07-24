package com.example.back.common;

public enum ErrorCode {

    SUCCESS(0),

    JSON_STRINGIFY_FAILED(40001),

    LOGIN_FAILED(40002),

    UNAVAILABLE_COOKIE(40003),

    MISSING_REQUIRED_PARAMETERS(40004),

    OPERATE_FAILED(40005),

    REGISTER_FAILED(40006),

    SERVER_ERROR(50000),
    ;

    private int value;


    ErrorCode(int value) {
        this.value = value;
    }

    public String getName(int value) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.value == value) {
                return errorCode.name();
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}


