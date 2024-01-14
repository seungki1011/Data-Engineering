package de.java.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateTimePDMain {
    public static void main(String[] args) {
        System.out.println("---------Using Period---------");
        LocalDate startDate = LocalDate.parse("2023-09-21");
        LocalDate endDate = LocalDate.parse("2024-01-15");

        // getDays()는 총 기간을 일로 환산해서 계산하는 것이 아니라 day 값만 반환
        // 2023-09-21 ~ 2024-01-15 -> 0년-3개월-25일
        int period1 = Period.between(startDate, endDate).getDays();
        // ChronoUnit.DAYS를 이용해서 총 일수 계산
        long period2 = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("Period.between(startDate, endDate).getDays() = "+period1);
        System.out.println("ChronoUnit.DAYS.between(startDate, endDate) = "+period2);

        System.out.println("--------Using Duration--------");
        LocalTime startTime = LocalTime.parse("08:15:00");
        LocalTime endTime = LocalTime.parse("15:45:00");
        LocalTime endTime2 = startTime.plus(Duration.ofMinutes(30)); // startTime 30분 이후

        long duration1 = Duration.between(startTime, endTime).getSeconds();
        long duration2 = ChronoUnit.SECONDS.between(startTime, endTime);
        long duration3 = ChronoUnit.SECONDS.between(startTime, endTime2);

        System.out.println("Duration.between(startTime, endTime).getSeconds() = "+duration1);
        System.out.println("ChronoUnit.SECONDS.between(startTime, endTime) = "+duration2);
        System.out.println("ChronoUnit.SECONDS.between(startTime, endTime2) = "+duration3+" (30분 차이)");

    }
}
