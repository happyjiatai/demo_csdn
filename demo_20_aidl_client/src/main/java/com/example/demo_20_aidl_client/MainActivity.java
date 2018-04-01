package com.example.demo_20_aidl_client;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo_20_aidl_server.IMyAidlInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "aidlTest";
    Button btnBindService;
    Button btnAdd;
    TextView txResult;
    private IMyAidlInterface myAidlInterface;
    private boolean flag = false;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            Log.d(TAG, "onServiceConnected " + myAidlInterface);
            try {
                throw new RuntimeException("jiatai");
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myAidlInterface = null;
            Log.d(TAG, "onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBindService = findViewById(R.id.button);
        btnAdd = findViewById(R.id.button2);
        txResult = findViewById(R.id.textView);
        btnBindService.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if (!flag) {
                    bindMyService();
                    Toast.makeText(this, "bind service", Toast.LENGTH_SHORT).show();
                    flag = true;
                    btnBindService.setText("unbind");
                }else{
                    unbindMyService();
                    Toast.makeText(this, "unbind service", Toast.LENGTH_SHORT).show();
                    flag = false;
                    btnBindService.setText("bind");
                    txResult.setText("the service has unbind");
                }
                break;
            case R.id.button2:
                try {
                    if (myAidlInterface != null) {
                        txResult.setText("the result is :" + myAidlInterface.add(1, 4));
                    }else {
                        txResult.setText("the service has unbind");
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }



    private void bindMyService() {
        Intent intent = new Intent();
        intent.setPackage("com.example.demo_20_aidl_server");
        intent.setAction("aidl.test.action");
        bindService(intent, connection, BIND_AUTO_CREATE);
    }

    private void unbindMyService() {
        myAidlInterface = null;
        unbindService(connection);
    }
}
