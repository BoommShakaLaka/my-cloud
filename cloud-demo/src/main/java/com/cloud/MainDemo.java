package com.cloud;

import io.swagger.models.auth.In;

import java.util.HashMap;

public class MainDemo {
    public static void main(String[] args) {
        String word1 = "abcd";
        String word2 = "pq";
        System.out.println(mergeAlternately(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int i = 0, j = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < len1 || j < len2) {
            if (i<len1){
                stringBuilder.append(word1.charAt(i));
                i++;
            }
            if (j<len2){
                stringBuilder.append(word2.charAt(j));
                j++;
            }
        }
        return stringBuilder.toString();
    }
}
