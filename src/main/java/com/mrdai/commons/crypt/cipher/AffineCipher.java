package com.mrdai.crypt.cipher;

import com.mrdai.crypt.Cipher;
import com.mrdai.commons.math.MathUtils;

import java.util.function.IntUnaryOperator;

public class AffineCipher implements Cipher {

    private final int a;
    private final int b;
    private final int inverseA;

    public AffineCipher(int a, int b) {
        if (MathUtils.gcd(a, 26) != 1)
            throw new IllegalArgumentException("The given a `" + a + "` is not coprime with 26.");

        this.a = a;
        this.b = b >= 26 ? b % 26 : b;
        this.inverseA = MathUtils.multiplicativeInverse(a, 26);
    }

    public char[] encrypt(char[] plainText) {
        char[] result = new char[plainText.length];
        for (int i = 0; i < plainText.length; i++)
            result[i] = map(plainText[i], this::mapInt);
        return result;
    }

    public char[] decrypt(char[] cipherText) {
        char[] result = new char[cipherText.length];
        for (int i = 0; i < cipherText.length; i++)
            result[i] = map(cipherText[i], this::inverseMapInt);
        return result;
    }

    private char map(char origin, IntUnaryOperator intMapper) {
        if (origin >= 97 && origin <= 122) { // Lower case letter
            int dist = (int) origin - 'a';
            dist = intMapper.applyAsInt(dist);
            return (char) ('a' + dist);
        } else if (origin >= 65 && origin <= 90) { // Upper case letter
            int dist = (int) origin - 'A';
            dist = intMapper.applyAsInt(dist);
            return (char) ('A' + dist);
        } else {
            return origin;
        }
    }

    private int mapInt(int origin) {
        return (origin * a + b) % 26;
    }

    private int inverseMapInt(int origin) {
        int i = origin - b;
        while (i < 0)
            i += 26;
        return inverseA * i % 26;
    }

}
