package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeMain {
    public static void main(String[] args) {

        // 1. LocalDateTime 객체
        LocalDateTime nowDt = LocalDateTime.now();
        LocalDateTime ofDt = LocalDateTime.of(2002, 4, 5, 9, 30, 10);

        System.out.println("(현재 날짜&시간) LocalDateTime.now() = " + nowDt);
        System.out.println("(지정 날짜&시간) LocalDateTime.of(2002, 4, 5, 9, 30, 10) = " + ofDt);

        // 2. 날짜와 시간의 분리
        LocalDate localDate = ofDt.toLocalDate();
        LocalTime localTime = ofDt.toLocalTime();

        System.out.println("(지정 날짜 분리) ofDt.toLocalDate() = " + localDate);
        System.out.println("(지정 시간 분리) ofDt.toLocalTime() = " + localTime);

        // 3. 날자와 시간의 합체
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println("(지정 날짜 지정 시간 합체) LocalDateTime.of(localDate, localTime) = " + localDateTime);

        // 4. 계산(불변)
        LocalDateTime ofDtPlusDays = ofDt.plusDays(500);
        System.out.println("(지정 날짜&시간 +500d) ofDt.plusDays(500) = " + ofDtPlusDays);
        LocalDateTime ofDtPlusYears = ofDt.plusYears(20);
        System.out.println("(지정 날짜&시간 +20y) ofDt.plusYears(20) = " + ofDtPlusYears);

        // 5. 비교
        System.out.println("현재 날짜시간이 지정 날짜시간보다 이전인가? : " + nowDt.isBefore(ofDt));
        System.out.println("현재 날짜시간이 지정 날짜시간보다 이후인가? : " + nowDt.isAfter(ofDt));
        System.out.println("현재 날짜시간과 지정 날짜시간이 같은가? : " + nowDt.isEqual(ofDt));
    }
}
