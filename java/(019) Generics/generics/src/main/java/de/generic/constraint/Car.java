package de.generic.constraint;

public class Car extends Vehicle{

    public Car(String name, int size) {
        super(name, size);
    }

    @Override
    public void move() {
        System.out.println("자동차는 달리는 중.");
    }
}
