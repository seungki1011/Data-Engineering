package datetime;

import java.time.LocalTime;

public class LocalTimeMain {
    public static void main(String[] args) {

        // 1. LocalTime 객체
        LocalTime nowTime = LocalTime.now();
        LocalTime ofTime = LocalTime.of(9, 10, 30);

        System.out.println("(현재 시간) LocalTime.now() = " + nowTime);
        System.out.println("(지정 시간) LocalTime.of(9, 10, 30) = " + ofTime);

        // 2. 계산(불변) - 객체 반환 함
        LocalTime ofSecondPlus = ofTime.plusSeconds(10);
        System.out.println("(지정 시간 +10s) ofTime.plusSeconds(10) = " + ofSecondPlus);
        LocalTime ofHourPlus = ofTime.plusHours(2);
        System.out.println("(지정 시간 +2hr) ofTime.plusHours(2) = " + ofHourPlus);

    }
}
