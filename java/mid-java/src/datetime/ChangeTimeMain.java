package datetime;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class ChangeTimeMain {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.of(2022, 3, 10, 15, 20, 59);
        System.out.println("LocalDateTime.of(2022, 3, 10, 15, 20, 59) = " + ldt);

        LocalDateTime plusLdt1 = ldt.plus(10, ChronoUnit.YEARS);
        System.out.println("ldt.plus(10, ChronoUnit.YEARS) = " + plusLdt1); // +10years

        // 편의 메서드
        LocalDateTime plusLdt2 = ldt.plusYears(10);
        System.out.println("ldt.plusYears(10) = " + plusLdt2); // +10years

        // Period 이용
        Period period = Period.ofYears(10);
        LocalDateTime plusLdt3 = ldt.plus(period);
        System.out.println("ldt.plus(Period.ofYears(10)) = " + plusLdt3);

    }
}
