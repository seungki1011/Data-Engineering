package de.java.innerclass;

public class ExternalClass { // ExternalClass는 InnerClass의 외부 클래스
    String externalString = "This is a member of the External Class!";
    InternalClass internalClass = new InternalClass();
    class InternalClass { // 내부 클래스
        public void method() {
            System.out.println(externalString); // 객체 생성 없이 외부 클래스 멤버에 바로 접근 가능
        }
    }
}
