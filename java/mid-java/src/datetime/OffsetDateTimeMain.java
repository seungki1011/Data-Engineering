package datetime;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class OffsetDateTimeMain {
    public static void main(String[] args) {

        OffsetDateTime nowOdt = OffsetDateTime.now();
        System.out.println("OffsetDateTime.now() = " + nowOdt);

        LocalDateTime ldt = LocalDateTime.of(2030, 1, 1, 13, 30, 50);
        System.out.println("LocalDateTime.of(2030, 1, 1, 13, 30, 50) = " + ldt);

        OffsetDateTime odt = OffsetDateTime.of(ldt, ZoneOffset.of("+01:00"));
        System.out.println("OffsetDateTime.of(ldt, ZoneOffset.of(\"+01:00\")) = " + odt);

    }
}
