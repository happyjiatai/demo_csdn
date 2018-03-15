package com.example.demo_11_singleton.demo;

/**
 * Created by jiatai on 18-3-15.
 */

public class LanHanSingleton {
    private static LanHanSingleton instance;

    private LanHanSingleton() {

    }

    /**
     * 增加synchronized关键字，该方法为同步方法，保证多线程单例对象唯一
     */
    public static synchronized LanHanSingleton getInstance() {
        if (instance == null) {
            instance = new LanHanSingleton();
        }
        return instance;
    }
}
