package de.java.datetime;

import java.time.LocalDateTime;
import java.time.Month;

public class LocalDateTimeMain {
    public static void main(String[] args) {

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("LocalDateTime.now() = "+dateTime); // 현재 날짜와 시간, ISO-8601 standard
        System.out.println("LocalDateTime.parse(\"2030-10-15-0T04:20:00\") = "+LocalDateTime.parse("2020-10-15T04:20:00"));
        System.out.println("LocalDateTime.of(2020, Month.OCTOBER, 15, 4, 20) = "+LocalDateTime.of(2020, Month.OCTOBER, 15, 4, 20));
        System.out.println("LocalDateTime.now().getMonth() = "+LocalDateTime.now().getMonth()); // 현재 1월이니 January
    }
}
