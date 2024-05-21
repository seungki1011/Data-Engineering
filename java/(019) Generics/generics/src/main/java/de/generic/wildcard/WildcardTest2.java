package de.generic.wildcard;

import de.generic.box.GenericBox;
import de.generic.constraint.Car;
import de.generic.constraint.Plane;
import de.generic.constraint.Vehicle;

public class WildcardTest2 {
    public static void main(String[] args) {

        GenericBox<Plane> planeBox = new GenericBox<>();

        planeBox.setValue(new Plane("F-22", 1000));

        // 상한 제한
        UpperBoundConstraint.printGeneric2(planeBox);
        UpperBoundConstraint.printWildcard2(planeBox);

    }
}
