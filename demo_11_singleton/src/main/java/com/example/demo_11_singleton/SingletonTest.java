package com.example.demo_11_singleton;

import com.example.demo_11_singleton.demo.StaticClassSingleton;

public class SingletonTest {
    public static void main(String[] args){
        StaticClassSingleton.test();
        StaticClassSingleton.getInstance();
        StaticClassSingleton.getInstance();
    }
}
