package de.java.stream.streampractice3;

import java.util.Arrays;
import java.util.stream.Stream;

public class IntermediateTest3 {
    public static void main(String[] args) {

        // 1. 정수 스트림 natural order로 정렬하기
        Integer[] numbers = {5, 2, 8, 1, 3, 6};
        Stream<Integer> sortedStream = Arrays.stream(numbers)
                .sorted();
        sortedStream.forEach(System.out::print); // 123568
        System.out.println();

        // 2. 정수 스트림 reverse order로 정렬하기
        Stream<Integer> reverseStream = Arrays.stream(numbers)
                .sorted((i1, i2) -> i2.compareTo(i1)); // Comparator를 제공해서 정렬 기준 제공
        reverseStream.forEach(System.out::print); // 865321
        System.out.println();

        // 3. String 스트림 reverse order로 정렬하기
        String[] words = {"apple", "banana", "cantaloupe", "dinosaur"};
        Stream<String> reverseStream2 = Stream.of(words)
                .sorted((s1, s2) -> s2.compareTo(s1));
        reverseStream2.forEach(System.out::println);

    }
}
