package net.projecteuler.problems;

import java.util.*;

public class P021 {

    private static final long QUESTION_UPPER_LIMIT_EXCLUSIVE = 10000;
    private static final Map<Long, Long> FUNCTION_OUTPUT_CACHE = new HashMap<>();

    public static void main(String[] args) {
        System.out.printf("final solution = %s\n", solve());
    }

    private static String solve() {
        // sanity checks
        assert calculateSumOfProperDivisors(220) == 284;
        assert calculateSumOfProperDivisors(284) == 220;

        // working
        long solution = 0;
        Set<Long> amicableNumbersFound = new HashSet<>();
        for (long number = 1; number < QUESTION_UPPER_LIMIT_EXCLUSIVE; number++) {
            if (amicableNumbersFound.contains(number)) {
                continue;
            }

            long currentSum = findSumOfProperDivisors(number);
            long nextSum = findSumOfProperDivisors(currentSum);

            if (number == nextSum && number != currentSum) {
                System.out.printf("amicable pair %s <--> %s\n", number, currentSum);
                amicableNumbersFound.add(number);
                amicableNumbersFound.add(currentSum);
                solution += number;
                solution += currentSum;
            }
        }

        return "" + solution;
    }

    public static List<Long> findAllIntegerFactorsInOrder(long number) {
        Set<Long> factors = new HashSet<>();
        for (long i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                factors.add(i);
                factors.add(number / i);
            }
        }

        List<Long> sortedFactors = new ArrayList<>(factors);
        Collections.sort(sortedFactors);
        return sortedFactors;
    }

    public static List<Long> findProperDivisors(long number) {
        List<Long> allIntegerFactorsInOrder = findAllIntegerFactorsInOrder(number);
        allIntegerFactorsInOrder.remove(number);
        return allIntegerFactorsInOrder;
    }

    public static long calculateSumOfProperDivisors(long number) {
        List<Long> properDivisors = findProperDivisors(number);
        return properDivisors.stream().mapToLong(Long::longValue).sum();
    }

    private static long findSumOfProperDivisors(long number) {
        FUNCTION_OUTPUT_CACHE.computeIfAbsent(number, P021::calculateSumOfProperDivisors);
        return FUNCTION_OUTPUT_CACHE.get(number);
    }
}
