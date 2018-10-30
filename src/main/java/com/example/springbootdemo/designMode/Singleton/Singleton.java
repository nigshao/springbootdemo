package com.example.springbootdemo.designMode.Singleton;
//
public class Singleton {

    //lazy
    //hungry   qishi wo
    private static Singleton singleton = new Singleton();

    public Singleton() {
    }

    public Singleton instance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public Singleton instances() {
        if (singleton == null) {
            synchronized (this) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
