package com.example.demo_15_rxjava_names;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "jiatai";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] names ={"hello", "world", "happy", "every", "day"};
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                Log.d(TAG, "ObservableOnSubscribe subscribe" + Thread.currentThread());
                for(String s : names){
                    emitter.onNext(s);
                }
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.newThread())
        .observeOn(Schedulers.newThread())
        .subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "Observer onSubscribe" + Thread.currentThread());
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "Observer  onNext :" + s + "-----" +Thread.currentThread());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Observer onSubscribe");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Observer onComplete" + "-----" +Thread.currentThread());
            }
        });

        /*Observable.fromArray(names)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "onNext :" + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onSubscribe");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });*/
    }
}
