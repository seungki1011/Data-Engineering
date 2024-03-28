package de.java.stream.streampractice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice1 {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>(Arrays.asList("김정우", "김호정", "이하늘", "이정희", "박정우", "박지현", "이지수"));
        List<String> result = nameList.stream()
                .filter(s -> s.startsWith("이"))
                .collect(Collectors.toList());
                // .count();

        System.out.println(result);
    }
}
