package de.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableMain {
    public static void main(String[] args) {

        // 불변 컬렉션 생성
        // 변경 불가!
        List<Integer> list = List.of(1, 2, 3, 4);
        Set<Integer> set = Set.of(1, 2, 3, 4);
        Map<String, Integer> map = Map.of("A", 1, "B", 2);

        System.out.println("list = " + list);
        System.out.println("set = " + set);
        System.out.println("map = " + map);

        // java.lang.UnsupportedOperationException 발생
        // list.add(5);

    }
}
