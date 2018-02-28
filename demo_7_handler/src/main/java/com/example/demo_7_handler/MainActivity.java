package com.example.demo_7_handler;

import android.os.Handler;
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
        final MyHandler handler = new MyHandler(this);
        new Thread(){
            @Override
            public void run() {
                super.run();
                SystemClock.sleep(20000);
                handler.sendEmptyMessage(0);
            }
        }.start();
    }

    private static class MyHandler extends Handler{
        private WeakReference<MainActivity> mActivity;

        public  MyHandler(MainActivity activity){
            mActivity = new WeakReference<MainActivity>(activity);
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
}
