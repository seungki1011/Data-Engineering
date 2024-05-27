package de.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsMain1 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Integer max = Collections.max(list);
        Integer min = Collections.min(list);
        System.out.println("min = " + min);
        System.out.println("max = " + max);


        System.out.println("list = " + list);

        // 리스트 랜덤으로 섞기
        Collections.shuffle(list);
        System.out.println("shuffle list = " + list);

        // 정렬
        Collections.sort(list);
        System.out.println("sort list = " + list);

        // 역정렬
        Collections.reverse(list);
        System.out.println("reverse list = " + list);
    }
}
