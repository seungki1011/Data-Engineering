package de.java.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateMain {
    public static void main(String[] args) {
        // 1. static factory methods

        System.out.println("---------------static factory methods---------------");
        LocalDate localDate = LocalDate.now();
        // now() : 현재 날짜의 LocalDate 객체
        System.out.println("LocalDate.now() = "+localDate); // 현재 날짜

        // of() : 년, 월, 일을 설정한 객체 만듬
        System.out.println("LocalDate.of(2023, 10, 20) = "+LocalDate.of(2023, 10, 20));

        // parse() : String을 파싱해서 객체를 만듬
        System.out.println("LocalDate.parse(\"2028-03-03\") = "+LocalDate.parse("2028-03-03"));

        // 2. calculation
        System.out.println("--------------------calculation---------------------");
        System.out.println("LocalDate.now() = "+localDate);
        // 날짜 더하기
        LocalDate nextDay = LocalDate.now().plusDays(1); // 하루를 더해서 나온 날짜
        System.out.println("LocalDate.now().plusDays(1) = "+nextDay);
        System.out.println("LocalDate.now().plusDays(40) = "+LocalDate.now().plusDays(40));
        System.out.println("LocalDate.now().plusYears(10) = "+LocalDate.now().plusYears(10)); // 10년을 더해서

        // 날짜 빼기
        LocalDate previousMonthDate = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println("LocalDate.now().minus(1, ChronoUnit.MONTHS) = "+previousMonthDate);
        System.out.println("LocalDate.now().minusMonths(1) = "+LocalDate.now().minusMonths(1));

        // 요일 찾기
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek(); // 현재 날짜의 요일
        System.out.println("LocalDate.now().getDayOfWeek() = "+dayOfWeek);

        // 날짜의 해당일
        int day = LocalDate.of(2500, 4, 20).getDayOfMonth(); // 20일 이니깐 20 리턴
        System.out.println("LocalDate.of(2500, 4, 20).getDayOfMonth() = "+day);

        // 윤년(leap year) 확인
        System.out.println("LocalDate.now().isLeapYear() = "+LocalDate.now().isLeapYear()); // 윤년이면 true 반환

        // 첫번째 날 반환
        // 설정한 날짜를 해당 달의 첫번째 날로 수정
        LocalDate firstDayOfMonth = LocalDate.parse("2024-01-26").with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("LocalDate.parse(\"2024-01-26\").with(TemporalAdjusters.firstDayOfMonth()) = "+firstDayOfMonth);

        // 3. comparison
        System.out.println("---------------------comparison---------------------");
        boolean compare1 = LocalDate.parse("2024-01-04").isBefore(LocalDate.parse("2005-01-04"));
        System.out.println("LocalDate.parse(\"2024-01-04\").isBefore(LocalDate.parse(\"2005-01-04\")) = "+compare1);
        boolean compare2 = LocalDate.parse("2024-01-04").isAfter(LocalDate.parse("2005-01-04"));
        System.out.println("LocalDate.parse(\"2024-01-04\").isAfter(LocalDate.parse(\"2005-01-04\")) = "+compare2);

    }
}
