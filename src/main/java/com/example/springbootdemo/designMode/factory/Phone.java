package com.example.springbootdemo.designMode.factory;

import java.util.Date;

public class Phone implements PhoneInterface {

    private String name;

    private Date creatTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public void make() {
        System.out.println("this is first phone!");
    }
}
