package de.java.datetime;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocalTimeMain {
    public static void main(String[] args) {
        System.out.println("---------------static factory methods---------------");
        LocalTime currentTime = LocalTime.now();
        System.out.println("LocalTime.now() = "+currentTime); // 현재 시간
        System.out.println("LocalTime.of(20, 50) = "+LocalTime.of(20, 50));
        System.out.println("LocalTime.parse(\"09:30\") = "+LocalTime.parse("09:30")); // 시간 파싱 해서 사용
        System.out.println("LocalTime.parse(\"22:17\") = "+LocalTime.parse("22:17"));
        System.out.println("LocalTime.parse(\"00:03\") = "+LocalTime.parse("00:03"));

        // 계산
        System.out.println("--------------------calculation---------------------");
        System.out.println("LocalTime.of(3, 30) = "+LocalTime.of(3, 30));
        System.out.println("LocalTime.of(3, 30).plus(2, ChronoUnit.HOURS) = "+LocalTime.of(3, 30).plus(2, ChronoUnit.HOURS));
        System.out.println("LocalTime.of(3, 30).plusHours(2) = "+ LocalTime.of(3, 30).plusHours(2));

        // 비교
        // LocalDate와 마찬가지로 isBefore, isAfter 등을 사용
    }
}
