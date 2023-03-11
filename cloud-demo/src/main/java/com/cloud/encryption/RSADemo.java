package com.cloud.encryption;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;

import javax.crypto.Cipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class RSADemo {

    private static final int KEY_SIZE = 2048; // RSA密钥长度

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider()); // 添加BouncyCastleProvider，用于生成RSA密钥对

        // 生成RSA密钥对
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "BC");
        keyPairGenerator.initialize(KEY_SIZE);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // 加密
        String plainText = "Hello World!";
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherText = cipher.doFinal(plainText.getBytes());

        System.out.println("加密前的明文: " + plainText);
        System.out.println("加密后的密文: " + new String(cipherText));

        // 解密
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedText = cipher.doFinal(cipherText);

        System.out.println("解密后的明文: " + new String(decryptedText));
    }
}

