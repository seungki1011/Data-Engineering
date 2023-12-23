package de.java.array;

import java.util.Scanner;

public class arr5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] productNames = new String[10];
        int[] productPrices = new int[10];
        int productCount = 0;
        int option;

        outerLoop: while(true) {
            System.out.println("1.Product register 2.Product list 3.Exit");
            System.out.print("Enter the option: ");
            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter the product name: ");
                    productNames[productCount] = input.nextLine();
                    System.out.print("Enter the product price: ");
                    productPrices[productCount] = input.nextInt();
                    productCount++;
                    break;
                case 2:
                    for(int i = 0; i < productCount; i++){
                        System.out.println(productNames[i] + ": "+productPrices[i]);
                    }
                    break;
                case 3:
                    System.out.println("Exit Program!");
                    break outerLoop;
            }
        }
    }
}
