package de.java.practice1;

import java.util.Scanner;

public class ptrc4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the food name: ");
        String foodName = scanner.nextLine();
        System.out.print("Enter the price of the food: ");
        int foodPrice = scanner.nextInt();
        System.out.print("Enter the number of foods to order: ");
        int foodNumber = scanner.nextInt();

        int totalPrice = foodPrice * foodNumber;
        System.out.println("You have ordered "+foodNumber+" "+foodName+"!");
        System.out.println("The total price is "+totalPrice+"₩");
    }
}
