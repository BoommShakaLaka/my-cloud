package com.cloud.basic.general;

import com.cloud.pojo.User;

public class GeneralDemo {
    public static void main(String[] args) {
        generalMethod("aaa",2,new User());
    }

    private static<T> void generalMethod(T ... inputArray) {
        for (T element:inputArray){
            if (element instanceof Integer){
                System.out.println("处理Integer类形数据。。。");
            } else if (element instanceof String) {
                System.out.println("处理String类形数据。。。");
            } else if (element instanceof  Double) {
                System.out.println("处理String类形数据。。。");
            } else if (element instanceof User) {
                System.out.println("处理User类形数据。。。");
            }
        }
    }
}
