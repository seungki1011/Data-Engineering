package de.java.polymorphism;

public class DownCastMain1 {
    public static void main(String[] args) {
        // Parent가 Child 참조 (부모 -> 자식)
        Parent p3 = new Child();
        // 자식 타입을 참조하더라도 자식의 메서드 호출은 불가
        // p3.childMethod();

        // 다운캐스팅으로 사용 가능
        Child c2 = (Child) p3;
        c2.childMethod(); // Child의 메서드 호출 가능
        c2.parentMethod();

    }
}
