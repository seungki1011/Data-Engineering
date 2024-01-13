package de.java.exception;

public class ExceptionMain1 {
    public static void main(String[] args) {

        // 1. Arithmetic Exception
        System.out.println(1);
        try {
            System.out.println(2/0);
        } catch (ArithmeticException e) { // 0으로 나눌 시 발생
            System.out.println("--------------Exception--------------");
            System.out.println("Wrong Calculation!");
            System.out.println("Arithmetic Exception has occurred.");
            System.out.println("-------------------------------------");
        }
        System.out.println(3);
        System.out.println(4);

        // 2. ArrayIndexOutOfBounds Exception
        int[] array = {1, 2, 3, 4};

        try {
            System.out.println(array[4]); // 배열의 범위를 벗어난 경우 ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("--------------Exception--------------");
            System.out.println("Tried to approach non-existing array index!");
            System.out.println("ArrayIndexOutOfBoundsException has occurred.");
            System.out.println("-------------------------------------");
        }

        // 3. try 블럭 내에 예외 발생 후 흐름
        try {
            System.out.println(1);
            System.out.println(0/0); // 여기서 예외 발생 -> 바로 catch 블럭으로 넘어감
            // 예외 발생 후 나머지 try 블럭 내의 코드는 실행되지 않음
            System.out.println(2);
            System.out.println(3);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception has occurred.");
            System.out.println("try 블럭 안에서 예외 발생 하면 바로 catch 블럭으로 넘어감");
            System.out.println("try 블럭의 남은 코드는 실행되지 않는다.");
        }
        System.out.println(4);

        // 4. 예외 처리가 안되는 경우
        try {
            System.out.println(0/0); // 예외 발생
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("This is a ArrayIndexOutOfBoundsException");
        }
        System.out.println("This part is outside of the try-catch statement");
        // 맞는 예외를 처리할 수 있는 catch 블럭이 없기 때문에 예외는 처리되지 않는다
        // Exception in thread "main" java.lang.ArithmeticException: / by zero
        //	at de.java.exception.ExceptionMain1.main(ExceptionMain1.java:47)
    }
}
