package de.java.generics;

import java.util.ArrayList;

public class GenericTest {
    public static void main(String[] args) {
        // 1. 제네릭 없이 ArrayList 사용해보기
        ArrayList noGenericList = new ArrayList();
        noGenericList.add(100);
        noGenericList.add(200);
        noGenericList.add("300");
        noGenericList.add("Three hundred");

        /**
         * 에러 발생! (형변환 에러)
         * 컴파일러 입장에서는 noGenericList는 Object 타입 ->
         * java.lang.String cannot be cast to java.lang.Integer
         */
        // Integer i = (Integer) noGenericList.get(2);

        System.out.println(noGenericList); // [100, 200, 300, Three hundred]

        // 2. 제네릭 사용해보기
        ArrayList<Integer> genericList = new ArrayList<>();
        genericList.add(10);
        genericList.add(20);
        // genericList.add("30"); // 컴파일 에러 발생 - Integer 타입을 넣어야 함

        /**
         * 제네릭스 덕분에 타입 체크 강화!
         * 제네릭스를 사용하는 것을 권장
         */

    }
}
