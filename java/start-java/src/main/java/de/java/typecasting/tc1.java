package de.java.typecasting;

public class tc1 {
    public static void main(String[] args) {
        int intVal = 5;
        long longVal;
        double doubleVal;

        // 1. int 값을 long 그릇에 넣는 것은 가능
        longVal = intVal;
        System.out.println("longVal is " + longVal);

        // 2. int 값을 double 그릇에 넣는 것도 가능
        doubleVal = intVal;
        System.out.println("doubleVal is " + doubleVal);

        /*
        작은 범위를 큰 범위에 넣는 경우에는 자바가 자동으로 형변환을 해주기 때문에 다음과 같이
        명시적으로 형을 제시하지 않아도 된다.
        doubleVal = (double) intVal;
         */
    }
}
