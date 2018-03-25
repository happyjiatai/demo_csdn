package com.example.demo_14_rxjava_in_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "jiatai";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Flowable.just("Hello world").subscribe(new Consumer<String>() {
            @Override public void accept(String s) {
                Log.d(TAG, s);
            }
        });

        Flowable.just("Hello world").subscribe(System.out::println);
    }
}
