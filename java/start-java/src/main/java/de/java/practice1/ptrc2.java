package de.java.practice1;

import java.util.Scanner;

public class ptrc2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type in your name: ");
        String myName = scanner.nextLine();
        System.out.print("Type in your age: ");
        int myAge = scanner.nextInt();
        System.out.println("Your name is "+myName+", Your age is "+myAge);

    }
}
