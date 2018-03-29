package com.example.demo_19_static;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.utils.StaticModle;

public class MainActivity2 extends AppCompatActivity {
    private static String TAG = "staticTest2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, TAG + " onCreate");
        final TextView tx = findViewById(R.id.textView);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tx.setText("the number is: " + ++StaticModle.InnerClass.staticNumOfInnerClass);
                Log.d(TAG, "the StaticModle.InnerClass.staticNumOfInnerClass num is: " + StaticModle.InnerClass.staticNumOfInnerClass);
            }
        });
        Button btn2 =  findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.demo_19_static","com.example.demo_19_static.MainActivity3");
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, TAG + " onDestroy");
    }
}
