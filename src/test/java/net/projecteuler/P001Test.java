package net.projecteuler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P001Test {

    @Test
    void check3FactorOf6() {
        boolean expected = true;
        boolean result = P001.isMultipleOf(6, 3);
        assertEquals(expected, result);
    }

    @Test
    void check3NotFactorOf7() {
        boolean expected = false;
        boolean result = P001.isMultipleOf(7, 3);
        assertEquals(expected, result);
    }
}