package com.example.springbootdemo.domain;

public class TestDomain {

    private int id;

    private String name;

    TestDomainSon domainSon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestDomainSon getDomainSon() {
        return domainSon;
    }

    public void setDomainSon(TestDomainSon domainSon) {
        this.domainSon = domainSon;
    }
}
