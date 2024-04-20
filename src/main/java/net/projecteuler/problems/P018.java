package net.projecteuler.problems;

import net.projecteuler.questions.Q018;

public class P018 {
    public static void main(String[] args) {
        int solution = getMaximumPathSum(Q018.getQuestionData());
        System.out.printf("\n final solution = %s", solution);
    }

    public static int getMaximumPathSum(int[][] data) {
        int triangleSize = data.length;
        int[][] maximumTotalTriangle = new int[triangleSize][triangleSize];

        for (int r = 0; r < triangleSize; r++) {
            for (int c = 0; c <= r; c++) {
                int currentNumber = data[r][c];
                int maxTotalFromAbove = (getMaxFromAdjacentNumsAbove(maximumTotalTriangle, r, c));
                int currentNumberMaxTotal = currentNumber + maxTotalFromAbove;
                maximumTotalTriangle[r][c] = currentNumberMaxTotal;
            }
        }

        int maxTotal = -1;
        for (int total : maximumTotalTriangle[triangleSize-1]) {
            if (total > maxTotal) {maxTotal = total;}
        }

        return maxTotal;
    }

    private static int getMaxFromAdjacentNumsAbove(int[][] data, int row, int col) {
        int rowAbove = row - 1;
        if (rowAbove < 0) {
            return 0;
        }

        int leftCol = col - 1;
        int numAboveLeft = 0;
        if (leftCol >= 0) {
            numAboveLeft = data[rowAbove][leftCol];
        }

        int rightCol = col;
        int numAboveRight = 0;
        if (rightCol >= 0) {
            numAboveRight = data[rowAbove][rightCol];
        }

        return Math.max(numAboveLeft, numAboveRight);
    }
}
