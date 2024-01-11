package de.java.polymorphism.abstractclass;

public class Dog extends Animal {
    private String name = "Dog";

    @Override
    public void makeSound() { System.out.println("Bow Wow~"); }

    // 추상 메서드가 아니어도 오버라이드하는 경우
    @Override
    public void move() {
        System.out.println("Dog is moving! (Overrided)");
    }
}
