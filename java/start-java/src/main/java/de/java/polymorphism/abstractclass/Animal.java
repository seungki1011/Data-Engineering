package de.java.polymorphism.abstractclass;

public abstract class Animal { // 추상 클래스는 abstract

    // 1. 추상 메서드는 상속 받는 자식에서 override으로 구현
    public abstract void makeSound(); // 추상 메서드는 구현 x

    // 2. 추상 메서드가 아니면 그냥 상속 받아서 사용 가능
    public void move() {
        System.out.println("Currently moving!");
    }
}
