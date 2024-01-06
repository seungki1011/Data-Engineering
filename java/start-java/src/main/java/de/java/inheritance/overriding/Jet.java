package de.java.inheritance.overriding;

public class Jet extends Aircraft {
    @Override // Aircraft의 fly()를 오버라이드
    public void fly() {
        System.out.println("This jet is currently flying!");
    }
    @Override // Vehicle의 brake()를 오버라이드
    public void brake() {
        System.out.println("This jet used the brake!");
    }
    public void fillFuel() {
        System.out.println("This jet is currently filling up fuel!");
    }
}
