package de.generic.constraint;

public class ConstraintTest {
    public static void main(String[] args) {

        ConstraintVehicleCenter<Car> car = new ConstraintVehicleCenter<>();
        ConstraintVehicleCenter<Plane> plane = new ConstraintVehicleCenter<>();

        car.setVehicle(new Car("K5", 100));
        plane.setVehicle(new Plane("F-16", 500));

        car.check();
        plane.check();

        // 제네릭의 타입 매개변수 제한으로 인해 Vehicle과 자손만 타입인자로 사용 가능
        // ConstraintVehicleCenter<String> string = new ConstraintVehicleCenter<>();
        // string.setVehicle("string value");
        // string.check();

    }
}
