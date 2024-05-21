package de.generic.wildcard;

import de.generic.box.GenericBox;
import de.generic.constraint.Car;
import de.generic.constraint.Plane;
import de.generic.constraint.Vehicle;

public class WildcardTest3 {
    public static void main(String[] args) {

        GenericBox<Plane> planeBox = new GenericBox<>();

        planeBox.setValue(new Plane("F-22", 1000));

        // 명확한 타입 반환
        Plane plane = NeedTypeParameter.printAndReturnGeneric(planeBox);
        Vehicle vehicle = NeedTypeParameter.printAndReturnWildcard(planeBox);

    }
}
