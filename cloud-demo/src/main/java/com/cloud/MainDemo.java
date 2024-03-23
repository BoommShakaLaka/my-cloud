package com.cloud;

import io.swagger.models.auth.In;

import java.util.*;

public class MainDemo {
    public static void main(String[] args) {
        System.out.println(maxVowels("weallloveyou", 7));
    }

    public static int maxVowels(String s, int k) {
        HashMap<Character, Character> map = new HashMap<Character, Character>() {
            {
                put('a', 'a');
                put('e', 'e');
                put('i', 'i');
                put('o', 'o');
                put('u', 'u');

            }
        };
        char[] chars = s.toCharArray();

        int maxSum = 0;
        int tmpSum = 0;
        for (int i = 0; i < k; i++) {
            if (map.get(chars[i]) != null) {
                tmpSum++;
            }
        }
        maxSum = Math.max(tmpSum, maxSum);
        for (int i = 1, j = k; j < chars.length; i++, j++) {
            if (map.get(chars[i-1]) != null) {
                tmpSum--;
            }
            if (map.get(chars[j]) != null) {
                tmpSum++;
            }
            maxSum = Math.max(tmpSum, maxSum);
        }
        return maxSum;
    }

}
