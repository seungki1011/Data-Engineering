package de.java.variable;

public class Var1 {
    public static void main(String[] args) {

        System.out.println(95);
        System.out.println("95");
        System.out.println("-----------------");

        // [access modifier] [data type] [variable name] 으로 선언 가능
        int a;
        a = 95;

        // 기존 변수 출력
        System.out.println(a);
        System.out.println(a);
        System.out.println("-----------------");

        // 변수 값 변경 후 출력
        a = 100;
        System.out.println(a);
        System.out.println(a);
        System.out.println("-----------------");

        // 변수의 선언과 초기화를 동시에
        int b = 33;
        System.out.println(b);
        System.out.println("-----------------");

        // 여러가지 변수의 선언과 초기화
        int c = 44, d = 55;
        System.out.println(c);
        System.out.println(d);
        System.out.println("-----------------");

        // ps. local variable 의 경우 직접 초기화를 진행해야함

    }
}
