package org.tdd.assessment;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static long add(String str) {
        if (Objects.isNull(str) || str.isEmpty()) {
            return 0;
        }
        String delimiter = ",|\n";
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (matcher.matches()) {
            delimiter = Pattern.quote(matcher.group(1));
            str = matcher.group(2);
        }
        return Arrays.stream(str.split(delimiter)).map(Long::parseLong).reduce(0L, Long::sum);
    }
}
