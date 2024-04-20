package net.projecteuler;

public class P005 {

    public static boolean isDivisibleByAllNumbersInRangeInclusive(long number, int firstFactor, int lastFactor) {
        for (int factor = firstFactor; factor <= lastFactor; factor++) {
            if (number % factor != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        /*
        2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
        What is the smallest positive number that is evenly divisible by all the numbers from 1 to 20?
         */
        int FACTOR_MIN = 1;
        int FACTOR_MAX = 20;

        long currentNumber = 1;
        while (true) {
            if (isDivisibleByAllNumbersInRangeInclusive(currentNumber, FACTOR_MIN, FACTOR_MAX)) {
                System.out.println(currentNumber);
                break;
            } else {
                currentNumber++;
            }
        }
    }

}
