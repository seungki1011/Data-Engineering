package de.java.polymorphism;

public class DownCastMain2 {
    public static void main(String[] args) {

        Parent p = new Parent();
        Child c = (Child) p; // 다운 캐스팅 - 런타임 오류 발생
        c.childMethod();

        // 런타입 오류 발생
        // Exception in thread "main" java.lang.ClassCastException: de.java.polymorphism.Parent cannot be cast to de.java.polymorphism.Child
        //	at de.java.polymorphism.DownCastMain2.main(DownCastMain2.java:7)
    }
}
