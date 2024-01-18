package de.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Fruit2 {
    private String name;
    int quantity;

    public Fruit2(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Fruit{name='" + name + "', quantity=" + quantity + '}';
    }
}

public class ComparatorMain {
    public static void main(String[] args) {
        List<Fruit2> fruits = new ArrayList<>();
        fruits.add(new Fruit2("Apple", 10));
        fruits.add(new Fruit2("Grape", 19));
        fruits.add(new Fruit2("Banana", 5));
        fruits.add(new Fruit2("Orange", 8));
        fruits.add(new Fruit2("Orange", 2));

        Collections.sort(fruits, comparator); // 아래에서 정의한 comparator 사용

        // Print sorted list
        for (Fruit2 fruit : fruits) {
            System.out.println(fruit);
        }
    }
    // 익명 클래스를 사용해서 Comparator의 기능 사용
    public static Comparator<Fruit2> comparator = new Comparator<Fruit2>() {
        @Override
        public int compare(Fruit2 o1, Fruit2 o2) {
            return o1.quantity - o2.quantity; // 오름차순 정렬
            // return (o1.name1).compareTo(o2.name2) // name을 기준으로
        }
    };
}
