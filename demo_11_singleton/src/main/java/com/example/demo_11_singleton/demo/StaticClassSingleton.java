package com.example.demo_11_singleton.demo;

/**
 * Created by jiatai on 18-3-15.
 */

public class StaticClassSingleton {
    //私有的构造方法，防止new
    private StaticClassSingleton() {

    }

    public static StaticClassSingleton getInstance() {
        System.out.println("StaticClassSingleton getInstance");
        return StaticClassSingletonHolder.instance;
    }

    public static void test(){
        System.out.println("StaticClassSingleton test");
    }

    /**
     * 静态内部类
     */
    private static class StaticClassSingletonHolder {
        //第一次加载内部类的时候，实例化单例对象
        private static final StaticClassSingleton instance = new StaticClassSingleton();
        static {
            System.out.println("StaticClassSingletonHolder load static field");
        }
    }
}