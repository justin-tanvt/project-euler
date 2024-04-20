package net.projecteuler.problems;

public class P009 {
    public static final int SUM = 1000;

    public static boolean isCorrectSum(int a, int b, int c) {
        return (a + b + c) == SUM;
    }

    public static boolean isPythagoreanTriplet(int a, int b, int c) {
        return (a * a + b * b) == (c * c);
    }

    public static void main(String[] args) {
        // 1 <= a <= 332
        for (int a = 1; a <= SUM; a++) {
            for (int b = a + 1; b <= SUM; b++) {
                for (int c = b + 1; c <= SUM; c++) {
                    if (isCorrectSum(a, b, c) && isPythagoreanTriplet(a, b, c)) {
                        System.out.println(a * b * c);
                        System.exit(0);
                    }
                }
            }
        }
    }

}
