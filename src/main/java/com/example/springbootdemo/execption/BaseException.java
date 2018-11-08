package com.example.springbootdemo.execption;

public class BaseException extends RuntimeException {

    private int code;

    public BaseException( int code,String message) {
        super(message);
        this.code = code;
    }


}
