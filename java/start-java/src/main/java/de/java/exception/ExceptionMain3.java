package de.java.exception;

public class ExceptionMain3 {
    public static void main(String[] args) {
        // 1. getMessage() 사용 - e의 detailMessage 출력 (디버깅으로 확인해보면 알 수 있음)
        System.out.println("-------------------------------------");
        System.out.println(0);
        System.out.println(1);
        try {
            System.out.println(0/0);
        } catch (ArithmeticException e) {
            System.out.println("e.getMessage() : "+ e.getMessage());
        } catch (Exception e) {
            System.out.println("e.getMessage() : "+ e.getMessage());
        }
        System.out.println("-------------------------------------");
        // 2. printStackTrace() 사용 -
        try {
            System.out.println(0/0);
        } catch (ArithmeticException e) {
            e.printStackTrace(); // 에러 메세지를 그대로 보여줌. 보통 이런 메세지는 보여주지 말고 따로 로깅해서 확인해야함
        } catch (Exception e) {
            System.out.println("e.getMessage() : "+ e.getMessage());
        }
        System.out.println("-------------------------------------");
        System.out.println("Remaining Code");
    }
}
