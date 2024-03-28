package de.java.stream.streampractice5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MatchTest {
    public static void main(String[] args) {
        // 1. allMatch() - 모든 요소가 조건을 만족하면 true
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);

        // Check if all numbers are even
        boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
        System.out.println("All numbers are even: " + allEven);

        // 2. anyMatch() - 한 요소라도 조건을 만족하면 true

        // Check if at least one fruit starts with "B"
        boolean anyStartsWithB = Stream.of("Apple", "Banana", "Orange", "Mango").
                anyMatch(fruit -> fruit.startsWith("B"));
        System.out.println("At least one fruit starts with 'B': " + anyStartsWithB);

        // 3. noneMatch() - 모든 요소가 조건을 만족시키지 않으면 true
        List<Integer> oddNumbers = Arrays.asList(3, 5, 7, 9, 11);

        // Check if no number is even
        boolean noneEven = oddNumbers.stream().noneMatch(n -> n % 2 == 0);
        System.out.println("No number is even: " + noneEven);
    }
}
