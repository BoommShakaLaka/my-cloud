package com.cloud;

import io.swagger.models.auth.In;

import java.util.HashMap;

public class MainDemo {
    public static void main(String[] args) {

    }

    public boolean equalFrequency(String word) {
        char[] chars = word.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap();
        for (char c:chars){
          Integer value = hashMap.get(c);
            Integer integer = value == null ? hashMap.put(c, 1) : hashMap.put(c, (value + 1));
        }
        if (hashMap.size()>1){

        }

        return true;
    }
}
