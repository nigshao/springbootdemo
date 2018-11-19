package com.example.springbootdemo.aspect;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)  //runtime  运行时起作用
@Target(ElementType.METHOD)   //针对方法起作用
@Documented   //家注解将被保存在javadoc中
@Inherited   //子类可以继承父类注解
public @interface ZdyAnnotation {


    public String name() default "";

    public int value() default 1;
    

}
