package com.example.demo_69_service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "demo69_activity2";
    private MyService myService;
    private boolean isBound = false;

    private ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected", new RuntimeException());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "onServiceConnected 5s later");
            isBound = true;
            MyService.MyBinder binder = (MyService.MyBinder) service;
            myService = binder.getService();
        }

        //client 和service连接意外丢失时，会调用该方法
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected", new RuntimeException());
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "oncreate:");
        setContentView(R.layout.activity_main2);
        final Intent serviceIntent = new Intent("android.intent.action.csdnservice");
        serviceIntent.setPackage("com.example.demo_69_service");
        Button btnForStartService = findViewById(R.id.buttonStart);
        btnForStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startForegroundService(serviceIntent);
            }
        });
        Button btnForBindService = findViewById(R.id.buttonBind);
        btnForBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(serviceIntent, conn, BIND_AUTO_CREATE);
                Log.d(TAG, "bindService success :");
            }
        });
        Button btnForStartMore = findViewById(R.id.buttonStartMore);
        btnForStartMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i< 5; i++) {
                    Log.d(TAG, "btnForStartMore :" + i);
                    startService(serviceIntent);
                }
            }
        });
        Button btnSomeWork = findViewById(R.id.buttonDoWork);
        btnSomeWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myService != null){
                    myService.doSomeWork();
                }
            }
        });

    }


}
