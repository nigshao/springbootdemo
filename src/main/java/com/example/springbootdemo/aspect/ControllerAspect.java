package com.example.springbootdemo.aspect;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.controller.RequestHandler;
import com.example.springbootdemo.util.LoggerFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Component
@Aspect
public class ControllerAspect {

    private static final Logger serverInfo_log = LoggerFactory.getServerInfoLogger(ControllerAspect.class);

    @Pointcut("execution(public * com.example.springbootdemo.controller..*.*(..))")
    public void pointCut() {
    }

    @Around(value = "pointCut()")
    public Object aspectBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();
        String uri = request.getRequestURI().toString();
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        Map<String, String> params = new HashMap<>();
        for (Map.Entry entry : entries) {
            String key = (String) entry.getKey();
            String[] values = (String[]) entry.getValue();
            params.put(key, values.length == 1 ? values[0] : JSONObject.toJSONString(values));
        }
        JSONObject headerJson = RequestHandler.handlerJson(request);

        Object object = joinPoint.proceed();
        //这里的方法返回的结果，只有是一个对象的情况下，转为string才不会出错，不然会出错
        String resultStr = JSONObject.toJSONString(object);
        JSONObject resultObject = JSONObject.parseObject(resultStr);
        //在所有的返回接口中添加统一的返回内容
        resultObject.put("aspectdata", "and in aspect");
        serverInfo_log.info("url:{}, headers:{}, params:{}, responseValue:{}", uri, headerJson, JSONObject.toJSONString(params), JSONObject.toJSONString(resultObject));
        return resultObject;
    }
}
