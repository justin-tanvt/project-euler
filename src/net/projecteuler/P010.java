package net.projecteuler;

public class P010 {

    public final static long numberLimitNotInclusive = 2000000L;

    public static boolean isPrime(long n) {
        // number is prime if it has a factor that is not 1 or itself
        if (n <= 1) {
            return false;
        }
        long largerFactor;
        for (long smallerFactor = 1; smallerFactor * smallerFactor <= n; smallerFactor++) {
            largerFactor = n / smallerFactor;
            if ((n % smallerFactor == 0) && (smallerFactor != 1) && (smallerFactor != n)) {
                return false;
            }
        }
        return true;
    }

    public static long getSumOfPrimesBelow(long n) {
        long sum = 0;
        for (long i = 1; i < n; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getSumOfPrimesBelow(numberLimitNotInclusive));
    }
}
