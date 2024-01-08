package de.java.polymorphism;


public class PolyMain1 {
    public static void main(String[] args) {
        // 1. Parent 변수가 Parent 인스턴스 참조 (부모 -> 부모)
        System.out.println("1. Parent(p1)가 Parent 참조");
        Parent p1 = new Parent();
        System.out.print("p1.parentMethod() 실행 : ");
        p1.parentMethod();
        System.out.println("------------------------");
        // 2. Child 변수가 Child 인스턴스 참조 (자식 -> 자식)
        System.out.println("2. Child(c1)가 Child 참조");
        Child c1 = new Child();
        System.out.print("c1.childMethod() 실행 : ");
        c1.childMethod();
        System.out.print("c1.parentMethod() 실행 : ");
        c1.parentMethod();
        System.out.println("------------------------");
        // 3. Parent 변수가 Child 인스턴스 참조 (부모 -> 자식) (다형적 참조)
        System.out.println("3. Parent(p2)가 Child 참조");
        Parent p2 = new Child();
        System.out.print("p2.parentMethod() 실행 : ");
        p2.parentMethod();
        // p2는 Child 타입을 참조해도 Parent 타입이기 때문에 Parent 클래스의 메서드만 알고 있음
        // childMethod()를 실행시키고 싶은 경우 casting을 이용
        // p2.childMethod();
    }
}
