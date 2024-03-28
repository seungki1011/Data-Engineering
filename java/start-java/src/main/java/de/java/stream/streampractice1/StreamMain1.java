package de.java.stream.streampractice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain1 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("Seoul", "Tokyo", "Washington DC", "London"));

        System.out.println("----------1. Using Stream----------");
        Stream<String> stringStream = stringList.stream(); // 스트림 생성
        // 1. 스트림을 사용해서 리스트의 모든 요소 대문자화 후 출력
        stringStream.map((str) -> str.toUpperCase()).forEach(System.out::println);
        // 변수 타입 생략 가능(추론 가능)
        // stringStream.map((String str) -> str.toUpperCase()).forEach(System.out::println);


        System.out.println("---------2. Without Stream---------");
        // 2. 스트림을 사용하지 않고 리스트의 모든 요소 출력
        stringList.forEach((str)-> System.out.println(str));

        // 3. 이중 콜론(Method reference operator) 사용 (2번의 결과와 같음)
        // 호출하고자는 함수의 파라미터와 람다식에 전달되는 인자와 일치해야 함
        System.out.println("------------3. Using ::------------");
        stringList.forEach(System.out::println);

    }
}
