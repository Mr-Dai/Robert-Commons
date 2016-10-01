package com.mrdai.crypt.cipher;

import com.mrdai.crypt.CipherTest;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;


public class AffineCipherTest extends CipherTest {

    @Parameter(value = 2) public int a;
    @Parameter(value = 3) public int b;

    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
            {"lecture", "inhgjan", 3, 1}, {"RENAISSANCE", "UHQDLVVDQFH", 1, 3},
            {"HaHaWaWa...===AAACCsde", "NcNcScSc...===CCCUUidm", 9, 2},
            {"HaHaWaWa...===AAACCsde", "KjKjBjBj...===JJJNNtcr", 15, 9}
        });
    }

    @Override
    public void setUpCipher() {
        cipher = new AffineCipher(a, b);
    }

}
