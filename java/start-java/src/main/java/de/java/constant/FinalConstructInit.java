package de.java.constant;

public class FinalConstructInit {
    final int finalIntValue;

    // final이 붙은 멤버변수를 필드에서 초기화하지 않은 경우 생성자를 통해서 초기화
    public FinalConstructInit(int finalIntValue) {
        this.finalIntValue = finalIntValue;
        System.out.println("Final Value Initialized using Constructor: "+this.finalIntValue);
    }
}
