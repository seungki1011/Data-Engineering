package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class FormatterMain {
    public static void main(String[] args) {

        // 1. 포맷팅(formatting) : format() 사용
        LocalDate ld = LocalDate.of(2024, 10, 11);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");

        String formattedDate = ld.format(formatter); // 포맷팅
        System.out.println("포맷팅 결과 : " + formattedDate);

        // 시간 까지 포함한 포맷팅
        LocalDateTime ldt = LocalDateTime.of(2024, 10, 11, 13, 30, 59);
        DateTimeFormatter formatterLdt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = ldt.format(formatterLdt);
        System.out.println("시간 까지 포함한 포맷팅 결과 : " + formattedDateTime);

        // 2. 파싱(parsing) : parse() 사용
        String inputDate = "2002년 04월 01일";
        LocalDate parsedDate = LocalDate.parse(inputDate, formatter);
        System.out.println("파싱 결과 : " + parsedDate);

        // 시간 까지 포함한 파싱
        String dateTimeString = "2022-04-01 17:30:30";
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeString, formatterLdt);
        System.out.println("시간 까지 포함한 파싱 결과 : " + parsedDateTime);

        // 3. ISO_DATE_TIME 패턴으로 포맷팅하기
        LocalDateTime localDateTime = LocalDateTime.of(2030, 1, 15, 9, 30);

        String localDateTimeString = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("LocalDateTime.of(2030, 1, 15, 9, 30) = " + localDateTime);
        System.out.println("ISO_DATE_TIME 포맷팅 결과 : " + localDateTimeString);

        // 4. MEDIUM, Locale.KOREA
        String formattedDateTime2 = localDateTime.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.KOREA)
        );

        System.out.println("MEDIUM, Locale.KOREA 포맷팅 결과 : " + formattedDateTime2);

    }
}
