package de.java.classpractice;

public class cp3 {
    public static void main(String[] args) {
        BookInfo book1 = new BookInfo();
        book1.title = "Harry Potter";
        book1.author = "J.K Rolling";
        book1.rating = 8.1;

        BookInfo book2 = new BookInfo();
        book2.title = "De Principatibus";
        book2.author = "Niccolo Machiavelli";
        book2.rating = 8.9;

        System.out.println("Title: "+book1.title+", Author: "+book1.author+", Rating: "+book1.rating);
        System.out.println("Title: "+book2.title+", Author: "+book2.author+", Rating: "+book2.rating);
    }
}
