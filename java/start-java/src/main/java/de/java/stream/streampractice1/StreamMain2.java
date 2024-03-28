package de.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMain2 {
    public static void main(String[] args) {
        List<String> capitalList = new ArrayList<>();
        capitalList.add("Seoul");
        capitalList.add("Tokyo");
        capitalList.add("London");
        capitalList.add("Washington DC");
        capitalList.add("Seoul");
        capitalList.add("New Delhi");

        System.out.println(capitalList);

        // 스트림 생성후 사용
        // 스트림은 일회용 - 닫히면 재사용 불가
        List<String> result1 = capitalList.stream()
                .limit(2) // 앞에서 부터 2개로 제한
                .collect(Collectors.toList()); // 스트림의 모든 요소를 콜렉트해서 리스트로

        // 스트림은 원본 데이터를 건들지 않음
        System.out.println(result1); // result는 새로운 객체

        // 필터링
        List<String> result2 = capitalList.stream()
                .filter("Seoul"::equals) // seoul과 일치하는 요소만 필터링
                .collect(Collectors.toList());

        System.out.println(result2);

        // Set을 이용한 필터링
        Set<String> result3 = capitalList.stream()
                .filter("Seoul"::equals)
                .collect(Collectors.toSet());

        System.out.println(result3);

    }
}
