package de.java.stream.streampractice5;

import java.util.Arrays;
import java.util.List;

public class ReduceTest {
    public static void main(String[] args) {
        // 1. reduce(BinaryOperator<T> accumulator) - 모든 요소의 합
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Sum all elements of the stream
        int sum = numbers.stream()
                .reduce((a, b) -> a + b)
                .orElse(0);

        System.out.println("Sum of all elements = " + sum);

        // 2. reduce(T identity, BinaryOperator<T> accumulator) - 10을 초기값으로 한 모든 요소의 합
        // Sum all elements of the stream with an initial value of 10
        int sum2 = numbers.stream()
                .reduce(10, (a, b) -> a + b);

        System.out.println("Sum of all elements with initial value 10 = " + sum2);

        // 3. reduce(T identity, BinaryOperator<T> accumulator) -
        Integer[] numbers2 = {1, 2, 3, 4, 5};

        // Calculate the product of all numbers using reduce - 모든 요소의 곱
        int product = Arrays.stream(numbers2)
                .reduce(1, (a, b) -> a * b); // 누적 연산 결과 : a, 스트림의 요소 : b

        System.out.println("Product of numbers = " + product);  // 결과 : 120

        // 4. reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
        // Parallel sum of all elements of the stream
        int sum3 = numbers.parallelStream()
                .reduce(0, (a, b) -> a + b, Integer::sum);

        System.out.println("Parallel sum of all elements: " + sum3);

    }
}
