package de.java.generics;

public class GenericClassMain {
    public static void main(String[] args) {
        // 1. Create Box for Integer
        System.out.println("----------Integer Box----------");
        Box<Integer> intBox = new Box<>(50);
        intBox.printValueType();
        System.out.println("Box value: "+ intBox.getValue());

        // 2. Create Box for String
        System.out.println("-----------String Box----------");
        Box<String> stringBox = new Box<>("This is a string!");
        stringBox.printValueType();
        System.out.println("Box value: "+ stringBox.getValue());
    }
}