package com.example.springbootdemo.designMode.decorator;

public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("this  is decorator mode");
    }

}
