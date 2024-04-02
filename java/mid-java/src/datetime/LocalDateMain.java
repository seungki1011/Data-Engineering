package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class LocalDateMain {
    public static void main(String[] args) {

        // 1. LocalDate 객체
        // now() : 현재 날짜의 LocalDate 객체
        LocalDate nowDate = LocalDate.now();
        // of() : 년, 월, 일을 설정한 객체
        LocalDate ofDate = LocalDate.of(2023, 8, 4);

        System.out.println("(현재 날짜) LocalDate.now()  = " + nowDate);
        System.out.println("(지정 날짜) LocalDate.of(2024, 2, 4) = " + ofDate);

        // 2. 계산(불변) - 객체를 반환함
        // 일 단위로 더하기
        LocalDate plusDays = ofDate.plusDays(10);
        System.out.println("(지정 날짜 +10d) ofDate.plusDays(10) = " + plusDays);
        // 년 단위로 더하기
        LocalDate plusYears = ofDate.plusYears(5);
        System.out.println("(지정 날짜 +5y) ofDate.plusYears(5) = " + plusYears);
        // 월 단위로 빼기
        LocalDate minusMonths = ofDate.minusMonths(7);
        System.out.println("(지정 날짜 -7m) ofDate.minusMonths(7) = " + minusMonths);

        // 3. 요일 찾기
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek(); // 현재 날짜의 요일
        System.out.println("(현재 날짜의 요일) LocalDate.now().getDayOfWeek() = "+dayOfWeek);

    }
}
