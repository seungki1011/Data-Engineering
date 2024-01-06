package de.java.inheritance.superconstructor;

public class ClassB extends ClassA{
    public ClassB(int a) {
        super(); // 기본 생성자 생략 가능, 원래는 첫줄에서 부모의 생성자를 호출해야 함
        System.out.println("-------------------------------------");
        System.out.println("ClassB 생성자 호출");
        System.out.println("ClassB, a = "+a);
    }

    public ClassB(int a, int b) {
        super();
        System.out.println("-------------------------------------");
        System.out.println("ClassB 생성자 호출");
        System.out.println("ClassB, a = "+a+", b = "+b);
    }
}