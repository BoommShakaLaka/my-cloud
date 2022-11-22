package com.cloud.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * 创建流的方式
 */
public class StreamOperateDemo {
    public static void main(String[] args) {
        //1、数组
        String[] arr = {"react", "", "react", "spring", "webflux", "redis", "bo_le", "spring", "microsevice", "bo_le"};
        Arrays.stream(arr).forEach(System.out::println);
        //2、list
        Arrays.asList(arr).stream().forEach(System.out::println);
        //3、stream.of
        Stream.of(arr).forEach(System.out::println);
        //4、迭代器打印1-10元素
        Stream.iterate(1, i -> i + 1).limit(10).forEach(System.out::println);
        //5、打印10以内的随机数
        Stream.generate(() -> new Random().nextInt(10)).limit(10).forEach(System.out::println);


        //流式操作 依次输出b,e,l,o
        Stream.of(arr).filter(i -> !i.isEmpty())
                .distinct()
                .sorted()
                .limit(1)
                .map(i -> i.replace("_", ""))
                .flatMap(i -> Stream.of(i.split("")))
                .sorted()
//                .findFirst()  //流编程中，终止操作只能有一个，中间操作可以有0-n个
//                .peek(i-> System.out.println(i)); //流编程中，必须有一个终止操作
                .forEach(System.out::println);
    }
}
