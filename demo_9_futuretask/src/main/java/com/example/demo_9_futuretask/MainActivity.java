package com.example.demo_9_futuretask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "FutureTaskTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        method2();
    }

    private static void method1() {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyCallable());
        new Thread(futureTask).start();
        try {
            int sum = futureTask.get();
            Log.d(TAG, "the sum is :" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void method2(){
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyCallable());
        Future<?> future = executor.submit(futureTask);
        executor.shutdown();
        try {
            int sum = futureTask.get();
            Log.d(TAG, "the sum is :" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            Log.d(TAG, "the sum2 is :" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void method3(){
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future =  executor.submit(new MyCallable());
        executor.shutdown();
        try {
            int sum = future.get();
            Log.d(TAG, "the sum is :" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for(int i = 0; i < 10; i++){
                Log.d(TAG, "the i is : " + i);
                sum += i;
                Thread.sleep(200);
            }
            return sum;
        }
    }
}
