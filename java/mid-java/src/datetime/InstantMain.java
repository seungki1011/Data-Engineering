package datetime;

import java.time.*;

public class InstantMain {
    public static void main(String[] args) {

        // 객체 생성
        Instant now = Instant.now(); //UTC 기준
        System.out.println("Instant.now() = " + now);

        ZonedDateTime zdt = ZonedDateTime.now();
        Instant from = Instant.from(zdt);
        System.out.println("Instant.from(ZonedDateTime.now()) = " + from);

        // Epoch time 시작 지점
        Instant epochStart = Instant.ofEpochSecond(0);
        System.out.println("Instant.ofEpochSecond(0) = " + epochStart);

        // 계산
        Instant later = epochStart.plusSeconds(3600); // 1시간 후
        System.out.println("epochStart.plusSeconds(3600) = " + later);

        // 조회
        long laterEpochSecond = later.getEpochSecond();
        System.out.println("epochStart.plusSeconds(3600).getEpochSecond() = " + laterEpochSecond);

        // Instant -> ZonedDateTime -> LocalDate 변환
        // Instant -> LocalDateTime으로 바로 변환하는 것은 불가
        LocalDate localDate = Instant.now()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        System.out.println("현재 Instant -> LocalDate 변환 : " + localDate);

        // LocalDateTime -> ZonedDateTime -> Instant 변환
        LocalDateTime localDateTime = LocalDateTime.now();
        Instant instant = localDateTime
                .atZone(ZoneId.systemDefault())
                .toInstant();
        System.out.println("현재 LocalDateTime -> Instant 변환 : " + instant);
    }
}
