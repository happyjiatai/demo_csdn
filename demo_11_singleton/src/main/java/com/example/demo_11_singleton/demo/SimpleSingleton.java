package com.example.demo_11_singleton.demo;

/**
 * Created by jiatai on 18-3-15.
 */

public class SimpleSingleton {
    //1.static单例变量
    private static SimpleSingleton instance;

    //2.私有的构造方法
    private SimpleSingleton() {

    }

    //3.静态方法为调用者提供单例对象
    public static SimpleSingleton getInstance() {
        if (instance == null) {
            instance = new SimpleSingleton();
        }
        return instance;
    }
}
