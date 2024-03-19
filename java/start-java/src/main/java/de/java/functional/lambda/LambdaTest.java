package de.java.functional.lambda;

public class LambdaTest {
    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();

        // 1. 함수령 인터페이스 타입의 참조 변수 사용
        MyInterface2 mI = ()-> System.out.println("call method()");
        lambdaTest.aMethod(mI);

        // 2. 람다식을 직접 넣어서 사용
        lambdaTest.aMethod(()-> System.out.println("call method()"));
    }

    void aMethod(MyInterface2 f) {
        f.method();
    }
}
