package com.example.demo_25_coldandhot_start;

import android.app.Application;
import android.util.Log;

public class ColdAndHotApplication extends Application {
    private static String TAG = "ColdAndHotApplication";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "ColdAndHotApplication onCreate");
    }
}
