package de.java.polymorphism;

public class UpCastMain1 {
    public static void main(String[] args) {
        // 1. 업캐스팅 - Parent는 Child를 담을 수 있음
        Child c = new Child();
        Parent p = (Parent) c;

        // 2. 업캐스팅은 캐스팅하는 과정 생략 가능
        Parent p1 = c; // 업캐스팅은 생략 권장

        p.parentMethod();
        p1.parentMethod();
    }
}
