package de.java.stream.streampractice2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest2 {
    public static void main(String[] args) {
        // 스트림은 Read only (데이터 소스 변경 x)
        List<Integer> list = Arrays.asList(3, 1, 5, 4, 2); // 데이터 소스

        List<Integer> sortedList = list.stream().sorted() // list 정렬
                .collect(Collectors.toList()); // 새로운 sortedList에 저장

        System.out.println(list);
        System.out.println(sortedList);
    }
}
