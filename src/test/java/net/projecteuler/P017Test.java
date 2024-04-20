package net.projecteuler;

import net.projecteuler.problems.P017;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P017Test {

    @Test
    void checkAllNumbersTo1000() {
        int result = 0;
        for (int i = 1; i <= 1000; i++) {
            result += P017.numberToLetters(i);
        }

        int expected = 21124;
        assertEquals(expected, result);
    }
}