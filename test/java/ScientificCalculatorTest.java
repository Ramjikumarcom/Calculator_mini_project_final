package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScientificCalculatorTest {

    @Test
    public void testSquareRoot() {
        assertEquals(4, ScientificCalculator.squareRoot(16));
    }

    @Test
    public void testFactorial() {
        assertEquals(120, ScientificCalculator.factorial(5));
    }

    @Test
    public void testNaturalLogarithm() {
        assertEquals(Math.log(10), ScientificCalculator.naturalLogarithm(10));
    }

    @Test
    public void testPowerFunction() {
        assertEquals(8, ScientificCalculator.power(2, 3));
    }
}
