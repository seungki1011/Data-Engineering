package de.java.stream.streampractice2;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest4 {
    public static void main(String[] args) {
        // 1. 객체 배열로 부터 스트림 생성하기
        // Stream<T> Stream.of(v1, v2, .. vn)
        Stream<String> stringStream1 = Stream.of("A", "B", "C");
        stringStream1.forEach(System.out::print);
        sepLine();

        // Stream<T> Stream.of(T[])
        Stream<String> stringStream2 = Stream.of(new String[]{"A", "B", "C"});
        stringStream2.forEach(System.out::print);
        sepLine();

        // Stream<T> Arrays.stream(T[])
        String[] strArr = {"A", "B", "C"};
        Stream<String> stringStream3 = Arrays.stream(strArr);
        stringStream3.forEach(System.out::print);
        sepLine();

        // 2. 기본형 배열로 부터 스트림 생성하기
        int[] intArr = {10, 20, 30, 40};
        IntStream intStream = Arrays.stream(intArr);
        intStream.forEach(System.out::print);
        sepLine();

        // Stream<Integer>를 사용하고 싶으면 int[] -> Integer[] 사용한다
        Integer[] integers = {10, 20, 30, 40};
        Stream<Integer> intStream2 = Arrays.stream(integers);
        intStream2.forEach(System.out::print);

    }

    static public void sepLine() {
        System.out.println();
        System.out.println("-----------------------");
    }

}
