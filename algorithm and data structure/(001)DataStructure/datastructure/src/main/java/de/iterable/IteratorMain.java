package de.iterable;

import java.util.Iterator;

public class IteratorMain {
    public static void main(String[] args) {

        MyArray myArray = new MyArray(new int[]{1, 2, 3, 4});

        Iterator<Integer> iterator = myArray.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println("value = " + value);
        }

        System.out.println("--------");
        // 다시 Iterator 객체를 사용하기 위해서는 새로 선언해야 한다
        iterator = myArray.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println("value = " + value);
        }
    }
}
