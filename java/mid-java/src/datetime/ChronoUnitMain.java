package datetime;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ChronoUnitMain {
    public static void main(String[] args) {
        // ChronoUnit 단위 출력
        ChronoUnit[] chronoUnits = ChronoUnit.values();
        for (ChronoUnit chronoUnit : chronoUnits) {
            System.out.println("chronoUnit = " + chronoUnit);
        }

        System.out.println("ChronoUnit.HOURS.getDuration() = " + ChronoUnit.HOURS.getDuration());
        System.out.println("ChronoUnit.HOURS.getDuration().getSeconds() = " + ChronoUnit.HOURS.getDuration().getSeconds());

        System.out.println("ChronoUnit.DAYS.getDuration() = " + ChronoUnit.DAYS.getDuration());
        System.out.println("ChronoUnit.DAYS.getDuration().getSeconds() = " + ChronoUnit.DAYS.getDuration().getSeconds());

        // 차이
        LocalTime lt1 = LocalTime.of(1, 10, 0);
        LocalTime lt2 = LocalTime.of(1, 20, 30);

        long secBetween = ChronoUnit.SECONDS.between(lt1, lt2);
        System.out.println("ChronoUnit.SECONDS.between(lt1, lt2) = " + secBetween);

        long minBetween = ChronoUnit.MINUTES.between(lt1, lt2);
        System.out.println("ChronoUnit.MINUTES.between(lt1, lt2) = " + minBetween);
    }
}
