package de.java.oop;

public class oop2 {
    public static void main(String[] args) {
        Account account = new Account();
        account.checkStatus();
        account.deposit(5000);
        account.withdraw(2000);
        account.checkStatus();
        account.withdraw(4000);
    }
}
