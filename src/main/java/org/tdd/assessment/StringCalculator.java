package org.tdd.assessment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        Map<Boolean, List<Long>> filteredValues = Arrays.stream(str.split(delimiter)).map(Long::parseLong).collect(Collectors.groupingBy(val -> val < 0));
        List<Long> negativeValues = filteredValues.get(true);
        if (Objects.nonNull(negativeValues)) {
            throw new RuntimeException(String.format("negative numbers not allowed : %s", negativeValues.stream().map(String::valueOf).collect(Collectors.joining(","))));
        }
        return filteredValues.get(false).stream().reduce(0L, Long::sum);
    }
}
