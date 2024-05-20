package net.projecteuler.problems;

public class P028 {
    private static final int SPIRAL_DIMENSION = 1001;

    // this problem will be modeled using the concept of rings
    // the 0th ring (i.e. R=0) is the number 1 (not in a ring)
    // the 1st ring (i.e. R=1) contains the outermost numbers of the 3x3 spiral
    // the 2nd ring (i.e. R=2) contains the outermost numbers of the 5x5 spiral, and so on

    public static void main(String[] args) {
        System.out.printf("final solution = %s\n", solve());
    }

    private static String solve() {
        long totalDiagonalSum = 1;        // start with number 1, which is not in any ring

        for (int r = 1; r <= getRingNumber(SPIRAL_DIMENSION); r++) {
            long ds = sumOfDiagonalsInRing(r);
            System.out.printf("R=%s min=%s diagsum=%s\n", r, findMinNumberInRing(r), ds);
            totalDiagonalSum += ds;
        }

        return String.valueOf(totalDiagonalSum);
    }

    private static int getRingNumber(int ringDimension) {
        return (ringDimension - 1) / 2;
    }

    private static int getRingDimension(int ringNumber) {
        return 2 * ringNumber + 1;
    }

    private static int findMaxNumberInRing(int ringNumber) {
        if (ringNumber == 0) {
            return 1;
        }

        return getRingDimension(ringNumber) * getRingDimension(ringNumber);
    }

    private static int findMinNumberInRing(int ringNumber) {
        int previousRing = ringNumber - 1;
        return findMaxNumberInRing(previousRing) + 1;
    }

    private static int sumOfDiagonalsInRing(int ringNumber) {
        int differenceAlongEdge = getRingDimension(ringNumber) - 1;
        int smallestDiagonalInRing = findMinNumberInRing(ringNumber) + (differenceAlongEdge - 1);
        return smallestDiagonalInRing * 4 + differenceAlongEdge * 6;
    }
}
