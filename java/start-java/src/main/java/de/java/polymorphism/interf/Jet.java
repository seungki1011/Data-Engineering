package de.java.polymorphism.interf;

public class Jet extends Vehicle implements Fly, Move{ // Fly, Move 인터페이스 다중 구현
    @Override
    public void fillUp() {
        System.out.println("Filled up jet fuel.");
    }
    @Override
    public void showName() {
        System.out.println("This is a Jet.");
    }

    // 다중 구현으로 두 인터페이스 모두 구현
    @Override
    public void fly() {
        System.out.println("Jet will start to fly.");
    }
    @Override
    public void move() {
        System.out.println("The jet is moving.");
    }
}
