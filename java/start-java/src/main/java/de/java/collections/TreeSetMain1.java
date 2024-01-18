package de.java.collections;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person otherPerson) {
        if (this.age > otherPerson.age) {
            return 1;
        } else if (this.age == otherPerson.age) {
            return this.name.compareTo(otherPerson.name); // 만약 나이가 같으면 이름 비교
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return name + " is "+age+" years old.";
    }
}

public class TreeSetMain1 {
    public static void main(String[] args) {
        Set<Person> personSet = new TreeSet<>();

        // 1. 사람 추가
        personSet.add(new Person("Alice", 35));
        personSet.add(new Person("Bob", 17));
        personSet.add(new Person("Charlie", 25));
        personSet.add(new Person("David", 22));
        personSet.add(new Person("David", 12));
        personSet.add(new Person("Jessie", 35));
        personSet.add(new Person("Mark", 35));
        personSet.add(new Person("Andy", 25));
        personSet.add(new Person("Andy", 25)); // 중복된 요소는 추가되지 않음

        // 2. 각 요소 출력
        for (Person person : personSet) {
            System.out.println(person);
        }
    }
}
