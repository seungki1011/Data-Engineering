package de.java.stream.streampractice2;

import java.util.Arrays;
import java.util.List;

public class StreamTest1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sumOfEvenNumbers = numbers.stream()         // Data source: List of integers
                .filter(num -> num % 2 == 0)            // Intermediate operation: Filter even numbers
                .mapToInt(num -> num)                   // Intermediate operation: Convert Integer to int
                .sum();                                 // Terminal operation: Calculate sum

        System.out.println("Sum of even numbers: " + sumOfEvenNumbers);
    }
}
