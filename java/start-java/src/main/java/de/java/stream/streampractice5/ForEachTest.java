package de.java.stream.streampractice5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachTest {
    public static void main(String[] args) {
        // 1. 맵의 각 요소를 forEach()를 이용해서 출력
        Map<Integer, String> studentMap = new HashMap<>();
        studentMap.put(1, "Alice");
        studentMap.put(2, "Bob");
        studentMap.put(3, "Charlie");

        studentMap.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

        // 2. forEach()를 이용해서 리스트의 각 요소를 대문자로 변환
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Mango");

        // 각 요소를 대문자로 변환
        fruits.forEach(fruit -> {
            String upperCaseFruit = fruit.toUpperCase();
            // 대문자로 변환된 요소를 출력하는 작업까지 포함
            System.out.println("Processed fruit: " + upperCaseFruit);
        });
    }
}
