package com.example.demo_76_countdowntimer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "countdowntimer";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView mTextField = findViewById(R.id.text);
        CountDownTimer countDownTimer = new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                Log.d(TAG, Thread.currentThread() + " millisUntilFinished: " + millisUntilFinished);
                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                Log.d(TAG, "onFinish() ");
                mTextField.setText("done!");
            }
        };
        countDownTimer.start();
        countDownTimer.start();
    }
}


