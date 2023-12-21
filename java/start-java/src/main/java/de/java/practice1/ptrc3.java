package de.java.practice1;

import java.util.Scanner;

public class ptrc3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a integer: ");
        int intVal = scanner.nextInt();

        if (intVal % 2 == 0) {
            System.out.println("Integer Value "+intVal+" is a even number");
        } else {
            System.out.println("Integer Value "+intVal+" is a odd number");
        }

    }
}
