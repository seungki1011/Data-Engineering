package de.java.method;

import java.util.Scanner;

public class method2 {
    public static void main(String[] args) {
        int balance = 0;
        int option;
        int amount;
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("-------------------------------------------------");
            System.out.println("1.deposit | 2.withdraw | 3.check balance | 4.exit");
            System.out.println("-------------------------------------------------");
            System.out.print("Enter option: ");
            option = input.nextInt();
            if (option == 1) {
                System.out.print("Enter amount of deposit: ");
                amount = input.nextInt();
                balance = deposit(amount, balance);
                System.out.println("You have deposited "+amount+". Current balance: "+balance);
            } else if (option == 2) {
                System.out.print("Enter amount of withdrawal: ");
                amount = input.nextInt();
                balance = withdraw(amount, balance);
                System.out.println("You have withdraw "+amount+". Current balance: "+balance);
            } else if (option == 3) {
                System.out.println("Current balance is: "+balance);
            } else {
                System.out.println("Exit program.");
                break;
            }
        }
    }
    public static int deposit(int amount, int balance) {
        balance += amount;
        return balance;
    }
    public static int withdraw(int amount, int balance) {
        balance -= amount;
        return balance;
    }
}
