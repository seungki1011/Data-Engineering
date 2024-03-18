package de.java.generics;

public class GenericConstraintTest {
    public static void main(String[] args) {

        Box<Integer> integerBox = new Box<>(100); // Integer 객체만 저장 가능
        Box<String> stringBox = new Box<>("My name is stringBox"); // String 객체만 저장가능

        System.out.println(integerBox.getValue());
        System.out.println(integerBox.getValue().getClass());
        System.out.println("-------------------------");
        System.out.println(stringBox.getValue());
        System.out.println(stringBox.getValue().getClass());

    }
}
