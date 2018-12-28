package com.chinanx.crypto.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DESTool {
    private static String sKey = "1q2w3e4r~";

    private static SecretKey generateKey() throws Exception {
        SecretKeyFactory des = SecretKeyFactory.getInstance("DES");
        return des.generateSecret(new DESKeySpec(sKey.getBytes()));
    }

    public static String encrypt(String text) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        SecretKey secretKey = generateKey();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return new String(Base64.getEncoder().encode(cipher.doFinal(text.getBytes())));
    }

    public static String decrypt(String text) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        SecretKey secretKey = generateKey();
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(text.getBytes())));
    }
    
}
