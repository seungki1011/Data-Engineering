package de.java.polymorphism.polyusage;

public class Cat extends Animal{
    private String name = "Cat";

    @Override
    public void sound() {
        System.out.println("Meow~");
    }

    @Override
    public void getName() {
        System.out.println("I'm a "+name+"!");
    }
}
