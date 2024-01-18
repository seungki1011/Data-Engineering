package de.java.collections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // isbn은 고유하다고 가정하고 isbn만 사용
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 현재의 인스턴스가 비교하는 인스턴스(o)와 같은지 확인
        if (o == null || getClass() != o.getClass()) return false; // 같은 클래스인지 확인
        Book book = (Book) o; // isbn은 Object가 아니라 Book에 존재하기 때문에 사용하기 위해서 형변환
        return isbn.equals(book.isbn); // 두 Book 객체의 ISBN이 같은지 확인
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "Title: "+title+", Author: "+author+", ISBN: "+isbn;
    }
}

public class HashSetMain1 {
    public static void main(String[] args) {
        Set<Book> hashSet = new HashSet<>();

        // 1. HashSet에 객체(책) 추가
        hashSet.add(new Book("Title1", "Author1", "ISBN123"));
        hashSet.add(new Book("Title2", "Author2", "ISBN456"));
        hashSet.add(new Book("Title3", "Author3", "ISBN789"));
        hashSet.add(new Book("Title4", "Author2", "ISBN999"));

        // 2. 똑같은 책 추가 시도 - 이미 존재하기 때문에 추가되지 않음
        hashSet.add(new Book("Title3", "Author3", "ISBN789"));

        // 3. HashSet 원소 출력
        for (Book book : hashSet) {
            System.out.println(book);
        }
    }
}
