package com.example.demo_11_singleton.demo;

/**
 * Created by jiatai on 18-3-15.
 */

public class JHanSingleton {
    //static final单例对象，类加载的时候就初始化
    private static final JHanSingleton instance = new JHanSingleton();

    //私有构造方法，使得外界不能直接new
    private JHanSingleton() {
    }

    //公有静态方法，对外提供获取单例接口
    public static JHanSingleton getInstance() {
        return instance;
    }
}
