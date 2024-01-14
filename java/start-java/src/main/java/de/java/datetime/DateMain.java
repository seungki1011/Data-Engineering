package de.java.datetime;

import java.util.Date;

public class DateMain {
    public static void main(String[] args) {

        Date date = new Date();
        System.out.println("new Date() = "+date); // 현재 시간

        // Epoch Time 기준으로 1 millisecond가 지남
        System.out.println("new Date(1) = "+(new Date(1)));

        // Epoch Time 기준으로 1 second가 지남
        System.out.println("new Date(1000) = "+(new Date(1000)));

        // 현재 시간 (date)이 Epoch Time 기준 1초 지난 시점 보다 이후가 맞기 때문에 -> true 반환
        System.out.println("new Date().after(new Date(1000)) = "+date.after(new Date(1000)));

        // 현재 시간(피연산자)이 파라미터로 넘긴 시간 보다 이후면 >0, 같으면 =1, 이전이면 <0
        System.out.println("new Date().compareTo(new Date(1000)) = "+new Date().compareTo(new Date(1000)));
        System.out.println("new Date(1000).compareTo(new Date()) = "+new Date(1000).compareTo(new Date()));

    }
}
