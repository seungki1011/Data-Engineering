package de.java.polymorphism.overriding;

public class Parent {
    public String color = "Yellow";
    public String value = "Parent Value";
    public void commonMethod() {
        System.out.println("Parent's commonMethod");
    }
    public void parentMethod() {
        System.out.println("called parentMethod");
    }
}
