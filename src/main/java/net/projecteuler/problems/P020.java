package net.projecteuler.problems;

import java.math.BigInteger;

import static net.projecteuler.problems.P015.factorial;
import static net.projecteuler.problems.P016.getSumOfDigits;

public class P020 {

    private static final int QUESTION_NUMBER = 100;

    public static void main(String[] args) {
        BigInteger numberAfterFactorial = factorial(QUESTION_NUMBER);
        long solution = getSumOfDigits(numberAfterFactorial.toString());
        System.out.println(solution);
    }
}
