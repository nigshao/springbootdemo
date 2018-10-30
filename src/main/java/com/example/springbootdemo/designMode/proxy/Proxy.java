package com.example.springbootdemo.designMode.proxy;

/**
 * 代理模式就是多一个代理类出来，替原对象进行一些操作
 */
public class Proxy implements Sourceable {

    Source source;

    @Override
    public void method() {
        System.out.println("before proxy");
        source = new Source();
        source.method();
        System.out.println("after proxy");
    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.method();
    }
}
