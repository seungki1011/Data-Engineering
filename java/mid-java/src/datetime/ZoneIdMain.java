package datetime;

import java.time.ZoneId;

public class ZoneIdMain {
    public static void main(String[] args) {

        // 1. 사용 가능한 타임존들 출력
        for (String availableZoneId : ZoneId.getAvailableZoneIds()) {
            ZoneId zoneId = ZoneId.of(availableZoneId);
            System.out.println(zoneId + " | " + zoneId.getRules());
        }

        // 2. 타임존 반환
        // 내 시스템이 사용하는 타임존
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("(시스템이 사용하는 기본 타임존) ZoneId.systemDefault() = " + zoneId);

        // 타임존을 제공해서 ZoneId 반환
        ZoneId seoulZoneId = ZoneId.of("Asia/Seoul");
        System.out.println("(타임존 직접 제공) ZoneId.of(\"Asia/Seoul\") = " + seoulZoneId);

    }
}
