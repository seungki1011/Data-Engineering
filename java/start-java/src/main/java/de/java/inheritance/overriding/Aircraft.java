package de.java.inheritance.overriding;

public class Aircraft extends Vehicle {
    public void fly() {
        System.out.println("This aircraft is currently flying!");
    }
    @Override // Vehicle의 brake()를 오버라이드
    public void brake() {
        System.out.println("This aircraft used the brake!");
    }
}
