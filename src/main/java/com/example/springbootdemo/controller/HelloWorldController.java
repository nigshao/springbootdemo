package com.example.springbootdemo.controller;

import com.example.springbootdemo.aspect.ZdyAnnotation;
import com.example.springbootdemo.config.AppVersion;
import com.example.springbootdemo.domain.TestDomain;
import com.example.springbootdemo.util.LoggerFactory;
import javafx.beans.binding.ObjectExpression;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@ServletComponentScan
public class HelloWorldController extends BaseControl {
    private static final Logger serverInfo_log = LoggerFactory.getServerInfoLogger(HelloWorldController.class);
    /**
     * 缓冲策略 对应的名字
     */
    private static final String ehCacheValue = "demo";

    /**
     * 缓存的key
     */
    public static final String THING_ALL_KEY = "\"thing_all\"";

    @Autowired
    AppVersion appversion;

    @ZdyAnnotation(name = "helloannotationName")
    @RequestMapping("/hello")
    public Object index(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("appversion", appversion.getName());
        return returnMap;
    }

    @RequestMapping("domain")
    public void testDomain(TestDomain domain, HttpServletResponse rep, HttpServletRequest req) {
        System.out.println(domain.getName());
        System.out.println(domain.getDomainSon().getSonName());
    }

    @RequestMapping("testCache")
    @Cacheable(key = "'cacheKey'", value = ehCacheValue)
    public String testCache() {
        System.out.println("entre cache");
        return "this is ehcahe";
    }

}