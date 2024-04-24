package net.projecteuler.problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.projecteuler.problems.P015.factorial;

public class P024 {

    private static final long POSITION = 1000000;
    private static final List<Character> DIGITS = new ArrayList<>(Arrays.asList(
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    ));

    public static void main(String[] args) {
        System.out.printf("final solution = %s", solve());
    }

    private static String solve() {
        return findNthLexicographicPermutation(BigInteger.valueOf(POSITION), DIGITS);
    }

    private static String findNthLexicographicPermutation(BigInteger n, List<Character> characters) {
        // for example, if looking for 10th lexicographic permutation of chars [a,b,c,d]
        // change Nth position to index (i.e. 10th position is index 9)
        BigInteger index = n.subtract(BigInteger.ONE);
        StringBuilder result = new StringBuilder();

        int strLength = characters.size();
        for (int currentCharIndex = 0; currentCharIndex < strLength; currentCharIndex++) {
            // there are 3 chars behind the 1st char in a string of length 4
            int charsAfterCurrent = strLength - (currentCharIndex + 1);

            // for any char chosen at index = 0, there are 3 remaining char choices to fill the 3 chars behind it
            // thus, the number of permutations for these 3 chars is the factorial of 3 which is 6
            // this means there are 6 permutations for each chosen char at index = 0
            BigInteger permutationCountOfCharsAfterCurrent = factorial(charsAfterCurrent);

            // comparing the permutation count 6 with the desired index 9, it is apparent that the char at index = 0
            // lies within the 2nd possibility, which is 'b'.
            // the char is chosen from the list of chars by using the floor division result as an index
            int quotient = index.divide(permutationCountOfCharsAfterCurrent).intValue();
            result.append(characters.get(quotient));
            // the chosen char is removed from the pool of chars to prevent repetition
            characters.remove(quotient);

            // take the remainder of the current char's floor division as the index for the next char
            index = index.remainder(permutationCountOfCharsAfterCurrent);
        }

        return result.toString();
    }
}
