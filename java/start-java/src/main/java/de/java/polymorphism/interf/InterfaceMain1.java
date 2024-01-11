package de.java.polymorphism.interf;

public class InterfaceMain1 {
    public static void main(String[] args) {
        Vehicle[] vehicleArray = {new Car(), new ElectricPlane(), new Jet()};
        for (Vehicle vehicle : vehicleArray) {
            action(vehicle);
            if (vehicle instanceof Fly) {
                startFly((Fly) vehicle);
            }
            if (vehicle instanceof Move) {
                startMove((Move) vehicle);
            }
            vehicle.useHonk();
        }
    }

    private static void action(Vehicle vehicle) {
        System.out.println("--------Start Action--------");
        vehicle.showName();
        vehicle.fillUp();
    }
    private static void startFly(Fly fly) {
        fly.fly();
    }
    private static void startMove(Move move) {
        move.move();
    }
}
