package com.example.demo_33_broadcast_parallel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BroadcastTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_test);
        Intent intent = new Intent("com.jiatai.broadcast.ordered");
        //intent.setPackage("com.example.demo_33_broadcast_parallel");
        sendOrderedBroadcast(intent, null);
    }
}
