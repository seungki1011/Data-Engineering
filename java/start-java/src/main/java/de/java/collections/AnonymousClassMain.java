package de.java.collections;

interface Greeting {
    void greet();
}

public class AnonymousClassMain {
    public static void main(String[] args) {
        // 익명 클래스 정의와 생성 (Greeting 인터페이스 구현)
        Greeting anonymousGreeting = new Greeting() {
            @Override
            public void greet() {
                System.out.println("Greetings from the anonymous class!");
            }
        };
        // 익명 클래스의 메서드 호출
        anonymousGreeting.greet();
    }
}
