package net.projecteuler.problems;

import java.util.HashSet;
import java.util.Set;

public class P030 {

    // given expression is NUMBER = (DIGIT 1)^EXPONENT + (DIGIT 2)^EXPONENT + ...
    // a "solution" refers to a NUMBER that satisfies the given expression
    // the "final solution" refers to the sum of all possible solutions
    // this problem will be modeled using LHS (number) and RHS (sum of powered digits)

    private static final int EXPONENT = 5;

    // 1-digit numbers not included as their digits cannot be summed
    private static final int NUMBER_MINIMUM_INCLUSIVE = 10;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.printf("\nfinal solution = %s\n", solve());
        long endTime = System.nanoTime();
        System.out.printf("\nsolution execution time = %s ms\n", (endTime - startTime) / 1000000);
    }

    private static String solve() {
        int maxDigits = maxDigitsForValidSolution();
        Set<Integer> solutions = new HashSet<>();

        int number = NUMBER_MINIMUM_INCLUSIVE;
        while (Integer.toString(number).length() <= maxDigits) {
            if (satisfiesExpression(number)) {
                solutions.add(number);
            }
            number++;
        }

        return Integer.toString(solutions.stream().mapToInt(i -> i).sum());
    }

    private static boolean satisfiesExpression(int number) {
        int sum = 0;

        String numStr = Integer.toString(number);
        for (int i = 0; i < numStr.length(); i++) {
            int digit = Character.digit(numStr.charAt(i), 10);
            sum += (int) Math.pow(digit, EXPONENT);
        }

        if (sum == number) {
            System.out.printf("%s satisfies the expression\n", number);
            return true;
        } else {
            return false;
        }
    }

    private static int maxDigitsForValidSolution() {
        // for a given number of digits, there is a range of values for the LHS and RHS of the expression
        // for 2 digits, the LHS has range [10, 99] while the RHS is [1*2, 9^EXPONENT*2]
        // for 3 digits, the LHS' range is [100, 999] while the RHS is [1*3, 9^EXPONENT*2], and so on...

        // a solution can only be found when both ranges intersect (i.e. the LHS COULD equal to the RHS)
        // as digits are increased, it is observed that LHS' range increases faster than RHS' range
        // therefore, there is a maximum number of digits beyond which the LHS can no longer equal to the RHS
        // this is the number of digits before the LHS' minimum value exceeds the RHS' maximum value

        int numOfDigits = 1;
        int LHSmin;
        int RHSmax;

        while (true) {
            LHSmin = (int) Math.pow(10, numOfDigits - 1);
            RHSmax = (int) Math.pow(9, EXPONENT) * numOfDigits;

            if (LHSmin > RHSmax) {
                // LHS range has exceeded RHS range (i.e. there is no possible solution for current number of digits)
                // maximum number of digits for a valid solution is 1 less than current
                return numOfDigits - 1;
            }

            numOfDigits++;
        }
    }
}
