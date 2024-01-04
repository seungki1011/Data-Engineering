package de.java.constant;

public class FinalMain1 {
    public static void main(String[] args) {
        final String finalString = "This is a string value made with final";
        // 한번만 할당 가능, 새롭게 할당 시도하면 컴파일 오류
        // FINAL_STRING = "Assigning to a new value for a final variable is impossible";
        System.out.println(finalString);

        final int finalInt = 20;
        System.out.println(finalInt);

        finalMethod1(500);
    }
    static void finalMethod1(final int finalParameter) {
        System.out.println("This is the parameter passed to the method: "+finalParameter);
        // final이 붙은 파라미터는 메서드 내부에서 변경, 할당 불가
        // finalParameter = 30;
    }
}
