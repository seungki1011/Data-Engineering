package de.java.polymorphism.polyusage;

public class Animal {
    private String name = "Animal";

    public void sound() {
        System.out.println("Generate Animal Sound!");
    }
    public void getName() {
        System.out.println("I'm a "+name+"!");
    }
}
