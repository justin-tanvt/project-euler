package net.projecteuler;

import java.math.BigInteger;

public class P025 {

    private static final int NUM_OF_DIGITS = 1000;

    public static void main(String[] args) {
        System.out.printf("final solution = %s", solve());
    }

    private static String solve() {
        return "" + indexOfFibonacciNumOfLength(NUM_OF_DIGITS);
    }

    public static long indexOfFibonacciNumOfLength(int length) {
        long index = 2;
        BigInteger num1 = BigInteger.ONE;
        BigInteger num2 = BigInteger.ONE;
        BigInteger helper;

        while (true) {
            index++;
            helper = num2;
            num2 = num2.add(num1);
            num1 = helper;

            if(num2.toString().length() == length) {
                return index;
            }
        }
    }

}
