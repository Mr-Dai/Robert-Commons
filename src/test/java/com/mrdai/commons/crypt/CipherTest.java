package com.mrdai.crypt;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Parameterized.class)
public abstract class CipherTest {

    @Parameter() public String plainText;
    @Parameter(value = 1) public String cipherText;

    protected Cipher cipher;

    @Before
    public abstract void setUpCipher();

    @After
    public void tearDownCipher() {}

    @Test
    public void testEncryptString() {
        assertThat(cipher.encrypt(plainText), is(cipherText));
    }

    @Test
    public void testEncryptChars() {
        assertThat(cipher.encrypt(plainText.toCharArray()), is(cipherText.toCharArray()));
    }

    @Test
    public void testDecryptString() {
        assertThat(cipher.decrypt(cipherText), is(plainText));
    }

    @Test
    public void testDecryptChars() {
        assertThat(cipher.decrypt(cipherText.toCharArray()), is(plainText.toCharArray()));
    }

}
