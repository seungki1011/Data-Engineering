package de.java.stream.streampractice3;

import java.util.stream.IntStream;

public class IntermediateTest2 {
    public static void main(String[] args) {

        // 1. distinct
        IntStream intStream = IntStream.of(1,1,2,2,2,3,4,5,5,6,7,8,9,9)
                .distinct();
        intStream.forEach(System.out::print); // 123456789
        System.out.println();

        // 2. filter
        IntStream intStream2 = IntStream.rangeClosed(1, 10)
                .filter(i -> i % 2 == 0); // 2와 나누어서 나머지가 0이 아니면 전부 거름(홀수를 펄터링)
        intStream2.forEach(System.out::print); // 246810
        System.out.println();

        // 3. filter를 여러번 사용하기
        IntStream intStream3 = IntStream.rangeClosed(1, 100)
                .filter(i -> i % 2 == 0) // 홀수 필터링
                .filter(i -> i < 30) // 30이상 필터링
                .filter(i -> i % 3 == 0); // 3의 배수가 아닌 수 필터링
        intStream3.forEach(System.out::print);

    }
}
