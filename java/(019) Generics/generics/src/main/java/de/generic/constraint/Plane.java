package de.generic.constraint;

public class Plane extends Vehicle{

    public Plane(String name, int size) {
        super(name, size);
    }

    public void move() {
        System.out.println("비행기는 나는 중.");
    }
}
