package com.example.demo_29_reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class MyClass {
    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args){
        new ReentrantLockThread("jiatai1").start();
        new ReentrantLockThread("jiatai2").start();
        new ReentrantLockThread("jiatai3").start();
        new ReentrantLockThread("jiatai4").start();
        new ReentrantLockThread("jiatai5").start();
    }

    private static void f1(){
        lock.lock();
        try {
            System.out.println("do something" + Thread.currentThread() + " time is :" + System.currentTimeMillis());
            Thread.sleep(2000);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    static class ReentrantLockThread extends Thread{
        ReentrantLockThread(String s){
            super(s);
        }
        @Override
        public void run() {
            super.run();
            f1();
        }
    }
}
