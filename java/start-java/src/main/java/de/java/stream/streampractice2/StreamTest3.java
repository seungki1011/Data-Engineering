package de.java.stream.streampractice2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 5, 4, 2);
        Stream<Integer> integerStream = list.stream(); // list를 데이터 소스로 하는 스트림 생성

        integerStream.forEach(System.out::print); // 스트림 닫힘

    }
}

