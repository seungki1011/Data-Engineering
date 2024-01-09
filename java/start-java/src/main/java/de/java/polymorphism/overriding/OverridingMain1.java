package de.java.polymorphism.overriding;

public class OverridingMain1 {
    public static void main(String[] args) {

        // 1. Parent 변수가 Parent 인스턴스 참조
        Parent parent = new Parent();
        System.out.println("1. Parent -> Parent");
        System.out.println("color = "+parent.color);
        System.out.println("value = "+parent.value);
        parent.commonMethod();
        System.out.println("------------------------");
        // 2. Child 변수가 Child 인스턴스 참조
        Child child = new Child();
        System.out.println("2. Child -> Child");
        System.out.println("color = "+child.color);
        System.out.println("value = "+child.value);
        child.commonMethod();
        System.out.println("------------------------");
        // 3. Parent 변수가 Child 인스턴스 참조 (다형적 참조)
        Parent poly = new Child();
        System.out.println("3. Parent -> Child");
        System.out.println("color = "+poly.color); // 변수의 경우 오버라이딩 안됨
        System.out.println("value = "+poly.value);
        poly.commonMethod(); // 메서드는 오버라이딩
    }
}
