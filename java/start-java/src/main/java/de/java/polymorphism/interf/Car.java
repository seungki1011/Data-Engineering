package de.java.polymorphism.interf;

public class Car extends Vehicle implements Move{ // Move 인터페이스 구현
    // Vehicle 클래스(부모 클래스)의 추상 메서드 구현(오버라이드)
    @Override
    public void fillUp() {
        System.out.println("Filled up gas.");
    }
    @Override
    public void showName() {
        System.out.println("This is a Car.");
    }

    // Move 인터페이스의 추상 메서드 구현
    @Override
    public void move() {
        System.out.println("The car is moving!");
    }
}
