package com.mrdai.crypt;

public interface Digestor {

    default String digest(String plain) {
        return new String(digest(plain.toCharArray()));
    }

    char[] digest(char[] plain);

}
