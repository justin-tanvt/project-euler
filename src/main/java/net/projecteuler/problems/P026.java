package net.projecteuler.problems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class P026 {
    private static final int MAX_DENOMINATOR_EXCLUSIVE = 1000;

    public static void main(String[] args) {
        System.out.printf("final solution = %s\n", solve());
    }

    private static String solve() {
        int solution = -1;
        int greatestReptendLength = -1;
        for (int i = 1; i < MAX_DENOMINATOR_EXCLUSIVE; i++) {
            if (!isRecurring(i)) {
                continue;
            }

            int reptendLength = findUnitFractionRepetendLength(i);
            System.out.printf("%s has reptend length %s\n", i, reptendLength);
            if (reptendLength > greatestReptendLength) {
                greatestReptendLength = reptendLength;
                solution = i;
            }
        }

        return String.valueOf(solution);
    }

    private static boolean isRecurring(int denominator) {
        try {
            BigDecimal.ONE.divide(BigDecimal.valueOf(denominator));
        } catch (ArithmeticException x) {
            return true;
        }
        return false;
    }

    private static int findUnitFractionRepetendLength(long denominator) {
        List<Long> remainders = new ArrayList<>();

        long numerator = 1;
        long remainder;
        while (true) {
            remainder = numerator % denominator;

            if (remainder < 0) {
                throw new IllegalStateException("Remainder cannot be negative!");
            }

            if (!remainders.contains(remainder)) {
                remainders.add(remainder);
                numerator = remainders.get(remainders.size() - 1) * 10;
                continue;
            }

            int indexOfRemainderPreviouslyFound = remainders.indexOf(remainder);
            return remainders.size() - indexOfRemainderPreviouslyFound;
        }
    }
}
