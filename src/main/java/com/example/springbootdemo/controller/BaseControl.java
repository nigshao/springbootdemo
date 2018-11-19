package com.example.springbootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.execption.DBExceptionEnums;
import com.example.springbootdemo.execption.ServiceException;
import com.example.springbootdemo.util.LoggerFactory;
import com.example.springbootdemo.util.ResponseTools;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class BaseControl {

   private static final Logger log = LoggerFactory.getServerErrorLogger(BaseControl.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest request, Exception ex) {
        String uri = request.getRequestURI();
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        Map<String, String> params = new HashMap<>();
        for (Map.Entry entry : entries) {
            String key = (String) entry.getKey();
            String[] values = (String[]) entry.getValue();
            params.put(key, values.length == 1 ? values[0] : JSONObject.toJSONString(values));
        }
        JSONObject headerJson = RequestHandler.handlerJson(request);
        String msg = ResponseTools.get().response(new ServiceException(DBExceptionEnums.SYSTEM_ERROR));
        log.info("uri:{} , params:{} ，header:{}, msg:{}, exception{}", uri, JSONObject.toJSONString(params), headerJson, msg,
                ExceptionUtils.getStackTrace(ex));
        return msg;
    }
}
