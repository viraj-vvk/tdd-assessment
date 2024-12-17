package org.tdd.assessment;

import java.util.Arrays;
import java.util.Objects;

public class StringCalculator {
    public static long add(String str) {
        if (Objects.isNull(str) || str.isEmpty()) {
            return 0;
        }
        return Arrays.stream(str.split(",|\n")).map(Long::parseLong).reduce(0L, Long::sum);
    }
}
