package net.projecteuler.problems;

public class P012 {
    public static int getTriangleNumberWithDivisorsOver(int divisorsNeeded) {
        int divisorsFound = 0;
        int triangleNumber = 0;
        for (int i = 1; divisorsFound < divisorsNeeded; i++) {
            divisorsFound = 0;
            triangleNumber += i;
            for (int j = 1; j * j <= triangleNumber; j++) {
                if (triangleNumber % j == 0) {
                    divisorsFound += 2;
                }
            }
        }
        return triangleNumber;
    }

    public static void main(String[] args) {
        System.out.println(getTriangleNumberWithDivisorsOver(500));
    }
}
