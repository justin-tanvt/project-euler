package net.projecteuler;

import java.util.ArrayList;
import java.util.Collections;

public class P004 {

    public static boolean isPalindrome(long n) {
        String numberInString = String.valueOf(n);
        String reversedNumberInString = new StringBuilder().append(numberInString).reverse().toString();
        int stringMidpoint = (numberInString.length() + 1) / 2;
        String firstHalf = numberInString.substring(stringMidpoint);
        String secondHalfReversed = reversedNumberInString.substring(stringMidpoint);
        if (firstHalf.equals(secondHalfReversed)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        long numberLimit = 999;
        ArrayList<Long> palindromicMultiples = new ArrayList<>();

        for (long i = numberLimit; i >= 1; i--) {
            for (long j = i; j >= 1; j--) {
                if (isPalindrome(i * j)) {
                    palindromicMultiples.add(i*j);
                }
            }
        }
        Collections.sort(palindromicMultiples, Collections.reverseOrder());
        System.out.println(palindromicMultiples.get(0));
    }

}
