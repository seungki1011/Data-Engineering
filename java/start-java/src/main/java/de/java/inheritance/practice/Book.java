package de.java.inheritance.practice;

public class Book extends Item{
    protected String author;
    protected String isbn;

    public Book(String name, int price, String author, String isbn) {
        super(name, price);
        this.author = author;
        this.isbn = isbn;
    }
}
