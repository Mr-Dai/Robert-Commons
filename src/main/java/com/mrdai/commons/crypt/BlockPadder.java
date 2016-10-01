package com.mrdai.crypt;

@FunctionalInterface
public interface BlockPadder {
    char[] pad(char[] origin, int targetBlockSize);
}
