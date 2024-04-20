package net.projecteuler;

import java.math.BigInteger;

public class P015 {
    public static final long GRID_SIZE = 20;

    public static void main(String[] args) {
        System.out.println(getNumberOfPossibleRoutes(GRID_SIZE));
    }

    // given a grid of size X, any route to the bottom right corner has X no. of rightward and downward moves each
    // the route can be remodeled as a sequence of 2X slots, to be filled by X rightward and X downward moves
    // a route is made by choosing X out of the 2X slots to fill with a given direction
    // (after which, the remaining slots have to be in the other direction)
    // this is effectively a combination of X objects from a set of 2X objects
    // therefore, the number of routes is the number of unique ways X slots can be chosen from a total of 2X slots
    public static long getNumberOfPossibleRoutes(long gridSize) {
        long totalMoves = gridSize * 2;
        long movesInEachDirection = gridSize;
        return getNumberOfCombinations(totalMoves, movesInEachDirection);
    }

    public static long getNumberOfCombinations(long totalNumberOfObjects, long numberOfObjectsPerCombination) {
        return factorial(totalNumberOfObjects).divide(
                        factorial(numberOfObjectsPerCombination).multiply(
                                factorial(totalNumberOfObjects - numberOfObjectsPerCombination)
                        )
                ).longValue();
    }

    public static BigInteger factorial(long n) {
        BigInteger result = BigInteger.valueOf(1);

        for (long factor = 2; factor <= n; factor++) {
            result = result.multiply(BigInteger.valueOf(factor));
        }

        return result;
    }
}
