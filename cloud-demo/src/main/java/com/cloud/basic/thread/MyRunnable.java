package com.cloud.basic.thread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " MyRunnable is running...");
    }
}
