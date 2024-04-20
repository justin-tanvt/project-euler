package net.projecteuler.problems;

import net.projecteuler.questions.Q067;

import static net.projecteuler.problems.P018.getMaximumPathSum;

public class P067 {
    public static void main(String[] args) {
        int solution = getMaximumPathSum(Q067.getQuestionData());
        System.out.printf("\n final solution = %s", solution);
    }
}
