package de.java.loop;

public class loop4 {
    public static void main(String[] args) {
        // 1. for-each 1
        int[] numbers = {1, 2, 3};
        for (int number : numbers) {
            System.out.println(number);
        }

        // 2. for-each 2
        String[] studentNames = {"Bob", "Mike", "Shawn", "Merry"};
        for (String name : studentNames) {
            System.out.println(name);
        }

    }
}
