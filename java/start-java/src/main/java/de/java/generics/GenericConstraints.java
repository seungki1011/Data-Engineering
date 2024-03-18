package de.java.generics;

import java.util.ArrayList;

public class GenericConstraints {
    public static void main(String[] args) {

        Person2<Parent> p1 = new Person2<Parent>();
        Person2<Child> p2 = new Person2<Child>(); // Child는 Parent의 자손이기 때문에 가능

    }
}

class Person2<T extends Parent>{ // Parent의 자손 타입만 지정 가능
    ArrayList<T> list = new ArrayList<>();
}

class Parent {
    String name = "Parent Class";
    Integer age = 28;

    public Parent(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}

class Child extends Parent {
    String name = "Child Class is the subclass of Parent";
    Integer age = 5;

    public Child(String name, Integer age, String name1, Integer age1) {
        super(name, age);
        this.name = name1;
        this.age = age1;
    }
}