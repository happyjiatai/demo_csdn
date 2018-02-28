package com.example.demo_7_handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MyThread(this).start();
    }

    private static class MyHandler extends Handler{
        private WeakReference<MainActivity> mActivity;

        public  MyHandler(MainActivity activity){
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MainActivity mainActivity = mActivity.get();
            if (mainActivity == null) {
                return;
            }
            super.handleMessage(msg);
        }
    }

    private static class MyThread extends Thread{

        private WeakReference<MainActivity> mActivity;

        public  MyThread(MainActivity activity){
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void run() {
            MainActivity mainActivity = mActivity.get();
            if (mainActivity == null) {
                return;
            }
            super.run();
            SystemClock.sleep(20000);
            Looper.prepare();
            MyHandler handler = new MyHandler(mainActivity);
            handler.sendEmptyMessage(0);
            Looper.loop();
        }
    }
}
