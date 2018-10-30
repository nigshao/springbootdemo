package com.example.springbootdemo.designMode.factory;

public class PhoneFactory {
    public Phone makeAppPhone() {
        return new PhoneApple();
    }

    public Phone makeHuaweiPhone() {
        return new PhoneHuwei();
    }

    public static void main(String[] args) {
        PhoneFactory factory = new PhoneFactory();
        Phone applephone = factory.makeAppPhone();
        applephone.make();
        Phone huaweiPhone = factory.makeHuaweiPhone();
        huaweiPhone.make();
    }


}
