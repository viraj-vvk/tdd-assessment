package org.tdd.assessment;

import java.util.Objects;

public class StringCalculator {
    public static long add(String str) {
        return Objects.isNull(str) || str.isEmpty() ? 0 : Long.MIN_VALUE;
    }
}
