package datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeMain {
    public static void main(String[] args) {

        // 1. ZonedDateTime 객체
        ZonedDateTime nowZdt = ZonedDateTime.now();
        System.out.println("(현재 ZDT) ZonedDateTime.now() = " + nowZdt);

        // LocalDateTime 객체를 이용해서 ZonedDateTime 생성
        LocalDateTime ldt = LocalDateTime.of(2030, 1, 1, 13, 30, 50); // 지정 LocalDateTime
        ZonedDateTime zdt1 = ZonedDateTime.of(ldt, ZoneId.of("Asia/Seoul"));
        System.out.println("(지정 ZDT) ZonedDateTime.of(ldt, ZoneId.of(\"Asia/Seoul\")) = " + zdt1);

        // 바로 ZonedDateTime 생성
        ZonedDateTime zdt2 = ZonedDateTime.of(2030, 1, 1, 13, 30, 50, 0, ZoneId.of("Asia/Seoul"));
        System.out.println("ZonedDateTime.of(2030, 1, 1, 13, 30, 50, 0, ZoneId.of(\"Asia/Seoul\")) = " + zdt2);

        // 2. 타임존 변경 - 타임존에 맞춰서 시간도 함께 변경
        ZonedDateTime utcZdt = zdt2.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println("(UTC 타임존으로 변경) zdt2.withZoneSameInstant(ZoneId.of(\"UTC\")) = " + utcZdt);

    }
}
