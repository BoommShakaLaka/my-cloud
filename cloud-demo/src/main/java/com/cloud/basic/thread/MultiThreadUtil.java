package com.cloud.basic.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MultiThreadUtil {

    /**
     * 多线程处理数据并返回结果
     *
     * @param inputList 输入数据列表
     * @param function  处理函数（可以是任意逻辑）
     * @param threadNum 线程数
     * @param <T>       输入数据类型
     * @param <R>       返回数据类型
     * @return 处理后的结果列表
     */
    public static <T, R> List<R> multiThreadProcess(List<T> inputList, Function<T, R> function, int threadNum) {

        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);

        try {
            // 使用 CompletableFuture 异步执行任务
            List<CompletableFuture<R>> futures = inputList.stream().map(input -> CompletableFuture.supplyAsync(() -> function.apply(input), executor)).collect(Collectors.toList());

            // 等待所有任务完成，并收集结果
            return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
        } finally {
            // 关闭线程池
            executor.shutdown();
        }
    }

    public static void main(String[] args) {
        // 示例：多线程计算数字的平方
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 使用多线程工具处理
        List<Integer> squares = multiThreadProcess(numbers, num -> num * num,  // 计算平方的函数
                4);  // 使用4个线程

        System.out.println("Input: " + numbers);
        System.out.println("Result: " + squares);
    }
}