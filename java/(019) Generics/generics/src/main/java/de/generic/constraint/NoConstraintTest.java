package de.generic.constraint;

public class NoConstraintTest {
    public static void main(String[] args) {

        VehicleCenter<Car> car = new VehicleCenter<>(new Car("K5", 100));
        VehicleCenter<Plane> plane = new VehicleCenter<>(new Plane("F-16", 500));

        car.check();
        plane.check();

        // Vehicle이 아닌 것도 타입에 들어갈 수 있는 문제
        VehicleCenter<String> string = new VehicleCenter<>("string value");
        string.check();

    }
}
