package com.cloud.basic.thread;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " myThread is running...");
    }
}
