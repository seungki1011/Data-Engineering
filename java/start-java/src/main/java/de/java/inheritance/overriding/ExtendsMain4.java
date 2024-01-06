package de.java.inheritance.overriding;

public class ExtendsMain4 {
    public static void main(String[] args) {
        Jet j1 = new Jet();
        j1.fly();
        j1.brake();

        Aircraft a1 = new Aircraft();
        a1.fly();
        a1.brake();

        Vehicle v1 = new Vehicle();
        v1.brake();
    }
}
