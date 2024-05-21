package de.generic.wildcard;

import de.generic.box.GenericBox;
import de.generic.constraint.Car;
import de.generic.constraint.Plane;
import de.generic.constraint.Vehicle;

public class LowerBoundTest {
    public static void main(String[] args) {
        GenericBox<Object> objBox = new GenericBox<>();
        GenericBox<Vehicle> vehicleBox = new GenericBox<>();
        GenericBox<Plane> planeBox = new GenericBox<>();
        GenericBox<Car> carBox = new GenericBox<>();

        // Vehicle을 포함한 상위 타입 전달 가능
        writeBox(objBox);
        writeBox(vehicleBox);

        Vehicle vehicle = vehicleBox.getValue();
        System.out.println("vehicle = " + vehicle);

    }

    static void writeBox(GenericBox<? super Vehicle> box) {
        box.setValue(new Car("k5", 200));
    }
}
