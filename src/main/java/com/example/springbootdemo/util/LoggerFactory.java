package com.example.springbootdemo.util;

import org.slf4j.Logger;

public class LoggerFactory {

    private static final String SERVER_INFO = "serverInfo";

    public static Logger getServerInfoLogger(Class<?> clazz) {

        return org.slf4j.LoggerFactory.getLogger(SERVER_INFO);

    }
}
