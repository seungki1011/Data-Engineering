package de.generic.wildcard;

import de.generic.box.GenericBox;
import de.generic.constraint.Vehicle;

public class NeedTypeParameter {

    static <T extends Vehicle> T printAndReturnGeneric(GenericBox<T> box) {
        T t = box.getValue();
        System.out.println("이름 = " + t.getName());
        return t;
    }

    static Vehicle printAndReturnWildcard(GenericBox<? extends Vehicle> box) {
        Vehicle vehicle = box.getValue();
        System.out.println("이름 = " + vehicle.getName());
        return vehicle;
    }
}
