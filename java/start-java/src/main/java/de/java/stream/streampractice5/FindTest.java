package de.java.stream.streampractice5;

import java.util.Optional;
import java.util.stream.Stream;

public class FindTest {
    public static void main(String[] args) {
        // 1. findFirst() - 첫 번째 요소를 반환
        Optional<String> first = Stream.of("apple", "banana", "cherry", "date")
                .findFirst();

        first.ifPresent(System.out::println); // 스트림에 findFirst() 연산을 통해 값이 존재하면 출력

        // 2. findAny() - 아무 요소 하나를 반환, (순차 스트림)
        Stream<String> stream = Stream.of("apple", "banana", "cherry", "date", "eclipse");
        Optional<String> any = stream.findAny();

        any.ifPresent(System.out::println); // 현재 스트림은 순차(sequential)이기 때문에 똑같이 apple 출력

        // 2. findAny() - (병렬 스트림)
        Optional<String> any2 = Stream.of("apple", "banana", "cherry", "date", "eclipse")
                .parallel()
                .findAny();

        any2.ifPresent(System.out::println); // apple, banana, cherry.. 아무 값이 올 수 있음

    }
}
