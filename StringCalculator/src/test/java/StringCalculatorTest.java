import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    @Test
    void testAddEmptyString() {
        assertEquals("0", StringCalculator.add(""));
    }

    @Test
    void testAddSingleNumber() {
        assertEquals("1.0", StringCalculator.add("1"));
    }

    @Test
    void testAddTwoNumbers() {
        assertEquals("3.0", StringCalculator.add("1,2"));
    }

    @Test
    void testAddMultipleNumbers() {
        assertEquals("6.0", StringCalculator.add("1,2,3"));
    }

    @Test
    void testAddWithNewline() {
        assertEquals("6.0", StringCalculator.add("1\n2,3"));
    }

    @Test
    void testAddWithCustomDelimiter() {
        assertEquals("3.0", StringCalculator.add("//;\n1;2"));
    }

    @Test
    void testAddWithNegativeNumbers() {
        assertEquals("Negative not allowed : [-1.0]", StringCalculator.add("-1,2"));
    }

    @Test
    void testAddWithMultipleErrors() {
        assertEquals("Number expected but ',' found at position 3.\nNegative not allowed : [-1.0]", StringCalculator.add("-1,,2"));
    }

    @Test
    void testMultiplyEmptyString() {
        assertEquals("0", StringCalculator.multiply(""));
    }

    @Test
    void testMultiplySingleNumber() {
        assertEquals("2.0", StringCalculator.multiply("2"));
    }

    @Test
    void testMultiplyTwoNumbers() {
        assertEquals("6.0", StringCalculator.multiply("2,3"));
    }

    @Test
    void testMultiplyMultipleNumbers() {
        assertEquals("24.0", StringCalculator.multiply("2,3,4"));
    }

    @Test
    void testMultiplyWithNewline() {
        assertEquals("24.0", StringCalculator.multiply("2\n3,4"));
    }

    @Test
    void testMultiplyWithCustomDelimiter() {
        assertEquals("6.0", StringCalculator.multiply("//;\n2;3"));
    }

    @Test
    void testMultiplyWithNegativeNumbers() {
        assertEquals("Negative not allowed : [-2.0]", StringCalculator.multiply("-2,3"));
    }

    @Test
    void testMultiplyWithMultipleErrors() {
        assertEquals("Negative not allowed : [-2.0]\nNumber expected but ',' found at position 3.", StringCalculator.multiply("-2,,3"));
    }
}