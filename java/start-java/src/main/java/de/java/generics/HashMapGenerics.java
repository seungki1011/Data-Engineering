package de.java.generics;

import java.util.HashMap;

public class HashMapGenerics {
    public static void main(String[] args) {

        HashMap<String, Person> hashMap = new HashMap<>(); // 타입 지정 생략 가능
        hashMap.put("personA", new Person("ksk", "male", 28));
        hashMap.put("personB", new Person("messi", "male", 40));

        System.out.println(hashMap.get("personA"));
        System.out.println(hashMap.get("personA").name);

        System.out.println("------------------------");

        Person person = hashMap.get("personB");
        System.out.println(person);
        System.out.println(person.name);
    }
}


class Person {
    String name = "";
    String gender = "";
    Integer age;

    public Person(String name, String gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}