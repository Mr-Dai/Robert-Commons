package com.mrdai.crypt.cipher;

import com.mrdai.crypt.BlockCipher;

public class AffineBlockCipher extends AffineCipher implements BlockCipher {

    private final int blockSize;

    public AffineBlockCipher(int a, int b, int blockSize) {
        super(a, b);
        this.blockSize = blockSize;
    }

    @Override
    public int getBlockSize() {
        return blockSize;
    }
}
