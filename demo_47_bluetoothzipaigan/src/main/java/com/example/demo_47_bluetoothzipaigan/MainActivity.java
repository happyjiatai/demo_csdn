package com.example.demo_47_bluetoothzipaigan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "bluetoothzipaigan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        btn.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.d(TAG, "Button OnKeyListener : "+ keyCode);
                if (KeyEvent.KEYCODE_VOLUME_UP == keyCode) {
                   return true;
                }
                return false;
            }
        });
        //btn.setFocusable(true);

        EditText editText= findViewById(R.id.editText);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.d(TAG, "editText OnKeyListener : "+ keyCode);
                if (KeyEvent.KEYCODE_VOLUME_UP == keyCode) {
                    return true;
                }
                return false;
            }
        });
        editText.setFocusable(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(TAG, "onKeyDown : "+ keyCode);
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                Log.d(TAG, "KeyEvent.KEYCODE_VOLUME_UP");
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Log.d(TAG, "KeyEvent.KEYCODE_VOLUME_DOWN");
                return true;
            default:
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //Log.d(TAG, "onKeyUp", new RuntimeException());
        Log.d(TAG, "onKeyUp : "+ keyCode);
        return super.onKeyUp(keyCode, event);
    }
}
