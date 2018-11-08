package com.example.springbootdemo.interceotor;

import com.example.springbootdemo.execption.BaseException;
import com.example.springbootdemo.util.FileReadUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@Component
public class LoginIntercepror implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod method = (HandlerMethod) handler;
        method.getMethod().getName();
        Set<String> urlwhitelist = FileReadUtil.readFile("classpath:urlwhitelist");
        String uri = request.getRequestURI();
        if(!urlwhitelist.contains(uri)){
            throw new BaseException(3333,"urlwhitelist not contain uri");
        }
        //Todo checkAuth

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
