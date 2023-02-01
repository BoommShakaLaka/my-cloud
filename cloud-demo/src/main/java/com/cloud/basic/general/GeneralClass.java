package com.cloud.basic.general;

public class GeneralClass<T> {
    public static void main(String[] args) {
        //根据需求初始化不同的类型
        GeneralClass<Integer> genint = new GeneralClass<Integer>();
        genint.add(1);
        GeneralClass<String> genStr = new GeneralClass<String>();
        genStr.add("2");
    }

    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
