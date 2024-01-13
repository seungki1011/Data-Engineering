package de.java.exception;

public class ExceptionMain2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        // 1. Exception의 배치
        try {
            System.out.println(0);
            System.out.println(1);
            System.out.println(2);
            System.out.println(array[5]); // ArrayIndexOutOfBoundException이지만 그냥 Exception으로 처리할 예정
            // 어차피 위에서 예외가 발생하기 때문에 아래 코드는 실행되지 않는다
            System.out.println(4);
            System.out.println(5);
            System.out.println(0/0);
        } catch (ArithmeticException ae) {
            System.out.println("ArithmeticException 발생!");
        } catch (Exception e) { // 위의 catch 블럭에서 예외를 걸러내지 못해도 가장 아래에서 가장 상위인 Exception으로 예외를 처리
            System.out.println("Exception 발생!");
        }
        System.out.println("---------------------------");

        // 2. Exception을 가장 위에 배치하는 경우
        try {
            System.out.println(0);
            System.out.println(1);
            System.out.println(2);
            System.out.println(0/0); // ArithmeticException
            System.out.println(3);
        } catch (Exception e) { // Exception을 가장 상위에 배치하면 여기서 모든 예외가 처리되어 버린다
            System.out.println("Exception 발생!");
        }
        // 어차피 Exception을 가장 상위에 쓰면 더 낮은 계층의 Exception을 아래에 배치하면 컴파일 에러 발생
        // error: exception java.lang.ArithmeticException has already been caught
        // catch (ArithmeticException ae) { // 실제 발생한 것은 ArithmeticException이지만 위에서 걸러져버림
            // System.out.println("ArithmeticException 발생!");
        // }
    }
}
