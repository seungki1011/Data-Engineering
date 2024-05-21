package de.generic.genericmethod;

import de.generic.constraint.Vehicle;


public class GenericMethodClass2<T> {
    private T value;

    public static <V extends Vehicle> V staticGenericMethod1(V v) {
        //...
        return v;
    }
    public <T extends Number> T instanceGenericMethod(T z) {
        //...
        return z;
    }
    public T instanceGenericMethod2(T u) {
        //...
        return null;
    }

    // public static T staticGenericMethod2(T z) { return null; }
}


