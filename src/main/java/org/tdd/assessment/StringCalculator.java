package org.tdd.assessment;

import java.util.Objects;

public class StringCalculator {
    public static long add(String str) {
        if (Objects.isNull(str) || str.isEmpty()) {
            return 0;
        }
        String[] numbers = str.split(",");
        return numbers.length > 1 ? Long.parseLong(numbers[0]) + Long.parseLong(numbers[1]) : Long.parseLong(numbers[0]);
    }
}
