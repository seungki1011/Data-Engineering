package de.java.datetime;

import java.time.*;
import java.util.Date;

public class InstantMain {
    public static void main(String[] args) {
        // 1. 두 Instant 사이 계산
        System.out.println("----------Calculate Two Instants----------");
        // Get the current instant
        Instant now = Instant.now();
        System.out.println("Current Instant: " + now);

        // sleep for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the instant after the operation
        Instant later = Instant.now();
        System.out.println("Later Instant: " + later);

        // Calculate the duration between two instants
        Duration duration = Duration.between(now, later);
        System.out.println("Duration: " + duration.getSeconds() + " seconds");

        // 2. Date -> LocalDate 변환
        System.out.println("------------Date to LocalDate-------------");
        // Get the current Date
        Date date = new Date();

        // Convert Date to Instant
        Instant instant = date.toInstant();

        // Convert Instant to LocalDate
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

        System.out.println("Date: " + date);
        System.out.println("LocalDate: " + localDate);

        // 3. LocalDateTime -> Date 변환
        System.out.println("-----------LocalDateTime to Date-----------");

        // Get the current LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();

        // Convert LocalDateTime to Date using Instant
        Instant instant2 = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date2 = Date.from(instant2); // from : Instant object -> Date object

        System.out.println("LocalDateTime: " + localDateTime);
        System.out.println("Date: " + date2);

    }
}
