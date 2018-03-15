package com.example.demo_11_singleton.demo;

/**
 * Created by jiatai on 18-3-15.
 */

public class DCLSingleton {
    //增加volatile关键字，确保实例化instance时，编译成汇编指令的执行顺序
    private volatile static DCLSingleton instance;

    private DCLSingleton() {

    }

    public static DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                //当第一次调用getInstance方法时，即instance为空时，同步操作，保证多线程实例唯一
                //当以后调用getInstance方法时，即instance不为空时，不进入同步代码块，减少了不必要的同步开销
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}
