package com.example.springbootdemo.domain;

public class TestDomainSon {

    int sonId;

    String sonName;

    public int getSonId() {
        return sonId;
    }

    public void setSonId(int sonId) {
        this.sonId = sonId;
    }

    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }

   /* 采纳率：52%12级2015.05.21
    鉴权（authentication）是指验证用户是否拥有访问系统的权利。
    传统的鉴权是通过密码来验证的。这种方式的前提是，
    每个获得密码的用户都已经被授权。在建立用户时，就为此用户分配一个密码，
    用户的密码可以由管理员指定，也可以由用户自行申请。这种方式的弱点十分明显：
    一旦密码被偷或用户遗失密码，情况就会十分麻烦，需要管理员对用户密码进行重新修改，
    而修改密码之前还要人工验证用户的合法身份。为了克服这种鉴权方式的缺点，
    需要一个更加可靠的鉴权方式。目前的主流鉴权方式是利用认证授权来验证数字签名的正确与否。逻辑上，
    授权发生在鉴权之后，而实际上，这两者常常是一个过程。*/
}

