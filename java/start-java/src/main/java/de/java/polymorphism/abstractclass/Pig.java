package de.java.polymorphism.abstractclass;

public class Pig extends Animal {
    private String name = "Pig";
    // 추상 클래스에서 정의한 추상 메서드는 무저건 오버라이드해서 구현해야 함
    @Override
    public void makeSound() {
        System.out.println("Oink~");
    }
}
