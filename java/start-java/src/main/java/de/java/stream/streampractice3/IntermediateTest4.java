package de.java.stream.streampractice3;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateTest4 {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 20),
                new Person("David", 11)
        );

        // 1. Person 객체의 스트림을 나이를 기준으로 정렬하기
        List<Person> sortedByAge = people.stream()
                .sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .collect(Collectors.toList());
        sortedByAge.forEach(System.out::println);
        System.out.println();

        // 2. Person 객체의 스트림을 이름을 기준으로 정렬하기
        List<Person> sortedByName = people.stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .collect(Collectors.toList());
        sortedByName.forEach(System.out::println);
        System.out.println();

        // 3. 나이 역졍렬
        List<Person> revSortedByAge = people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());
        revSortedByAge.forEach(System.out::println);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " - " + age;
    }
}