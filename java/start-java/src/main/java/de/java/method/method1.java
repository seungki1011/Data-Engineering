package de.java.method;

public class method1 {
    public static void main(String[] args) {
        System.out.println("method result 1: " + avg(1,2));
        System.out.println("method result 2: " + avg(49,78));
        startMsg();
    }

    // 1. 정적(static) 메소드 정의
    public static double avg(int a, int b){ // 선언부
        return (double) (a+b)/2; // 구현부
    }
    // 2. 값을 반환 안하는 경우 void
    public static void startMsg(){
        System.out.println("This is a start message!");
    }
}
