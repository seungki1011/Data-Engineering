package de.java.stream.streampractice4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {

        // 1. map() 이용해서 각 요소를 대문자로 변환
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        upperCaseNames.forEach(System.out::println);

        // 2. map()을 이용해서 각 요소를 제곱한다
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        squaredNumbers.forEach(System.out::println);

        // 3. map()을 이용해서 String -> Integer로 변환
        List<String> strings = Arrays.asList("10", "20", "30");

        List<Integer> integers = strings.stream()
                .map(Integer::parseInt) // Stream<String> -> Stream<Integer>
                .collect(Collectors.toList());

        integers.forEach(System.out::println);

    }
}
