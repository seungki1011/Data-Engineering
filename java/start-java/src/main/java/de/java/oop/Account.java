package de.java.oop;

public class Account {
    int balance;

    void checkStatus(){
        System.out.println("Current Balance: "+balance);
    }
    void deposit(int amount){
        System.out.println("(deposit) +"+amount);
        balance += amount;
    }
    void withdraw(int amount){
        if (balance >= amount){
            System.out.println("(withdraw) -"+amount);
            balance -= amount;
        } else {
            System.out.println("Insufficient Balance!");
            System.out.println("Current Balance: "+balance+", Withdraw Amount: "+amount);
        }
    }
}
