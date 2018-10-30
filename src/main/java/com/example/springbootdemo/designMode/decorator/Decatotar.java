package com.example.springbootdemo.designMode.decorator;

/**
 * Source类是被装饰类，Decorator类是一个装饰类，可以为Source类动态的添加一些功能，代码如下
 */
public class Decatotar implements Sourceable {

    private Sourceable source;

    public Decatotar(Sourceable source) {
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("before decorator mode");
        source.method();
        System.out.println("after decorator mode");
    }

    public static void main(String[] args) {
        Sourceable source = new Source();
        Decatotar decatotar = new Decatotar(source);
        decatotar.method();
    }
}