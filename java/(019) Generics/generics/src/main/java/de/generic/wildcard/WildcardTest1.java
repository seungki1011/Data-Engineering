package de.generic.wildcard;

import de.generic.box.GenericBox;
import de.generic.constraint.Car;
import de.generic.constraint.Plane;
import de.generic.constraint.Vehicle;

public class WildcardTest1 {
    public static void main(String[] args) {

        GenericBox<Object> objBox = new GenericBox<>();
        GenericBox<Plane> planeBox = new GenericBox<>();
        GenericBox<Car> carBox = new GenericBox<>();

        planeBox.setValue(new Plane("F-22", 1000));

        // 비제한
        NoConstraint.printGeneric1(planeBox);
        NoConstraint.printWildcard1(planeBox);

    }
}
