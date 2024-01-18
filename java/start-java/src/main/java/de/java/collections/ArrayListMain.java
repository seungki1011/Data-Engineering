package de.java.collections;

import java.util.ArrayList;

public class ArrayListMain {
    public static void main(String[] args) {

        // 1. ArrayList 생성
        ArrayList<String> fruits = new ArrayList<>(); // String 타입만 넣을 수 있는 ArrayList

        // 2. ArrayList에 요소를 추가 (add)
        // add(요소)를 사용하면 끝에 추가해줌
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Grape");
        fruits.add("Mango");
        // add(인덱스, 요소) 해당 인덱스 위치에 삽입해줌
        fruits.add(2, "Blueberry");


        // 3. 요소에 접근
        // for-each문 사용
        System.out.println("---------Print the ArrayList(for-each)---------");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        // get() 사용
        System.out.println("-----------Print the ArrayList(get())----------");
        for (int i=0; i< fruits.size(); i++) {
            System.out.println(fruits.get(i)); // i번째 인덱스의 요소 반환
        }

        // 4. ArrayList의 길이 (size)
        System.out.println("-----------------------------------------------");
        System.out.println("fruits의 길이 : "+fruits.size());

        // 5. ArrayList의 요소 제거 (remove)
        System.out.println("-----------------------------------------------");
        String removeFruit = "Apple";
        fruits.remove(removeFruit);
        System.out.println(removeFruit+" has been removed from the ArrayList");

        System.out.println("---------------Updated ArrayList---------------");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        System.out.println("fruits의 길이 : "+fruits.size());

        // 6. 특정 요소의 포함 여부 (contain)
        System.out.println("-----------------------------------------------");
        String searchFruit = "Grape";
        if (fruits.contains(searchFruit)) {
            System.out.println("The ArrayList contains "+searchFruit);
        } else {
            System.out.println("The ArrayList does not contain "+searchFruit);
        }

    }
}
