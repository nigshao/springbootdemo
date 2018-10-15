package com.example.springbootdemo.listner;

import com.example.springbootdemo.config.AppVersion;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class matchListner  implements ServletContextListener {
    @Autowired
    AppVersion appversion;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

       /* while (true){
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("=====appName :"+appversion.getName());
        }*/
        System.out.println("=====appName :"+appversion.getName());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
