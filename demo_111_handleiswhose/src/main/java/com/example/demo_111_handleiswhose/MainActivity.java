package com.example.demo_111_handleiswhose;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "handlertest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HandlerThread handlerThread = new HandlerThread("jiataitest");
        handlerThread.start();
        Handler handler = new MyHandler(handlerThread.getLooper());
        handler.sendEmptyMessage(1);

    }

    private class MyHandler extends Handler{
        MyHandler(Looper looper){
            super(looper);
            Log.d(TAG, "MyHandler constructor");
            printThread();
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d(TAG, "MyHandler handleMessage");
            printThread();
        }

        public void printThread(){
            Log.d(TAG, "the thread is " + Thread.currentThread().toString());
        }
    }
}
