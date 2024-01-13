package de.java.exception;

public class ExceptionMain4 {
    public static void main(String[] args) {

        try {
            // 예외의 객체 생성(예외 생성)
            Exception e = new Exception("고의 Exception(This is the message)"); // 예외의 detailMessage
            throw e; // throw로 예외 발생
            // throw new Exception("Exception was made(This is the message)"); // 한줄로 표현
        } catch (Exception e) {
            System.out.println("e.getMessage : "+e.getMessage());
        }
    }
}
