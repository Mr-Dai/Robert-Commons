package com.mrdai.crypt.opmode;

import com.mrdai.crypt.Cipher;

public class ElectronicCodebookMode implements Cipher {

    private final Cipher cipher;

    public ElectronicCodebookMode(Cipher cipher) {
        this.cipher = cipher;
    }

    @Override
    public char[] encrypt(char[] plainText) {
        return cipher.encrypt(plainText);
    }

    @Override
    public char[] decrypt(char[] cipherText) {
        return cipher.decrypt(cipherText);
    }

}
