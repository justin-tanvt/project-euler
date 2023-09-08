package net.projecteuler;

public class P005 {

    public static boolean isDivisibleBy1To20(long n) {
        int[] factorsToDivideBy = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        for (int factor : factorsToDivideBy) {
            if (n % factor != 0) {
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
        long numberToFind = 1;
        while (true) {
            if (isDivisibleBy1To20(numberToFind)) {
                System.out.println(numberToFind);
                break;
            } else {
                numberToFind++;
            }
        }
    }

}
