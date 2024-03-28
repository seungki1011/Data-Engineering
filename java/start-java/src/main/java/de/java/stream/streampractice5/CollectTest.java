package de.java.stream.streampractice5;

import java.util.*;
import java.util.stream.Collectors;

public class CollectTest {
    public static void main(String[] args) {
        // 1. toList()
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        List<String> resultList = words.stream()
                .collect(Collectors.toList());

        System.out.println("Result List: " + resultList); // Output: Result List: [apple, banana, cherry]

        // 2. toSet()
        Set<String> words2 = Arrays.asList("apple", "banana", "cherry", "banana").stream()
                .collect(Collectors.toSet());

        System.out.println("Result Set: " + words2); // Output: Result Set: [apple, banana, cherry]

        // 3. toMap()
        Map<String, Integer> wordLengthMap = Arrays.asList("apple", "banana", "cherry")
                .stream()
                .collect(Collectors.toMap(
                        word -> word,      // Key mapper
                        String::length)); // Value mapper

        System.out.println("Word Length Map: " + wordLengthMap); // Output: Word Length Map: {apple=5, banana=6, cherry=6}


        // 4. joining()
        // List of strings
        List<String> words3 = Arrays.asList("Hello", "World", "Java");

        // Collect the strings into a single comma-separated string
        String result = words3.stream()
                .collect(Collectors.joining(", "));

        System.out.println("Result: " + result);  // Output: Result: Hello, World, Java

        // 5. summarizingInt()
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        IntSummaryStatistics stats = numbers.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));

        // Output: Statistics: IntSummaryStatistics{count=5, sum=15, min=1, average=3.000000, max=5}
        System.out.println("Statistics: " + stats);
    }

}

