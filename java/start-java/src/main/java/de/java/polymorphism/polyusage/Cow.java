package de.java.polymorphism.polyusage;

public class Cow extends Animal{
    private String name = "Cow";

    @Override
    public void sound() {
        System.out.println("Moo~");
    }

    @Override
    public void getName() {
        System.out.println("I'm a "+name+"!");
    }
}
