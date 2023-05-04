package com.cloud.basic.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @program: Basic
 * author: zf
 * 2021-05-12 15:20
 * @description: 按照顺序执行线程
 */
public class ThreadRunBySort {
    public static void main(String[] args) throws InterruptedException {
        //方法一 用join实现
        Thread t1 = new Thread(() -> {
            System.out.println("t1");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("t2");
        });
        Thread t3 = new Thread(() -> {
            System.out.println("t3");
        });
        t1.start(); // 启动线程T1
        t1.join(); // 等待线程T1执行完毕
        t2.start(); // 启动线程T2
        t2.join(); // 等待线程T2执行完毕
        t3.start(); // 启动线程T3
        t3.join(); // 等待线程T3执行完毕


        //方法二 CountDownLatch类：可以通过CountDownLatch类的await()和countDown()方法，实现多个线程按照指定的顺序执行。
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        Thread tt1 = new Thread(() -> {
            System.out.println("tt1");
            countDownLatch1.countDown();
        });
        Thread tt2 = new Thread(() -> {
            try {
                countDownLatch1.await();
                System.out.println("tt2");
                countDownLatch2.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        Thread tt3 = new Thread(() -> {
            try {
                countDownLatch2.await();
                System.out.println("tt3");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        tt1.start();
        tt2.start();
        tt3.start();

//        方法3
//        Semaphore信号量：可以通过Semaphore类的acquire()和release()方法，实现多个线程按照指定的顺序执行。
//        举个例子：假设有3个线程T1、T2、T3，需要T1先执行完，T2再执行，最后T3执行。代码如下：
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(0);
        Semaphore semaphore3 = new Semaphore(0);

        Thread ttt1 = new Thread(() -> {
            System.out.println("ttt1");
            semaphore1.release(); // 释放信号量1，让线程T2执行
        });
        Thread ttt2 = new Thread(() -> {
            try {
                semaphore1.acquire(); // 等待信号量1
                System.out.println("ttt2");
                semaphore2.release(); // 释放信号量2，让线程T3执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread ttt3 = new Thread(() -> {
            try {
                semaphore2.acquire(); // 等待信号量2
                System.out.println("ttt3");
                semaphore3.release(); // 释放信号量3
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        ttt1.start(); // 启动线程T1
        ttt2.start(); // 启动线程T2
        ttt3.start(); // 启动线程T3
//        通过Semaphore信号量的方式，也可以实现多个线程按照指定顺序执行的目的。
    }
}
