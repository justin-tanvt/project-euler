package net.projecteuler.problems;

public class P006 {

    public static long getSumOfSquaresFromOneTo(long n) {
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            sum += i * i;
        }
        return sum;
    }

    public static long getSquareofSumFromOneTo(long n) {
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            sum += i;
        }
        return (sum * sum);
    }

    public static void main(String[] args) {
        System.out.println(getSquareofSumFromOneTo(100) - getSumOfSquaresFromOneTo(100));
    }
}
