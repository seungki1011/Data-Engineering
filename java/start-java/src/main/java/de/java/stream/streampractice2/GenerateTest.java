package de.java.stream.streampractice2;

import java.util.stream.Stream;

public class GenerateTest {
    public static void main(String[] args) {
        Stream<Double> randomStream = Stream.generate(Math::random)
                .limit(3);
        randomStream.forEach(System.out::println);

        Stream<Integer> oneStream = Stream.generate(() -> 1)
                .limit(4);
        oneStream.forEach(System.out::println);

    }
}
