package de.java.stream.streampractice2;

import java.util.stream.Stream;

public class IterateTest {
    public static void main(String[] args) {
        Stream<Integer> evenNumbers = Stream.iterate(0, n -> n + 2)
                .limit(3);

        evenNumbers.forEach(System.out::println); // 0 2 4

        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n < 6, n -> n + 2);

        oddNumbers.forEach(System.out::println); // 1 3 5
    }
}
