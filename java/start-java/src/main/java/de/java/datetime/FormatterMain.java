package de.java.datetime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class FormatterMain {
    public static void main(String[] args) {
        // Creating a LocalDateTime instance for January 25, 2022, at 6:30 AM
        LocalDateTime localDateTime = LocalDateTime.of(2030, Month.JANUARY, 15, 9, 30);

        // Formatting the LocalDateTime using ISO_DATE pattern
        String localDateString = localDateTime.format(DateTimeFormatter.ISO_DATE);

        // Formatting the LocalDateTime using a localized pattern with Medium style and Korean locale
        String formattedDateTime = localDateTime.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.KOREA)
        );

        System.out.println("Before Format : "+localDateTime);
        System.out.println("After Format : "+formattedDateTime);

    }
}
