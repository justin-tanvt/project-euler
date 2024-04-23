package net.projecteuler.problems;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import static net.projecteuler.problems.P021.calculateSumOfProperDivisors;

public class P023 {

    public static void main(String[] args) {
        System.out.printf("final solution = %s", solve());
    }

    private static String solve() {
        // - given that all integers greater than 28123 are the sum of 2 abundant numbers, thus all positive integers
        //   which are not the sum of 2 abundant numbers must be within the interval 1, 28123
        // - the greatest abundant number that can result in a sum of 28123 is 28122 (i.e. 28123 = 1 + 28122), thus
        //   consider only abundant numbers within the interval 1, 28122
        Set<Long> abundantNumbers = findAbundantNumbersInRange(1, 28122);

        BigInteger solution = BigInteger.ZERO;
        for (long positiveInteger = 1; positiveInteger <= 28123; positiveInteger++) {
            if (!isTwoSum(positiveInteger, abundantNumbers)) {
                solution = solution.add(BigInteger.valueOf(positiveInteger));
            }
        }
        return "" + solution;
    }

    private static Set<Long> findAbundantNumbersInRange(long lowerLimitInclusive, long upperLimitInclusive) {
        Set<Long> abundantNumbers = new HashSet<>();
        for (long i = lowerLimitInclusive; i <= upperLimitInclusive; i++) {
            long sumOfProperDivisors = calculateSumOfProperDivisors(i);
            if (sumOfProperDivisors > i) {
                abundantNumbers.add(i);
            }
        }
        return abundantNumbers;
    }

    public static boolean isTwoSum(long number, Set<Long> numbers) {
        // number = a + b; where a > b
        for (long a = number - 1, b = number - a; a >= b; a--, b++) {
            if (numbers.contains(a) && numbers.contains(b)) {
                return true;
            }
        }
        return false;
    }
}
