package com.example.springbootdemo.controller;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;

public class RequestHandler {

    public static JSONObject   handlerJson(HttpServletRequest request){

        String clientId = request.getHeader("clientId");
        String imei = request.getHeader("imei");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clientId",clientId);
        jsonObject.put("imei",imei);
        return jsonObject;
    }
}
