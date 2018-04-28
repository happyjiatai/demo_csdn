package com.example.demo_29_reentrantlock;

public class ProductQueueTest {
    private static ProductQueue productQueue = new ProductQueue<Integer>();
    public static void main(String[] args) {
        new FactoryThread().start();
        new ConsumeThread("jiatai1").start();
        new ConsumeThread("jiatai2").start();
        new ConsumeThread("jiatai3").start();
        new ConsumeThread("jiatai4").start();
    }

    static class FactoryThread extends Thread{
        @Override
        public void run() {
            super.run();
            for(int i = 0; i < 100; i++) {
                try {
                    productQueue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ConsumeThread extends Thread{
        ConsumeThread(String s){
            super(s);
        }
        @Override
        public void run() {
            super.run();
            for(int i = 0; i < 25; i++) {
                try {
                    System.out.println(Thread.currentThread() + " get " + productQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
