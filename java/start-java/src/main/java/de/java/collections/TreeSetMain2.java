package de.java.collections;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain2 {
    public static void main(String[] args) {
        // 1. 들어갈 데이터가 Integer인 TreeSet 생성
        TreeSet<Integer> treeSet = new TreeSet<>();

        // 2. TreeSet에 요소 추가
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(8);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(6);
        treeSet.add(5); // 중복 추가해도 추가되지 않음

        // 3. TreeSet의 요소 출력해보기 - 정렬되어 있는 것을 확인할 수 있음
        for (Integer i : treeSet) {
            System.out.println(i);
        }

        // 4. 가장 첫 요소(가장 작은 요소) 출력
        System.out.println("First Element: "+treeSet.first());

        // 5. 가장 마지막 요소(가장 큰 요소) 출력
        System.out.println("Last Element: "+treeSet.last());

        // 6. 주어진 기준(3) 보다 큰 요소 중에 제일 작은 요소 출력
        System.out.println("Element higher than 3: "+treeSet.higher(3));

        // 7. subSet() - 주어진 범위내의 집합
        System.out.println("treeSet.subSet(2,6) = "+treeSet.subSet(2,6)); // 2이상 6미만

        // 8. headSet() - 주어진 기준(5) 미만의 집합
        System.out.println("treeSet.headSet(5) = "+treeSet.headSet(5));

        // 9. tailSet() - 주어진 기준(6) 이상의 집합
        System.out.println("treeSet.tailSet(6) = "+treeSet.tailSet(6));
    }
}
