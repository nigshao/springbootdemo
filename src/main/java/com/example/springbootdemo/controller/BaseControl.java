package com.example.springbootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.util.LoggerFactory;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class BaseControl {

    Logger log = LoggerFactory.getServerErrorLogger(BaseControl.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest request, Exception ex) {
        String uri = request.getRequestURI().toString();
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        Map<String, String> params = new HashMap<>();
        for (Map.Entry entry : entries) {
            String key = (String) entry.getKey();
            String[] values = (String[]) entry.getValue();
            params.put(key, values.length == 1 ? values[0]:JSONObject.toJSONString(values));
        }
        JSONObject headerJson = RequestHandler.handlerJson(request);
        log.info("uri:{} , headerJson:{} , params:{} ，header:{}, exception{}",uri,headerJson,JSONObject.toJSON(params),ExceptionUtils.getStackTrace(ex));
        return "";
    }

}
