package de.java.stream.streampractice5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectTest2 {
    public static void main(String[] args) {
        // 1. partitioningBy() - 스트림을 2분할
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // 2의 배수면 true, 2의 배수가 아니면 false로 분할
        Map<Boolean, List<Integer>> partitions = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        // Output: Partitions: {false=[1, 3, 5], true=[2, 4]}
        System.out.println("Partitions: " + partitions);

        // 2. groupingBy() - 스트림을 n분할
        List<String> words = Arrays.asList("apple", "banana", "cherry", "cantaloupe");

        // 각 문자열의 길이 별로 그룹핑
        Map<Integer, List<String>> groups = words.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println("Groups: " + groups); // Output: Groups: {5=[apple], 6=[banana, cherry]}

    }
}
