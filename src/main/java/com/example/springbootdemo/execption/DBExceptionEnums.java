package com.example.springbootdemo.execption;

public enum DBExceptionEnums implements ExceptionEnum {

    SYSTEM_ERROR(3333, "系统服务异常"),

    SYSTEM_FAILURE(4444,"验签失败");


    private int code;

    private String message;

    DBExceptionEnums(int code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
