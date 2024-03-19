package de.java.functional.methodreference;

import java.util.Arrays;
import java.util.List;

public class MethodRefTest {
    public static void main(String[] args) {

        List<String> fruitList = Arrays.asList("Apple", "Grape", "Strawberry");

        System.out.println("--1. 람다식 사용--");
        fruitList.forEach(x -> System.out.println(x));
        System.out.println("--2. 메서드 참조 사용--");
        fruitList.forEach(System.out::println);
    }
}
