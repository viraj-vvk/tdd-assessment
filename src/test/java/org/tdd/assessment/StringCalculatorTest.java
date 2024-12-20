package org.tdd.assessment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StringCalculatorTest {

    private static final String NUMBERS = "6,5,1,2,3,20,74,108,529,639,521,0,741,999,529,63,32,10,79,654,123,741,23,98,547,89,62";
    private static final int SUM = 6698;

    @Test
    public void test_add_whenInput_emptyString_thenOutput_zero() {
        assertEquals("Test failed while sending empty string and expecting 0", 0, StringCalculator.add(""));
    }

    @Test
    public void test_add_whenInput_singleIntValue_thenOutput_sameValue() {
        assertEquals("Test failed while sending single number and expecting same value", 1, StringCalculator.add("1"));
    }

    @Test
    public void test_add_whenInput_twoNumbersCommaSeparated_thenOutput_sum() {
        assertEquals("Test failed while sending two comma separated numbers and expecting sum", 6, StringCalculator.add("1,5"));
    }

    @Test
    public void test_add_whenInput_multipleNumbersCommaSeparated_thenOutput_sum() {
        assertEquals("Test failed while sending multiple comma separated numbers and expecting sum", SUM, StringCalculator.add(NUMBERS));
    }

    @Test
    public void test_add_whenInput_multipleNumbersWithNewLineAndCommaSeparated_thenOutput_sum() {
        assertEquals("Test failed while sending ',' and '\\n' delimited numbers and expecting sum", SUM * 2, StringCalculator.add(String.format("%s\n%s", NUMBERS, NUMBERS.replaceAll(",", "\n"))));
    }

    @Test
    public void test_add_whenInput_multipleNumbersWithCustomDelimiter_thenOutput_sum() {
        assertEquals("Test failed while sending custom delimited numbers and expecting sum", SUM, StringCalculator.add(String.format("//;\n%s", NUMBERS.replace(",", ";"))));
    }

    @Test
    public void test_add_whenInput_multipleNumbersWithSpecialCharacterCustomDelimiter_thenOutput_sum() {
        assertEquals("Test failed while sending custom delimited numbers and expecting sum", SUM, StringCalculator.add(String.format("//.\n%s", NUMBERS.replace(",", "."))));
    }

    @Test
    public void test_add_whenInput_containsMultipleNumbers_then_exception_contains_negativeNumbers() {
        try {
            StringCalculator.add("-1,2,-3");
            fail("Test case failed while sending including negative numbers and expecting exception");
        } catch (RuntimeException exception) {
            assertEquals("Test case failed while sending including negative numbers and expecting exception with negative numbers", "negative numbers not allowed : -1,-3", exception.getMessage());
        }
    }

    @Test
    public void test_add_whenInput_numbersWithGreaterThan1000_thenOutput_sum_excluding_GreaterValuesThan1000() {
        assertEquals("Test failed while sending values greater than 1000 and expecting sum excluding values greater than 1000", 2, StringCalculator.add("1000,2"));
    }
}