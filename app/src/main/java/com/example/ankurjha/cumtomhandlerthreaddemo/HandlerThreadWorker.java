package com.example.ankurjha.cumtomhandlerthreaddemo;

import android.os.Handler;
import android.os.HandlerThread;

public class HandlerThreadWorker extends HandlerThread {

    private static final String TAG = "HandlerThreadWorker";

    Handler handler;


    public HandlerThreadWorker() {
        super(TAG);
        start();
        handler = new Handler(getLooper());
    }

    public HandlerThreadWorker addTask(Runnable task){
        handler.post(task);
        return this;
    }

}
