package de.java.polymorphism;

public class TempCastMain1 {
    public static void main(String[] args) {
        Parent p4 = new Child();

        // 1. 기존 다운캐스팅
        Child c3 = (Child) p4;
        c3.childMethod();

        // 2. 일시적 다운캐스팅
        ((Child) p4).childMethod(); // p4를 Child 타입으로 일시 다운캐스팅
    }
}
