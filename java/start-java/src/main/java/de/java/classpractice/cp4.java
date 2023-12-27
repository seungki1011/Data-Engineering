package de.java.classpractice;

public class cp4 {
    public static void main(String[] args) {
        BookInfo book1 = new BookInfo();
        book1.title = "Harry Potter";
        book1.author = "J.K Rolling";
        book1.rating = 8.1;

        BookInfo book2 = new BookInfo();
        book2.title = "De Principatibus";
        book2.author = "Niccolo Machiavelli";
        book2.rating = 8.9;

        BookInfo[] bookInfos = new BookInfo[] {book1, book2};
        for (BookInfo bookInfo : bookInfos) {
            System.out.println("Title: "+bookInfo.title+", Author: "+bookInfo.author+", Rating: "+bookInfo.rating);
        }
    }
}
