package com.example.demo_11_singleton.demo;

/**
 * Created by jiatai on 18-3-15.
 */

public enum EnumSingleton {
    //枚举实例的创建是线程安全的，任何情况下都是单例（包括反序列化）
    INSTANCE;

    public void doSomething(){

    }
}
