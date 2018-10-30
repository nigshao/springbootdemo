package com.example.springbootdemo.designMode.factory;

public class PhoneApple extends Phone {

    String appId;


    @Override
    public void make() {
        System.out.println("this is make apple phone");
    }

}
