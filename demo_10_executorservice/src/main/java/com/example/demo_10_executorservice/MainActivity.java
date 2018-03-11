package com.example.demo_10_executorservice;

import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "simpleTest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        awaitTermination();
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

    private void shutdown1(){
        Log.d(TAG, "----shutdown1 begin---- ");
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Log.d(TAG, "----task1 begin---- ");
        Future future1 = executorService.submit(new Task1());

        Log.d(TAG, "----task2 begin---- ");
        Future future2 = executorService.submit(new Task2());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "----task3 begin---- ");
        Future future3 = executorService.submit(new Task3());

        executorService.shutdown();
        Log.d(TAG, "----executorService.shutdown---- ");

        Future future4 = null;
        try {
            future4 = executorService.submit(new Task4());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        try {
            Log.d(TAG, "the result of shutdown1 is: " + future1.get());
            Log.d(TAG, "the result of shutdown1 is: " + future2.get());
            Log.d(TAG, "the result of shutdown1 is: " + future3.get());
            Log.d(TAG, "the result of shutdown1 is: " + future4.get());
        }catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        Log.d(TAG, "----shutdown1 end---- ");
    }

    private void shutdownNow(){
        Log.d(TAG, "----shutdown1 begin---- ");
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Log.d(TAG, "----task1 begin---- ");
        Future future1 = executorService.submit(new Task1());

        Log.d(TAG, "----task2 begin---- ");
        Future future2 = executorService.submit(new Task2());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "----task3 begin---- ");
        Future future3 = executorService.submit(new Task3());

        List<Runnable> list = executorService.shutdownNow();
        Log.d(TAG, "----executorService.shutdownNow---- ");

        for(Runnable runnable : list){
            Log.d(TAG, "runnable is : " + runnable.toString());
        }

        Future future4 = null;
        try {
            future4 = executorService.submit(new Task4());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        try {
            Log.d(TAG, "the result of shutdown1 is: " + future1.get());
            Log.d(TAG, "the result of shutdown1 is: " + future2.get());
        }catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }

//        try {
//            Log.d(TAG, "the result of shutdown1 is: " + future3.get());
//        }catch (InterruptedException | ExecutionException ex){
//            ex.printStackTrace();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }

        Log.d(TAG, "----shutdown1 end---- ");
    }


    private void awaitTermination(){
        Log.d(TAG, "----shutdown1 begin---- ");
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Log.d(TAG, "----task1 begin---- ");
        Future future1 = executorService.submit(new Task1());

        Log.d(TAG, "----task2 begin---- ");
        Future future2 = executorService.submit(new Task2());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "----task3 begin---- ");
        Future future3 = executorService.submit(new Task3());

        boolean flag = true;
        try {
            flag = executorService.awaitTermination(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Log.d(TAG, "----executorService.awaitTermination---- " + flag);
            e.printStackTrace();
        }
        Log.d(TAG, "----executorService.shutdownNow---- ");

        Future future4 = null;
        try {
            future4 = executorService.submit(new Task4());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        try {
            Log.d(TAG, "the result of shutdown1 is: " + future1.get());
            Log.d(TAG, "the result of shutdown1 is: " + future2.get());
            Log.d(TAG, "the result of shutdown1 is: " + future3.get());
            Log.d(TAG, "the result of shutdown1 is: " + future4.get());
        }catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }

//        try {
//            Log.d(TAG, "the result of shutdown1 is: " + future3.get());
//        }catch (InterruptedException | ExecutionException ex){
//            ex.printStackTrace();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }

        Log.d(TAG, "----shutdown1 end---- ");
    }

    private class Task1 implements Callable<String>{
        @Override
        public String call() throws Exception {
            int sum = 0;
            for(int i = 0; i< 10; i++){
                sum += i;
            }
            return "task1";
        }
    }

    private class Task2 implements Callable<String>{
        @Override
        public String call() throws Exception {
            int sum = 0;
            for(int i = 0; i< 10; i++){
                sum += i;
            }
            Thread.sleep(5000);
            return "task2";
        }
    }

    private class Task3 implements Callable<String>{
        @Override
        public String call() throws Exception {
            int sum = 0;
            for(int i = 0; i< 10; i++){
                sum += i;
            }
            Thread.sleep(2000);
            return "task3";
        }
    }

    private class Task4 implements Callable<String>{
        @Override
        public String call() throws Exception {
            int sum = 0;
            for(int i = 0; i< 10; i++){
                sum += i;
            }
            Thread.sleep(2000);
            return "task4";
        }
    }
}
