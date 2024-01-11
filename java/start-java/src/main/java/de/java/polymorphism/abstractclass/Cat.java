package de.java.polymorphism.abstractclass;

public class Cat extends Animal {
    private String name = "Cat";

    @Override
    public void makeSound() {
        System.out.println("Meow~");
    }
}
