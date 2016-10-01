package com.mrdai.commons.math;

import com.mrdai.commons.struct.Pair;
import org.junit.Test;

import static com.mrdai.commons.math.MathUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MathUtilsTest {

    @Test
    public void testGcd() {
        assertThat(gcd(66, 35), is(1));
        assertThat(gcd(29, 1137), is(1));
    }

    @Test
    public void testLcm() {
        assertThat(lcm(24, 15), is(120));
    }

    @Test
    public void testLinearCombGcd() {
        assertThat(linearCombGcd(66, 35), is(Pair.of(-9, 17)));
        assertThat(linearCombGcd(29, 1137), is(Pair.of(-196, 5)));
    }

    @Test
    public void testMultiplicativeInverse() {
        assertThat(multiplicativeInverse(35, 66), is(17));
        assertThat(multiplicativeInverse(29, 1137), is(941));
    }

}
