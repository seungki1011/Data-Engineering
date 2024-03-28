package de.java.stream.streampractice4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapTest {
    public static void main(String[] args) {
        // 1. flatMap()을 사용
        List<List<Integer>> nestedList = Arrays.asList( // 리스트 안의 리스트
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        // Using flatMap to flatten the nested list and filter even numbers
        List<Integer> flattenedAndFiltered = nestedList.stream()
                .flatMap(List::stream)// Flatten the nested list into a single stream
                .filter(n -> n % 2 == 0) // Filter even numbers
                .collect(Collectors.toList()); // Collect the result into a list

        System.out.println("Flattened and filtered list: " + flattenedAndFiltered);

        // 2. flatMap() 사용 X
        List<List<Integer>> nestedList2 = Arrays.asList( // 리스트 안의 리스트
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<List<Integer>> filteredLists = nestedList2.stream()
                .map(List::stream)
                .map(innerStream -> innerStream.filter(n -> n % 2 == 0).collect(Collectors.toList()))
                .collect(Collectors.toList());

        System.out.println("Filtered lists: " + filteredLists);
    }
}
