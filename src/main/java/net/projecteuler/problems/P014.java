package net.projecteuler.problems;

import java.util.*;

public class P014 {

    public static final int START_RANGE_INCLUSIVE = 1;
    public static final int END_RANGE_EXCLUSIVE = 1000000;
    public static final int FINAL_COLLATZ_NUMBER = 1;

    public static HashMap<Long, Integer> numberToChainlength = new HashMap<>();


    public static int getChainLength(long number) {
        // chain must end at final collatz number
        // hence, length will always be 1
        if (number == FINAL_COLLATZ_NUMBER) {
            return 1;
        }

        // check if number's chain length already computed earlier and cached
        if (numberToChainlength.containsKey(number)) {
            return numberToChainlength.get(number);
        }

        // if not computed before, proceed to compute
        // current number's chain is 1 term longer than the next number's chain
        // hence, recursively get next number's chain length until final number reached
        int newChainLengthComputed = 1 + getChainLength(getNextCollatzNumber(number));
        numberToChainlength.put(number, newChainLengthComputed);
        return newChainLengthComputed;
    }

    public static long getNextCollatzNumber(long currentNumber) {
        if (currentNumber % 2 == 0) {
            return currentNumber / 2;
        } else {
            return 3 * currentNumber + 1;
        }
    }

    public static void main(String[] args) {
        // sanity test using example from question
        assert getChainLength(13) == 10;

        // base case
        long numberForLongestChain = FINAL_COLLATZ_NUMBER;
        int longestChainLength = 1;

        for (long i = START_RANGE_INCLUSIVE; i < END_RANGE_EXCLUSIVE; i++) {
            int currentChainLength = getChainLength(i);
            if (currentChainLength > longestChainLength) {
                longestChainLength = currentChainLength;
                numberForLongestChain = i;
            }
        }

        System.out.printf("Starting number %s produces longest Collatz sequence of length %s", numberForLongestChain, longestChainLength);
    }
}
