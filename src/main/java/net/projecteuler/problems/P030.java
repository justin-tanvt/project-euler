package net.projecteuler.problems;

import java.util.HashSet;
import java.util.Set;

public class P030 {

    // given expression is NUMBER = (DIGIT 1)^EXPONENT + (DIGIT 2)^EXPONENT + ...
    // a "solution" refers to a NUMBER that satisfies the given expression
    // the "final solution" refers to the sum of all possible solutions
    // this problem will be modeled using LHS (number) and RHS (sum of powered digits)

    private static final int EXPONENT = 5;

    public static void main(String[] args) {
        System.out.printf("final solution = %s\n", solve());
    }

    private static String solve() {
        int maxDigits = maxDigitsForValidSolution();
        Set<Integer> solutions = new HashSet<>();

        int number = 10;        // start at minimum 2 digit number

        return "";
    }

    private static int maxDigitsForValidSolution() {
        // for a given number of digits, there is a range of values for the LHS and RHS of the expression
        // i.e. for 2 digits, the LHS has range [10, 99] while the RHS is [1^EXPONENT*2, 9^EXPONENT*2]

        // a solution can only be found when both ranges intersect (i.e. the LHS COULD equal to the RHS)
        // as digits are increased, it is observed that LHS' range increases faster than RHS' range
        // therefore, there is a maximum number of digits beyond which the LHS can no longer equal to the RHS
        // this is the number of digits before which the LHS' minimum value exceeds the RHS' maximum value

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
