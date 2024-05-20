package de.generic.box;

public class GenericBoxMain {
    public static void main(String[] args) {

        GenericBox<Integer> integerBox = new GenericBox<Integer>();
        integerBox.setValue(100);
        // integerBox.setValue("one hundred"); // 제네릭을 통한 타입 안정성 제공
        Integer integerValue = integerBox.getValue();
        System.out.println("integerValue = " + integerValue);

        GenericBox<String> stringBox = new GenericBox<String>();
        stringBox.setValue("one hundred");
        String stringValue = stringBox.getValue();
        System.out.println("stringValue = " + stringValue);

        GenericBox<Double> doubleBox = new GenericBox<>(); // 제니릭 타입 생략 가능(타입 추론)
        doubleBox.setValue(99.9);
        Double doubleValue = doubleBox.getValue();
        System.out.println("doubleValue = " + doubleValue);

    }
}
