package de.java.collections;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetMain2 {
    public static void main(String[] args) {
        // 1. HashSet 생성
        HashSet<String> hashSet = new HashSet<>();

        // 2. HashSet에 원소 추가
        hashSet.add("Math");
        hashSet.add("English");
        hashSet.add("Philosophy");
        hashSet.add("Chemistry");
        hashSet.add("Chemistry"); // 중복 비허용 - HashSet에 추가되지 않음

        // 3. Iterator를 사용해서 HashSet의 원소 출력
        System.out.println("----------Print HashSet using Iterator----------");
        System.out.println("Elements in the HashSet:");
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 4. 특정 원소가 HashSet에 존재하는지 확인
        System.out.println("------------------------------------------------");
        String searchElement = "Math";
        if (hashSet.contains(searchElement)) {
            System.out.println(searchElement + " is present in the HashSet.");
        } else {
            System.out.println(searchElement + " is not present in the HashSet.");
        }

        // 5. HashSet에서 원소 제거
        System.out.println("------------------------------------------------");
        String removeElement = "Chemistry";
        hashSet.remove(removeElement);
        System.out.println(removeElement + " has been removed from the HashSet.");

        // 6. Updated HashSet 출력
        System.out.println("---------Updated Elements in the HashSet---------");
        for (String fruit : hashSet) {
            System.out.println(fruit);
        }

        // 7. HashSet의 크기
        System.out.println("------------------------------------------------");
        int size = hashSet.size();
        System.out.println("Size of the HashSet: " + size);

        // 8. HashSet 비우기
        hashSet.clear();
        System.out.println("HashSet is now empty.");
    }
}
