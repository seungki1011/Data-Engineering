package de.generic.wildcard;

import de.generic.box.GenericBox;
import de.generic.constraint.Vehicle;

public class UpperBoundConstraint {

    static <T extends Vehicle> void printGeneric2(GenericBox<T> box) {
        T t = box.getValue();
        System.out.println("이름 = " + t.getName());
    }

    // 상한 제한 와일드 카드
    static void printWildcard2(GenericBox<? extends Vehicle> box) {
        Vehicle vehicle = box.getValue();
        System.out.println("이름 = " + vehicle.getName());
    }

}
