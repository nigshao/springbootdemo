package com.example.springbootdemo.execption;

//统一异常处理
public class ServiceException extends RuntimeException {

    private DBExceptionEnums dbExceptionEnums;

    public ServiceException(DBExceptionEnums dbExceptionEnums) {
        this.dbExceptionEnums = dbExceptionEnums;
    }

    @Override
    public String getMessage() {
        return dbExceptionEnums.getMessage();
    }
    
    public int getCode() {
        return dbExceptionEnums.getCode();
    }
}
