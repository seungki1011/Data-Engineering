package de.java.stream.streampractice4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PeekTest {
    public static void main(String[] args) {

        // 1. peek()로 요소 출력
        Stream<Integer> stream = Stream.of(1, 2, 3);
        Stream<Integer> peekedStream = stream.peek(System.out::print); // peek()는 중간 연산이기 때문에 지연 연산
        // 지연 연산(lazy evaluation) : 최종 연산이 수행될 때 다 같이 연산 수행

        // peek()로 요소 하나 출력 -> forEach()로 요소 하나 출력 반복
        peekedStream.forEach(System.out::println); // 최종 연산

        // 2. peek()로 연산에 대한 로깅(logging)
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // 필터링과 매핑 연산이 있는 스트림에 대해 peek()로 로깅
        List<Integer> squaredEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println("Filtered: " + n)) // 필터링한 요소 로깅
                .map(n -> n * n)
                .peek(n -> System.out.println("Mapped: " + n)) // 매핑한 요소 로깅
                .collect(Collectors.toList());

        System.out.println("Squared even numbers: " + squaredEvenNumbers);

    }
}
