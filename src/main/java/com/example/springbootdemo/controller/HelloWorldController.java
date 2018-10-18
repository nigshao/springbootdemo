package com.example.springbootdemo.controller;

import com.example.springbootdemo.config.AppVersion;
import com.example.springbootdemo.domain.TestDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@ServletComponentScan
public class HelloWorldController {

    @Autowired
    AppVersion appversion;
    @RequestMapping("/hello")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return "springboot detail now prot:8007 :" + appversion.getName();
    }

    @RequestMapping("domain")
    public void testDomain(TestDomain domain,HttpServletResponse rep,HttpServletRequest req){
        System.out.println(domain.getName());
        System.out.println(domain.getDomainSon().getSonName());
    }


}