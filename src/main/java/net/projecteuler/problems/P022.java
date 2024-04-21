package net.projecteuler.problems;

import net.projecteuler.utils.FileUtils;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

public class P022 {

    private static final String INPUT_FILEPATH = "src/main/resources/0022_names.txt";

    public static void main(String[] args) {
        System.out.printf("final solution = %s", solve());
    }

    public static String solve() {
        List<String> names = FileUtils.getContents(INPUT_FILEPATH, ",", "\"");
        Collections.sort(names);

        BigInteger solution = BigInteger.ZERO;
        for (int index = 0; index < names.size(); index++) {
            String name = names.get(index);
            int position = index + 1;
            long value = calculateAlphabeticalValue(name);

            BigInteger nameScore = BigInteger.valueOf(position).multiply(BigInteger.valueOf(value));
            solution = solution.add(nameScore);
        }

        return solution.toString();
    }

    private static long calculateAlphabeticalValue(String str) {
        // offset needed to convert A into 1, B into 2, etc.
        long offset = 64;
        long sum = 0;
        for (char c : str.toCharArray()) {
            long value = c - offset;
            sum += value;
        }
        return sum;
    }
}