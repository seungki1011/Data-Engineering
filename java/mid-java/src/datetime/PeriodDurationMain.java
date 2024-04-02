package datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class PeriodDurationMain {
    public static void main(String[] args) {

        System.out.println("---Period---");
        // 1. Period - 두 날짜 사이의 간격을 년, 월, 일로 나타낸다
        // 객체 생성
        Period period = Period.ofDays(10);
        System.out.println(" Period.ofDays(10) = " + period);

        // 계산
        LocalDate currentDate = LocalDate.of(2030, 1, 1);
        LocalDate plusDate = currentDate.plus(period);
        System.out.println("(지정 날짜) LocalDate.of(2030, 1, 1) = " + currentDate);
        System.out.println("(더한 날짜 +P10D) LocalDate.of(2030, 1, 1).plus(period) = " + plusDate);

        // 기간 차이
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 4, 2);

        Period between = Period.between(startDate, endDate);
        System.out.println("(사이의 기간) Period.between(startDate, endDate) = " + between);

        // 특정 필드 추출
        System.out.println("기간: " + between.getMonths() + "개월 " + between.getDays() + "일");

        System.out.println("---Duration---");
        // 2. Duration - 두 시간 사이의 간격을 시, 분, 초 단위로 나타낸다
        // 객체 생성
        Duration duration = Duration.ofMinutes(30); // 특정 시간을 정해서 Period 생성
        System.out.println("Duration.ofMinutes(30) = " + duration);

        LocalTime lt = LocalTime.of(1, 0);
        System.out.println("(기준 시간) LocalTime.of(1, 0) = " + lt);

        // 계산
        LocalTime plusTime = lt.plus(duration); // 30분 더하기
        System.out.println("(더한 시간 +30m) LocalTime.of(1, 0).plus(duration) = " + plusTime);


        // 시간 차이
        LocalTime start = LocalTime.of(9, 0); // 시작 시간
        LocalTime end = LocalTime.of(10, 0); // 끝 시간

        Duration betweenDuration = Duration.between(start, end);
        System.out.println("차이 : " + betweenDuration.getSeconds() + "초");
        System.out.println("근무 시간 : " + betweenDuration.toHours() + "시간 " + betweenDuration.toMinutesPart() + "분");

    }
}
