package de.java.enumpractice;

public class EnumMain {
    public static void main(String[] args) {
        DaysOfWeek today = DaysOfWeek.WEDNESDAY;
        System.out.println("Today is day " + today.getDayValue());
    }
}
