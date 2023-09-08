package net.projecteuler;

public class P003 {

    public static long largestPrimeFactor(long n) {
        long largestPrimeFromSmallFactors = -1;

        for (long smallerFactor = 1; smallerFactor * smallerFactor < n; smallerFactor++) {
            if (n % smallerFactor == 0) {
                long largerFactor = n / smallerFactor;
                if (isPrime(largerFactor)) {
                    return (largerFactor);
                }
                if (isPrime(smallerFactor)) {
                    largestPrimeFromSmallFactors = smallerFactor;
                }
            }
        }
        return (largestPrimeFromSmallFactors);
    }

    public static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        long factor1 = n;
        long factor2 = 1;
        while (factor1 > factor2) {
            factor1 = n / factor2;
            if ((n % factor1 == 0) && (factor1 != n)) {
                return false;
            } else {
                factor2++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long toVerify = 13195L;
        long toSolve = 600851475143L;

        System.out.println(largestPrimeFactor(toSolve));
    }

}
