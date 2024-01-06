package de.java.inheritance.superconstructor;

public class ClassC extends ClassB {

    public ClassC() {
        // super(); // ClassB에는 기본 생성자가 존재하지 않기 때문에 super() 불가능
        super(1); // super()에 직접 값 넣어서 사용해야 함
    }
    public ClassC(int a) {
        super(a);
        System.out.println("-------------------------------------");
        System.out.println("ClassC 생성자 호출");
        System.out.println("ClassC, a = "+a);
    }

    public ClassC(int a, int b) {
        super(a, b);
        System.out.println("-------------------------------------");
        System.out.println("ClassC 생성자 호출");
        System.out.println("ClassC, a = "+a+", b = "+b);
    }
    public ClassC(int a, int b, int c) {
        super(a, b);
        System.out.println("-------------------------------------");
        System.out.println("ClassC 생성자 호출");
        System.out.println("ClassC, a = "+a+", b = "+b+", c = "+c);
    }
}
