package de.generic.constraint;

public class ElectricCar extends Car implements CarInterface{
    public ElectricCar(String name, int size) {
        super(name, size);
    }

    @Override
    public void move() {
        System.out.println("전기차가 이동중.");
    }
}
