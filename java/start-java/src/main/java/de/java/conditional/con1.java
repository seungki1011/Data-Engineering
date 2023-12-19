package de.java.conditional;

public class con1 {
    public static void main(String[] args) {

        // 1. if
        int a = 50;
        int b = 37;

        if (a>b) {
            System.out.println("a is bigger than b");
        }
        if (a>20) {
            System.out.println("a is bigger than 20");
        }

        // 2. if - else
        String c = "Hello";
        if (c.equals("Hello World!")) {
            System.out.println("String c equals to Hello World!");
        } else {
            System.out.println("String c is not Hello World!");
        }

        // 3. else if
        int age = 8;
        if (age>19) {
            System.out.println("You are a adult");
        } else if (19>=age && age>12) {
            System.out.println("You are a teenager");
        } else if (12>=age && age>1) {
            System.out.println("You are a child");
        } else {
            System.out.println("You are a infant");
        }
    }
}
