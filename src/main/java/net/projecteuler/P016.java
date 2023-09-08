package net.projecteuler;

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

        String[] digits = power.toString().split("");

        int sum = 0;
        for (String digit : digits) {
            sum += Integer.valueOf(digit);
        }

        System.out.println(sum);
    }
}
