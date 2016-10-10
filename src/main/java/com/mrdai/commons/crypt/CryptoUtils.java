package com.mrdai.commons.crypt;

import com.mrdai.commons.exception.ExceptionHelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class CryptoUtils {

    /**
     * Digests the given plain text with MD5 and returns the digested 32-bit
     * hexadecimal string.
     *
     * @param original the given plain text
     * @return the 32-bit hexadecimal string digested by MD5
     */
    public static String md5Digest(String original) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        }  catch (NoSuchAlgorithmException ex) {
            RuntimeException toThrow =
                    new IllegalStateException("The platform does not have an installed provider for MD5.", ex);
            ExceptionHelper.clearStackTrace(toThrow);
            throw toThrow;
        }
        md.update(original.getBytes());
        byte[] digest = md.digest();
        StringBuilder builder = new StringBuilder();
        for (byte b : digest) {
            builder.append(String.format("%02x", b & 0xff));
        }
        return builder.toString();
    }

}
