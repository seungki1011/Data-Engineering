package de.java.functional.lambda;

public class LambdaTest2 {
    public static void main(String[] args) {
        // 1. 익명 클래스의 선언과 객체 생성을 동시
        MyInterface myInterface = new MyInterface() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };

        int i = myInterface.max(10, 20);
        System.out.println(i);

        // 2. 람다식 사용해보기
        MyInterface l = (a, b) -> a > b ? a : b;

        int value = l.max(10, 20);
        System.out.println(value);
    }
}
