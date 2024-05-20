package net.projecteuler.problems;

import static net.projecteuler.problems.P010.isPrime;

public class P027 {
    private static final int COEFF_A_MODULUS_INCLUSIVE = 999;
    private static final int COEFF_B_MODULUS_INCLUSIVE = 1000;
    private static final int N_STARTING_VALUE = 0;

    public static void main(String[] args) {
        System.out.printf("final solution = %s\n", solve());
    }

    private static String solve() {
        int[] tracker = new int[3];         // use indexes 1 and 2 to track coefficients a and b
        tracker[0] = -1;                    // use index 0 to track maximum consecutive prime count

        for (int a = -COEFF_A_MODULUS_INCLUSIVE; a <= COEFF_A_MODULUS_INCLUSIVE; a++) {
            for (int b = -COEFF_B_MODULUS_INCLUSIVE; b <= COEFF_B_MODULUS_INCLUSIVE; b++) {
                int primeCount = 0;
                int n = N_STARTING_VALUE;

                while (true) {
                    long quadraticExpressionValue = n * n + a * n + b;
                    if (isPrime(quadraticExpressionValue)) {
                        primeCount++;
                        n++;
                    } else {
                        break;
                    }
                }

                if (primeCount > tracker[0]) {
                    tracker[0] = primeCount;
                    tracker[1] = a;
                    tracker[2] = b;
                }
            }
        }

        System.out.printf("final solution is [%s,%s] with %s consecutive primes\n", tracker[1], tracker[2], tracker[0]);
        long solution = tracker[1] * tracker[2];
        return String.valueOf(solution);
    }
}
