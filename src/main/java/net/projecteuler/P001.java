package net.projecteuler;

public class P001 {

    public static boolean isMultipleOf(int numberToCheck, int factorToCheck) {
        return numberToCheck % factorToCheck == 0;
    }

    public static void main(String[] args) {

        int sum = 0;

        for (int i = 0; i < 1000; i++) {
            if (isMultipleOf(i,3) || isMultipleOf(i, 5)) {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}
