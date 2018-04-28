package com.example.demo_29_reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    public static void main(String[] args) throws InterruptedException {
        System.out.println("jiatai4 run");
        new ReentrantLockThread4("jiatai4").start();
        Thread.sleep(2000);
        System.out.println("jiatai1 run");
        new ReentrantLockThread1("jiatai1").start();
        Thread.sleep(2000);
        System.out.println("jiatai2 run");
        new ReentrantLockThread2("jiatai2").start();
        System.out.println("jiatai3 run");
        new ReentrantLockThread3("jiatai31").start();
        new ReentrantLockThread3("jiatai32").start();
        new ReentrantLockThread3("jiatai33").start();

    }

    private static void f1(){
        lock.lock();
        try {
            condition.await();
            System.out.println("f1() do something" + Thread.currentThread() + " time is :" + System.currentTimeMillis());
            Thread.sleep(2000);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private static void f2(){
        lock.lock();
        try {
            //condition.signal();
            System.out.println("f2() do something" + Thread.currentThread() + " time is :" + System.currentTimeMillis());
            Thread.sleep(5000);
            condition.signal();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private static void f3(){
        lock.lock();
        try {
            System.out.println("f3() do something" + Thread.currentThread() + " time is :" + System.currentTimeMillis());
            Thread.sleep(2000);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private static void f4(){
        lock.lock();
        try {
            condition2.await();
            System.out.println("f4() do something" + Thread.currentThread() + " time is :" + System.currentTimeMillis());
            Thread.sleep(2000);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    static class ReentrantLockThread1 extends Thread{
        ReentrantLockThread1(String s){
            super(s);
        }
        @Override
        public void run() {
            super.run();
            f1();
        }
    }

    static class ReentrantLockThread2 extends Thread{
        ReentrantLockThread2(String s){
            super(s);
        }
        @Override
        public void run() {
            super.run();
            f2();
        }
    }

    static class ReentrantLockThread3 extends Thread{
        ReentrantLockThread3(String s){
            super(s);
        }
        @Override
        public void run() {
            super.run();
            f3();
        }
    }

    static class ReentrantLockThread4 extends Thread{
        ReentrantLockThread4(String s){
            super(s);
        }
        @Override
        public void run() {
            super.run();
            f4();
        }
    }
}
