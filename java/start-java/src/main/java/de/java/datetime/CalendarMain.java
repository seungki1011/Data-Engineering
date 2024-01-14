package de.java.datetime;

import java.util.Calendar;
import java.util.Date;

public class CalendarMain {
    public static void main(String[] args) {
        // 1. get()으로 필드 가져오기
        // Calendar는 추상 클래스, 일반 클래스 처럼 인스턴스 생성 불가
        System.out.println("------------using get------------");
        Calendar calendar = Calendar.getInstance(); // Set to current date and time

        int currentYear = calendar.get(Calendar.YEAR); // Current Year
        int currentMonth = calendar.get(Calendar.MONTH) + 1; // Current Month (zero based calendar)
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        Date currentDateTime = calendar.getTime();

        System.out.println("몇 년: " + currentYear);
        System.out.println("몇 월:" + currentMonth);
        System.out.println("몇 일: " + dayOfMonth);

        System.out.println("getTime(): "+currentDateTime);

        // 2. set()으로 날짜와 시간 지정
        System.out.println("------------using set------------");
        Calendar date = Calendar.getInstance();
        date.set(2024, 0, 1); // 2024년 1(Jan)월 1알 로 설정 (Month는 0 부터 시작)
        System.out.println("date.set(2024, 0, 1): "+date.getTime());
        date.set(Calendar.YEAR, 2026); // 년을 2026으로 설정
        System.out.println("date.set(Calendar.YEAR, 2026): "+date.getTime());

        // 3. 필드 초기화
        System.out.println("------------using clear------------");
        date.clear(); // 1970-1-1 00:00:00 으로 초기화
        System.out.println("date.getTime() after date.clear(): "+date.getTime());
    }
}
