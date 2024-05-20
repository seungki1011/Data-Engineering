package de.generic.test1;

import java.util.ArrayList;
import java.util.List;

public class PairTest {
    public static void main(String[] args) {

        Pair<Integer, String> pair1 = new Pair<>();
        pair1.setFirst(10);
        pair1.setSecond("data");
        System.out.println(pair1.getFirst());
        System.out.println(pair1.getSecond());
        System.out.println("pair1 = " + pair1);

        Pair<String, String> pair2 = new Pair<>();
        pair2.setFirst("key");
        pair2.setSecond("value");
        System.out.println(pair2.getFirst());
        System.out.println(pair2.getSecond());
        System.out.println("pair2 = " + pair2);

        // 지네릭 클래스간 다형성은 성립
        List<String> list = new ArrayList<String>();

        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("list = " + list);

        // 참조 변수의 지네릭 클래스 타입과 생성자의 대입된 타입은 무조건 일치해야한다
        // List<Long> list2 = new ArrayList<Integer>();

    }
}
