package com.cloud.encryption;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESDemo {

    public static void main(String[] args) throws Exception {

        String plainText = "Hello World!"; // 待加密的明文
        String keyString = "MySecretKey12345"; // 密钥（16位）

        Key aesKey = new SecretKeySpec(keyString.getBytes(), "AES"); // 构造密钥
        Cipher cipher = Cipher.getInstance("AES"); // 创建密码学对象

        // 加密
        cipher.init(Cipher.ENCRYPT_MODE, aesKey); // 初始化为加密模式
        byte[] cipherText = cipher.doFinal(plainText.getBytes()); // 加密
        String encryptedText = Base64.getEncoder().encodeToString(cipherText); // Base64编码

        // 解密
        cipher.init(Cipher.DECRYPT_MODE, aesKey); // 初始化为解密模式
        byte[] decryptedText = cipher.doFinal(Base64.getDecoder().decode(encryptedText)); // Base64解码后解密
        String originalText = new String(decryptedText); // 明文文本

        // 输出
        System.out.println("明文： " + plainText);
        System.out.println("加密后： " + encryptedText);
        System.out.println("解密后： " + originalText);
    }
}
