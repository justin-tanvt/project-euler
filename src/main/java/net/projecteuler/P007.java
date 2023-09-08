package net.projecteuler;

public class P007 {
    public static boolean isPrime(long n) {
        // number is prime if it has a factor that is not 1 or itself
        if (n <=1) {
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

    public static long getPrimeNumber(long n) {
        long primesFound = 0;
        long latestPrime = -1;
        for (long i = 1; primesFound < n; i++) {
            if (isPrime(i)) {
                latestPrime = i;
                primesFound++;
            }
        }
        return latestPrime;
    }

    public static void main(String[] args) {
        System.out.println(getPrimeNumber(10001));
    }
}
