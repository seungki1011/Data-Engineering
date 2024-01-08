package de.java.polymorphism.overriding;

public class Child extends Parent {
    public String color = "White";
    public String value = "Child Value";
    @Override
    public void commonMethod() {
        System.out.println("Child's commonMethod (Overrided)");
    }
    public void childMethod() {
        System.out.println("called childMethod");
    }
}
