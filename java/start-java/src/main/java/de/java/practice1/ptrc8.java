package de.java.practice1;

import java.util.Scanner;

public class ptrc8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String itemName;
        int itemPrice = 0;
        int itemCount = 0;
        int choice = 0;
        int totalPrice = 0;

        outerLoop: while(true) {
            System.out.println("1: Enter product name, 2: Payment, 3: Exit program");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    input.nextLine();
                    System.out.print("Enter product name: ");
                    itemName = input.nextLine();
                    System.out.print("Enter product price: ");
                    itemPrice = input.nextInt();
                    System.out.print("Enter order quantity: ");
                    itemCount = input.nextInt();
                    System.out.println("Product Name: "+itemName+", Price: "+itemPrice+", Order Amount: "+itemCount);
                    totalPrice += (itemPrice*itemCount);
                    break;
                case 2:
                    input.nextLine();
                    System.out.println("Total Price is: "+totalPrice);
                    totalPrice = 0;
                    break;
                case 3:
                    System.out.println("Exiting Program!");
                    break outerLoop;
                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }
    }
}
