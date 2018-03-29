package com.example.utils;

import android.util.Log;

public class StaticModle {
    public static int num = 0;
    private static String TAG = "staticTest";
    static{
        Log.d(TAG, "the static field of staticModle has already be loaded: " + num);
    }

    public static class InnerClass{
        public static int staticNumOfInnerClass = 0;
        static{
            Log.d(TAG, "the static field of InnerClass has already be loaded: " + num);
        }
        public int numOfInnerClass = 0;
    }
}
