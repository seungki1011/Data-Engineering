package de.java.generics;

public class Box<T> {
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
