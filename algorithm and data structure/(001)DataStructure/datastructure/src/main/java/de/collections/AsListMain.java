package de.collections;

import java.util.Arrays;
import java.util.List;

public class AsListMain {
    public static void main(String[] args) {

        // asList()를 사용하면 고정된 크기를 가지는 리스트를 생성한다.(길이 변경 불가)
        // 그렇다고 불변이라는 뜻은 아니다. 요소를 변경하는 것은 가능하다.
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        System.out.println("list = " + list);

        // 요소 변경
        list.set(3, 100);
        System.out.println("list = " + list);

        // 요소 추가/삭제는 불가능
        // list.add(5);
    }
}
