package com.mrdai.crypt;

public interface Cipher extends Digestor {

    char[] encrypt(char[] plainText);

    char[] decrypt(char[] cipherText);

    default String encrypt(String plainText) {
        return new String(encrypt(plainText.toCharArray()));
    }

    default String decrypt(String cipherText) {
        return new String(decrypt(cipherText.toCharArray()));
    }

    default String digest(String plainText) {
        return encrypt(plainText);
    }

    default char[] digest(char[] plainText) {
        return encrypt(plainText);
    }

}
