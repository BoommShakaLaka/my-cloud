package com.cloud.encryption;

import java.security.MessageDigest;

public class MD5Demo {

    public static void main(String[] args) throws Exception {
        String plainText = "Hello World!";
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] hash = messageDigest.digest(plainText.getBytes());

        // 将哈希值转换为十六进制字符串
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        System.out.println("MD5哈希值: " + hexString.toString());
    }
}

