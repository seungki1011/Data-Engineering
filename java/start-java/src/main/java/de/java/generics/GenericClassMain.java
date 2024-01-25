package de.java.generics;

class Box<T> { // 타입 파라미터 'T'로 설정
    private T value;

    public Box(T value) {
        this.value = value;
    }

    // Getter and Setter
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    // value의 type을 출력하는 메서드
    public void printValueType() {
        System.out.println("Type of value: "+value.getClass().getName());
    }
}

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
