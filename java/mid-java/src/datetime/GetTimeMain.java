package datetime;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;


public class GetTimeMain {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2030, 1, 1, 13, 30, 59);

        // 1. get()으로 조회하기
        System.out.println("---get() 사용---");
        System.out.println("YEAR = " + dt.get(ChronoField.YEAR));
        System.out.println("MONTH_OF_YEAR = " + dt.get(ChronoField.MONTH_OF_YEAR));
        System.out.println("DAY_OF_MONTH = " + dt.get(ChronoField.DAY_OF_MONTH));
        System.out.println("HOUR_OF_DAY = " + dt.get(ChronoField.HOUR_OF_DAY));
        System.out.println("MINUTE_OF_HOUR = " + dt.get(ChronoField.MINUTE_OF_HOUR));
        System.out.println("SECOND_OF_MINUTE = " + dt.get(ChronoField.SECOND_OF_MINUTE));

        // 2. 편의 메서드로 조회하기
        // 편의 메서드에 존재하지 않는 것들도 있다!
        System.out.println("---편의 메서드 사용---");
        System.out.println("YEAR = " + dt.getYear());
        System.out.println("MONTH_OF_YEAR = " + dt.getMonthValue());
        System.out.println("DAY_OF_MONTH = " + dt.getDayOfMonth());
        System.out.println("HOUR_OF_DAY = " + dt.getHour());
        System.out.println("MINUTE_OF_HOUR = " + dt.getMinute());
        System.out.println("SECOND_OF_MINUTE = " + dt.getSecond());

        // 편의 메서드에 없는 경우
        System.out.println("---편의 메서드에 없음---");
        System.out.println("MINUTE_OF_DAY = " + dt.get(ChronoField.MINUTE_OF_DAY));
        System.out.println("SECOND_OF_DAY = " + dt.get(ChronoField.SECOND_OF_DAY));
    }
}