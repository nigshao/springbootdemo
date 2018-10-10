package com.example.springbootdemo.controller;


import com.example.springbootdemo.util.JacksonJSONUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldControllerTest {
    private MockMvc  mvc;

    @Before
    public void setUp(){
         mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
     }


    @Test
    public void  getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())  //用MockMvcResultHandlers  将信息打印出来
                .andReturn();
    }
    @Test
    public void  getHello2() throws Exception {
        Map<String ,Object> map = new HashMap<>();  //用来放需要的参数,必须是用@RequestBody 来接受参数的
        map.put("content","test content");
        System.out.println(JacksonJSONUtils.toJSON(map));
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/hello")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JacksonJSONUtils.toJSON(map))).andReturn();// 返回执行请求的结果
        int status = mvcResult.getResponse().getStatus();
        String resultContent = mvcResult.getResponse().getContentAsString();
        System.out.println("============"+resultContent+"=============");
        System.out.println("============"+status+"=============");
    }
}