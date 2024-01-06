package de.java.inheritance.extend1;

public class ExtendsMain1 {
    public static void main(String[] args) {
        ElectricCar e1 = new ElectricCar();
        e1.move();
        e1.charge();

        GasCar g1 = new GasCar();
        g1.move();
        g1.fillUp();
    }
}
