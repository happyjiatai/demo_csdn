package com.example.demo_10_executorservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "simpleTest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit1();
        submit2();
        submit3();
    }

    private void submit1() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for(int i = 0; i< 10; i++){
                    sum += i;
                }
                return sum;
            }
        });
        try {
            Log.d(TAG, "the result of submit1 is: " + future.get());
        }catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        }
        executorService.shutdown();
    }

    private void submit2(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "do something");
            }
        }, "jiatai happy");
        try {
            Log.d(TAG, "the result of submit2 is: " + future.get());
        }catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        }
        executorService.shutdown();
    }

    private void submit3(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<?> future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "do something");
            }
        });
        try {
            Log.d(TAG, "the result of submit3 is: " + future.get());
        }catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        }
        executorService.shutdown();
    }
}
