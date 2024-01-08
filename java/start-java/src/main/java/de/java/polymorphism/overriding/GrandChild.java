package de.java.polymorphism.overriding;

public class GrandChild extends Child {
    public String color = "Silver";
    public String value = "GrandChild Value";
    @Override
    public void commonMethod() {
        System.out.println("GrandChild's commonMethod (Overrided)");
    }
    public void grandChildMethod() {
        System.out.println("called grandChildMethod");
    }
}
