package com.example.demo_7_memoryleaked;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.squareup.leakcanary.RefWatcher;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LeakThread leakThread = new LeakThread();
        leakThread.start();
    }
    class LeakThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(6 * 60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = LeakApplication.getRefWatcher(this);//1
        refWatcher.watch(this);
    }
}
