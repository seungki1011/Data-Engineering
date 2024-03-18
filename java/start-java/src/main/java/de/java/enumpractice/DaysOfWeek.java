package de.java.enumpractice;

public enum DaysOfWeek {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private final int dayValue;

    DaysOfWeek(int dayValue) {
        this.dayValue = dayValue;
    }

    public int getDayValue() {
        return dayValue;
    }
}

