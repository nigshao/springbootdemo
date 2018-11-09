package com.example.springbootdemo.util;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.execption.ServiceException;

public class ResponseTools {

    private static ResponseTools responseUtil = null;

    private ResponseTools() {
        super();
    }

    public static ResponseTools get() {
        if (responseUtil == null) {
            responseUtil = new ResponseTools();
        }
        return responseUtil;
    }


    public String response(Object obj) {
        String result = null;
        if (obj instanceof ServiceException) {
            result = handleErro((ServiceException) obj);
        }
        return result;
    }

    private String handleErro(ServiceException obj) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(obj.getCode());
        responseResult.setMessage(obj.getMessage());
        responseResult.setData(new Object());
        return JSONObject.toJSONString(responseResult);
    }

}
