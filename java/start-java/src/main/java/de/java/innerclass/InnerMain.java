package de.java.innerclass;

public class InnerMain {
    public static void main(String[] args) {
        ExternalClass externalClass = new ExternalClass(); // 외부 클래스의 객체를 먼저 생성해야 내부클래스의 객체 생성해서 사용가능
        ExternalClass.InternalClass internalClass = externalClass.new InternalClass();

        System.out.println("externalClass.externalString = "+externalClass.externalString);
        System.out.print("internalClass.method() 실행 : ");
        internalClass.method();
    }
}
