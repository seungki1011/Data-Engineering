package de.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToMutableMain {
    public static void main(String[] args) {

        // 불변 리스트 생성
        List<Integer> list = List.of(1, 2, 3, 4); // add()와 같은 변경 불가
        System.out.println("immutable list = " + list);

        // 가변 리스트로 변환
        ArrayList<Integer> mutableList = new ArrayList<>(list); // 변경 가능
        mutableList.add(5);
        System.out.println("mutableList = " + mutableList);

        // 다시 불변 리스트로 변환
        List<Integer> unmodifiableList = Collections.unmodifiableList(mutableList); // 불변 리스트
        System.out.println("unmodifiableList.getClass() = " + unmodifiableList.getClass());

    }
}
