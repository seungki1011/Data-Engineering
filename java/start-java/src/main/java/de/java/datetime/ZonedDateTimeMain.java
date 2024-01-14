package de.java.datetime;

import java.time.*;

public class ZonedDateTimeMain {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("Asia/Seoul");
        System.out.println("ZoneId.of(\"Asia/Seoul\") = "+zoneId); // Asia/Seoul

        // Create a ZonedDateTime for the current date and time in the system default time zone
        ZonedDateTime currentDateTime = ZonedDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);

        // Create a ZonedDateTime for a specific date and time in a specific time zone
        LocalDateTime localDateTime = LocalDateTime.of(2022, 1, 14, 12, 0);
        ZoneId zoneId2 = ZoneId.of("America/New_York");

        ZonedDateTime specificDateTime = ZonedDateTime.of(localDateTime, zoneId2);
        System.out.println("Specific Date Time in New York: " + specificDateTime);

        // Converting ZonedDateTime to another time zone
        ZoneId zoneId3 = ZoneId.of("Europe/London");
        ZonedDateTime londonDateTime = specificDateTime.withZoneSameInstant(zoneId3);
        System.out.println("Specific Date Time in London: " + londonDateTime);

        // Offset calculation
        System.out.println("----------offset calculation----------");
        ZoneOffset offset = ZoneOffset.of("+03:00"); // +3hrs
        System.out.println("LocalDateTime.of(2022, 1, 14, 12, 0) = "+localDateTime);
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, offset);
        System.out.println("OffsetDateTime.of(localDateTime, offset) = "+offsetDateTime);
    }
}
