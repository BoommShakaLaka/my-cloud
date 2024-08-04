package com.cloud.stream;

import java.util.Arrays;
import java.util.List;

public class SteamAnyMatchDemo {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        boolean result = numbers.stream().anyMatch(num -> num % 6 == 0);
        System.out.println(result);
    }


}
