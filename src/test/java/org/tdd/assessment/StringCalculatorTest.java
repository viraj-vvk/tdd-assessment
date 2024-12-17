package org.tdd.assessment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
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

}