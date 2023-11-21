package net.projecteuler;

import java.util.*;

public class P014 {

    public static final int START_RANGE_INCLUSIVE = 1;
    public static final int END_RANGE_EXCLUSIVE = 1000000;
    public static final int FINAL_NUMBER = 1;

    public static HashMap<Long, Integer> numbersAndChainLength = new HashMap<>();


    public static int getChainLength(long number) {
        int chainLength;
        if (number == FINAL_NUMBER) {
            chainLength = 1;
        } else {
            if (numbersAndChainLength.containsKey(number)) {
                return numbersAndChainLength.get(number);
            } else {
                long nextNumber;
                if (number % 2 == 0) {
                    nextNumber = number / 2;
                } else {
                    nextNumber = 3 * number + 1;
                }
                chainLength = (1 + getChainLength(nextNumber));
            }
        }
//        numbersAndChainLength.put(number, chainLength);
        return chainLength;
    }

    public static void main(String[] args) {
        long longestChainLength = 1;
        long numberForLongestChain = FINAL_NUMBER;
        for (long i = START_RANGE_INCLUSIVE; i < END_RANGE_EXCLUSIVE; i++) {
            int currentChainLength = getChainLength(i);
            if (currentChainLength > longestChainLength) {
                longestChainLength = currentChainLength;
                numberForLongestChain = i;
            }
            numbersAndChainLength.put(i, currentChainLength);
        }
        System.out.println(numberForLongestChain);
    }
}
