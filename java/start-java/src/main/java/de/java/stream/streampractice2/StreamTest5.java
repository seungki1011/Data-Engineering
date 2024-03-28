package de.java.stream.streampractice2;

import java.util.Random;
import java.util.stream.IntStream;

public class StreamTest5 {
    public static void main(String[] args) {
        // limit
        IntStream intStream = new Random().ints(); // 무한 스트림이 생성 됨
        intStream.limit(4).forEach(System.out::println); // 4개의 요소만 출력하도록 limit 사용
        System.out.println("---------");

        // limit 사용하지 않고 유한 스트림으로
        IntStream intStream2 = new Random().ints(4); // 4개만
        intStream2.forEach(System.out::println);
        System.out.println("---------");

        // 난수의 범위 지정
        IntStream intStream3 = new Random().ints(0, 100); // 범위 : 0~99
        intStream3.limit(4).forEach(System.out::println);
        System.out.println("---------");

        // 특정 범위의 정수를 요소로 갖는 스트림
        IntStream intStream4 = IntStream.range(1, 10); // 범위 : 1~9
        // 끝의 수 까지 포함하고 싶으면 rangeClosed() 사용
        intStream4.forEach(System.out::print);

    }
}
