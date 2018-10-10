package com.example.springbootdemo.controller;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@ServletComponentScan
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        String content = request.getParameter("content");
        return "springboot detail now:" + content;
    }
    
}