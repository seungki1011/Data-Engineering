package de.java.typecasting;

public class tc2 {
    public static void main(String[] args) {
        int intVal;
        long longVal;
        double doubleVal = 10.345;

        // intVal = doubleVal; 명시적 형변환을 하지 않으면 컴파일 에러 발생
        intVal = (int) doubleVal;

        System.out.println("Original doubleVal is " + doubleVal);
        System.out.println("Value after type casting to int is " + intVal);
    }
}
