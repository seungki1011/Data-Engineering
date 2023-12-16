package de.java.operators;

public class Op1 {
    public static void main(String[] args) {

        int a = 20;
        int b = 10;
        int c = 7;

        // addition
        int add = a + b;
        System.out.println("a + b = " + add);

        // subtraction
        int sub = a - b;
        System.out.println("a - b = " + sub);

        // multiplication
        int mul = a * b;
        System.out.println("a * b = " + mul);

        // division
        int div = a - b;
        System.out.println("a / b = " + div);

        // remainder operation
        // 나머지가 0 인경우
        int rem1 = a % b;
        System.out.println("a % b = " + rem1);

        // 나머지가 0이 아닌 경우
        int rem2 = a % c;
        System.out.println("a % c = " + rem2);

    }
}
