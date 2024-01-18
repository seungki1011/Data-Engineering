package de.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Fruit implements Comparable<Fruit> {
    private String name;
    private int quantity;

    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    // Implement compareTo method for natural ordering(오름차순)
    @Override
    public int compareTo(Fruit other) {
        // 자기 자신의 quantity와 넘긴 매개변수 객체의 quantity 비교
        /*
        if(this.quantity > other.quantity) {
            return 1;
        } else if (this.quantity == other.quantity) {
            return 0;
        } else {
            return -1;
        }
        */
        return this.quantity - other.quantity; // 범위 넘어가는 경우 주의
        // 내림차순으로 정렬하고 싶은 경우
        // return -(this.quantity - other.quantity);
    }


//    @Override
//    public int compareTo(Fruit other) {
//        return this.name.compareTo(other.name); // String의 compareTo를 사용(Comparable의 compareTo와 다름)
//    }

    @Override
    public String toString() {
        return "Fruit{name='" + name + "', quantity=" + quantity + '}';
    }
}

public class ComparableMain {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("Apple", 10));
        fruits.add(new Fruit("Banana", 5));
        fruits.add(new Fruit("Orange", 8));
        fruits.add(new Fruit("Orange", 2));

        // Sort using natural ordering (compareTo method)
        Collections.sort(fruits);

        // Print sorted list
        for (Fruit fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
