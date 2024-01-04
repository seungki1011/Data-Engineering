package de.java.constant;

public class FinalMain2 {
    public static void main(String[] args) {
        System.out.println("1. 생성자를 이용한 멤버 변수 초기화");
        FinalConstructInit f1 = new FinalConstructInit(10);
        FinalConstructInit f2 = new FinalConstructInit(20);
        System.out.println(f2.finalIntValue);
        System.out.println("-----------------------------------");

        System.out.println("2. Field에서의 멤버 변수 초기화");
        FinalFieldInit f3 = new FinalFieldInit();
        System.out.println("finalInt = "+f3.finalInt);
        // FINAL_CONST는 static final이 붙은 녀석
        System.out.println("FINAL_CONST = "+FinalFieldInit.FINAL_CONST);
    }
}
