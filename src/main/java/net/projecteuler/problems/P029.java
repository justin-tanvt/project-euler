package net.projecteuler.problems;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class P029 {
    private static final int A_MIN_INCLUSIVE = 2;
    private static final int A_MAX_INCLUSIVE = 100;
    private static final int B_MIN_INCLUSIVE = 2;
    private static final int B_MAX_INCLUSIVE = 100;

    public static void main(String[] args) {
        System.out.printf("final solution = %s\n", solve());
    }

    private static String solve() {
        Set<BigInteger> distinctTerms = new HashSet<>();

        for (int a = A_MIN_INCLUSIVE; a <= A_MAX_INCLUSIVE; a++) {
            for (int b = B_MIN_INCLUSIVE; b <= B_MAX_INCLUSIVE; b++) {
                BigInteger result = BigInteger.valueOf(a).pow(b);
                distinctTerms.add(result);
            }
        }

        return String.valueOf(distinctTerms.size());
    }
}