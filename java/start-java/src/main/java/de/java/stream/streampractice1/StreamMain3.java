package de.java.stream.streampractice1;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMain3 {
    public static void main(String[] args) {
        // 배열 생성
        String[] strArr = {"This", "is", "a", "Array", "made", "of", "Strings!"};
        Stream<String> arrStream = Arrays.stream(strArr);
        arrStream.forEach(x -> System.out.print(x + " ")); // 각 요소를 띄어쓰기와 함께 출력

        System.out.println();
    }
}
