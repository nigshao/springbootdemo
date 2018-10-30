package com.example.springbootdemo.designMode.factory;

public class PhoneHuwei extends Phone {

    String huaweiId;

    @Override
    public void make() {
        System.out.println("this is make huawei phone");
    }
}
