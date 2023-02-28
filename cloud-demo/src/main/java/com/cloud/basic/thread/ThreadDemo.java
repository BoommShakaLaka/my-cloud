package com.cloud.basic.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("main thread " + Thread.currentThread().getName());

        // 继承thread
        MyThread myThread = new MyThread();
        myThread.start();

        // 实现runnable接口
        new Thread(new MyRunnable()).start();

        // 实现callable接口+ExecutorService
        //step 2:创建一个固定大小为 5 的线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //step 3: 创建多个有返回值的任务列表 list
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < 5; i++) {
            // step 4: 创建一个有返回值的线程实例
            Callable c = new MyCallable(i + "");
            // step 5:提交线程，获取 Future 对象并将其保存到 Future List 中
            Future future = pool.submit(c);
            System.out.println(" submit a callable thread : " + i);
            list.add(future);
        }
        // step 6:关闭线程池，等待线程执行结束
        pool.shutdown();
        // step 7 :遍历所有线程的运行结果
        for(Future future:list){
            //从 Future 对象上获取任务的返回值，并将结果输出到控制台
            System.out.println("get the result from callable thread:"+future.get().toString());
        }

    }
}
