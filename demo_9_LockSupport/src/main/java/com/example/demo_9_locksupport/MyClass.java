package com.example.demo_9_locksupport;

import java.util.concurrent.locks.LockSupport;

public class MyClass {
    public static void main(String[] args){
        Thread boy = new Thread(){
            @Override
            public void run() {
                super.run();
                System.out.println("he is playing game");
                LockSupport.park();
                System.out.println("he must give up playing game and shop with his girl friend");
            }
        };
        boy.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("his girl friend calls him to shop with her");
        LockSupport.unpark(boy);
    }
}
