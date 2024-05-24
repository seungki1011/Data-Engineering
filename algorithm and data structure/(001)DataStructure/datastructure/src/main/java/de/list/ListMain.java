package de.list;

import java.util.ArrayList;
import java.util.List;

public class ListMain {
    public static void main(String[] args) {

        // ArrayList 생성
        List<String> fruits = new ArrayList<>();

        // 요소 추가
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Grape");
        fruits.add("Mango");

        // 특정 인덱스에 요소 추가
        fruits.add(2, "Blueberry");

        // 출력
        printList(fruits);

        // 요소 반환
        System.out.println("fruits.get(3) = " + fruits.get(3));

        // ArrayList의 크기
        System.out.println("fruits.size() = " + fruits.size());

        // 요소 제거
        fruits.remove("Apple");
        fruits.remove("Mango");
        printList(fruits);

        // 특정 요소 포함 여부
        String searchFruit = "Grape";
        if(fruits.contains(searchFruit)) {
            System.out.println("The list contains " + searchFruit);
        } else {
            System.out.println("Could not find " + searchFruit);
        }
    }

    private static void printList(List arrayList) {
        System.out.println("-----printList-----");
        for (Object object : arrayList) {
            System.out.println(object);
        }
        System.out.println("-------------------");
    }

}
