package de.java.stream;

import java.util.Arrays;
import java.util.List;

public class StreamMain5 {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(1, 2, 3, 5, 6, 8, 11, 19, 20, 35);

        int listSum = numList.stream()
                .mapToInt(Integer::intValue).sum(); // IntStream은 sum과 같은 함수를 가지고 있음

        System.out.println("Sum of numList = "+listSum);

        int result = numList.stream()
                .reduce(0, Integer::sum); // 초기값 0에 다음 요소 더하고 넘김, 마지막 요소까지 반복 후 반환

        System.out.println("Sum of numList using reduce = "+result);
    }
}
