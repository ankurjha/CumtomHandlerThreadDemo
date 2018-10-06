package com.example.ankurjha.cumtomhandlerthreaddemo;

import android.util.Log;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleWorkerThread extends Thread {

    private static final String TAG = "SimpleWorkerThread";

    private AtomicBoolean alive = new AtomicBoolean(true);
    private ConcurrentLinkedQueue<Runnable> taskQueue = new ConcurrentLinkedQueue<>(); // concurrent so that multiple thread can invoke it

    public SimpleWorkerThread(){
        super(TAG);
        start();
    }

    @Override
    public void run() {
        while(alive.get()){
            Runnable task = taskQueue.poll();
            if(task != null){
                task.run();
            }
        }

        Log.i(TAG,"SimpleWorkerThread Terminated.");
    }

    public SimpleWorkerThread addTask(Runnable task){
        taskQueue.add(task);
        return this; // for builder pattern
    }

    public void quit(){
        alive.set(false);
    }
}
