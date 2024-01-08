package de.java.inheritance.practice;

public class PracticeMain1 {
    public static void main(String[] args) {
        Book b = new Book("Calculus", 10000, "Kim", "29301");
        Album a = new Album("Unorthodox Jukebox", 15000, "Bruno Mars");
        Movie m = new Movie("Incpetion", 10000, "Christopher Nolan", "Leonardo Di Caprio");

        b.print();
        a.print();
        m.print();

        int sum = b.getPrice() + a.getPrice() + m.getPrice();
        System.out.println("Total Price: "+sum);
    }
}
