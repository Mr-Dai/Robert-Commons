package com.mrdai.commons.math;

import com.mrdai.commons.struct.Pair;

import java.util.ArrayList;
import java.util.List;

public abstract class MathUtils {

    public static int gcd(int a, int b) {
        if (b > a)
            return gcd(b, a);
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static int multiplicativeInverse(int a, int n) {
        if (gcd(a, n) != 1)
            return -1;
        int result = linearCombGcd(a, n)._1;
        while (result < 0)
            result += n;
        return result % n;
    }

    static Pair<Integer, Integer> linearCombGcd(int a, int b) {
        List<Integer> as = new ArrayList<>();
        List<Integer> qs = new ArrayList<>();

        as.add(a);
        as.add(b);
        qs.add(0);

        int n = 1;
        while (b != 0) {
            int x = a / b;
            int y = a % b;
            as.add(y);
            qs.add(x);

            a = b;
            b = y;
            n++;
        }

        int u = 1;
        int v = -1 * qs.get(n - 2);
        for (; n > 3; n--) {
            int x = v;
            int y = u - v * qs.get(n - 3);
            u = x;
            v = y;
        }

        return Pair.of(u, v);
    }

}
