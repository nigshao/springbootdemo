package com.example.springbootdemo.util;

import org.slf4j.Logger;

public class LoggerFactory {

    private static final String SERVER_INFO = "serverInfo";

    private static final String SERVER_ERROR = "serverError";

    public static Logger getServerInfoLogger(Class<?> clazz) {

        return org.slf4j.LoggerFactory.getLogger(SERVER_INFO);

    }

    public static Logger getServerErrorLogger(Class<?> clazz) {

        return org.slf4j.LoggerFactory.getLogger(SERVER_ERROR);

    }
}
