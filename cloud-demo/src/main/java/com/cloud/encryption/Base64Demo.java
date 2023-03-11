package com.cloud.encryption;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Demo {

    public static void main(String[] args) {
        String plainText = "Hello World!";
        String encodedText = Base64.getEncoder().encodeToString(plainText.getBytes(StandardCharsets.UTF_8));
        byte[] decodedBytes = Base64.getDecoder().decode(encodedText);
        String decodedText = new String(decodedBytes, StandardCharsets.UTF_8);

        System.out.println("原始字符串: " + plainText);
        System.out.println("Base64编码后的字符串: " + encodedText);
        System.out.println("Base64解码后的字符串: " + decodedText);
    }
}

