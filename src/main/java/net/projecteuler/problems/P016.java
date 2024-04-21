package net.projecteuler.problems;

import java.math.BigInteger;

public class P016 {
    public static void main(String[] args) {
        int exponent = 1000;
        BigInteger base = BigInteger.valueOf(2);
        BigInteger power = BigInteger.valueOf(1);

        for (int i = 0; i < exponent; i++) {
            power = power.multiply(base);
        }
        System.out.println(power);

        long solution = getSumOfDigits(power.toString());
        System.out.println(solution);
    }

    public static long getSumOfDigits(String number) {
        int sum = 0;

        String[] digits = number.split("");
        for (String digit : digits) {
            sum += Integer.parseInt(digit);
        }

        return sum;
    }
}
