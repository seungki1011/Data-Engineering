package de.java.collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        // 1. LinkedList 생성
        LinkedList<String> linkedList = new LinkedList<>(); // String 타입만 넣을 수 있는 ArrayList

        // 2. LinkedList에 요소를 추가 (add)
        // add(요소)를 사용하면 끝에 추가해줌
        linkedList.add("Banana");
        linkedList.add("Apple");
        linkedList.add("Apple");

        // 특정 인덱스 위치에 추가
        linkedList.add(2, "Blueberry");
        linkedList.addFirst("Orange"); // 앞에 추가
        linkedList.addLast("Mango"); // 뒤에 추가

        // 3. LinkedList 출력
        System.out.println("---------Print the LinkedList---------");
        for (String item : linkedList) {
            System.out.println(item);
        }
    }
}
