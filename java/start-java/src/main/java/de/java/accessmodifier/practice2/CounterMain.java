package de.java.accessmodifier.practice2;

import de.java.accessmodifier.practice1.MaxCounter;

public class CounterMain {
    public static void main(String[] args) {
        MaxCounter c = new MaxCounter(3);
        c.increment();
        c.increment();
        c.increment();
        c.increment();
        int count = c.getCount();
        System.out.println(count);
    }
}
