package de.java.polymorphism.polyusage;

public class Dog extends Animal{
    private String name = "Dog";

    @Override
    public void sound() {
        System.out.println("Bow wow~");
    }

    @Override
    public void getName() {
        System.out.println("I'm a "+name+"!");
    }
}
