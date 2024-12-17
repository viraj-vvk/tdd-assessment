package org.tdd.assessment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    @Test
    public void test_add_whenInput_emptyString_thenOutput_zero() {
        assertEquals("Test failed while sending empty string and expecting 0", 0, StringCalculator.add(""));
    }

}