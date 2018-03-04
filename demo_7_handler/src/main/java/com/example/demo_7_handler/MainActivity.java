package com.example.demo_7_handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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
            super("zjtThread");
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void run() {
            MainActivity mainActivity = mActivity.get();
            if (mainActivity == null) {
               return;
            }
            super.run();
            for(int i = 0 ; i < 500 ; i ++){
                Log.d("zjt", "i = " + i);
                if(mainActivity == null){
                    Log.d("zjt", "the weakreference is null");
                    return;
                }else {
                    Log.d("zjt", "the mainActivity is" + mainActivity);
                }
                SystemClock.sleep(2000);
            }

            /*Looper.prepare();
            MyHandler handler = new MyHandler(mainActivity);
            handler.sendEmptyMessage(0);
            Looper.loop();*/
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("zjt", "onDestory");
        System.gc();
    }
}
