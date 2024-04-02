package datetime;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class WithMain {
    public static void main(String[] args) {

        LocalDateTime dt = LocalDateTime.of(2020, 10, 5, 12, 30, 59);
        System.out.println("LocalDateTime.of(2020, 10, 5, 12, 30, 59) = " + dt);

        // with()를 이용해서 YEAR 필드를 2024로 변경
        LocalDateTime changedDt1 = dt.with(ChronoField.YEAR, 2024);
        System.out.println("LocalDateTime.of(2020, 10, 5, 12, 30, 59).with(ChronoField.YEAR, 2024) = " + changedDt1);

        // 편의 메서드 제공
        LocalDateTime changedDt2 = dt.withYear(2020);
        System.out.println("LocalDateTime.of(2020, 10, 5, 12, 30, 59).withYear(2020) = " + changedDt2);

        // TemporalAdjuster - 복잡한 날짜 조작에 사용
        // 다음주 일요일
        LocalDateTime with1 = dt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println("기준 날짜 = " + dt);
        System.out.println("다음 금요일 = " + with1);

        // 이번 달 마지막 월요일
        LocalDateTime with2 = dt.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));
        System.out.println("같은 달의 마지막 월요일 = " + with2);

    }
}
