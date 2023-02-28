package com.cloud.basic.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//step 1: 通过实现 Callable 接口创建 MyCallable 线程
public class MyCallable implements Callable<String> {
    private String name;

    public MyCallable(String name) { //通过构造函数为线程传递参数，以定义线程的名称
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        return name;
    }


}
