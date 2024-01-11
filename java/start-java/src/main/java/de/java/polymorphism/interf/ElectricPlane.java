package de.java.polymorphism.interf;

public class ElectricPlane extends Vehicle implements Fly, Move{
    @Override
    public void fillUp() {
        System.out.println("Charging battery.");
    }
    @Override
    public void showName() {
        System.out.println("This is a Electric Plane");
    }

    @Override
    public void fly() {
        System.out.println("The electric plane will start to fly.");
    }
    @Override
    public void move() {
        System.out.println("The electric plane is moving.");
    }
}
