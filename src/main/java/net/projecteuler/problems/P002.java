package net.projecteuler.problems;

public class P002 {

    public static void main(String[] args) {

        long maximumNum = 4000000;

        // start with base case
        int previousNum = 1;
        int currentNum = 2;
        int nextNum;
        long sum = 2;

        while (true) {
            nextNum = previousNum + currentNum;
            previousNum = currentNum;
            currentNum = nextNum;

            if (currentNum > maximumNum) {
                break;
            }

            if (currentNum % 2 == 0) {
                sum += currentNum;
            }
        }

        System.out.println(sum);
    }

}
