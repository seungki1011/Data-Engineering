package de.hash;

import java.util.HashSet;
import java.util.Set;

public class HashSetMain {
    public static void main(String[] args) {

        Set<Book> bookSet = new HashSet<>();

        // 세트에 객체(book) 추가
        bookSet.add(new Book("1984", "George Orwell", "ISBN978-0451524935"));
        bookSet.add(new Book("Pride and Prejudice", "Jane Austen", "ISBN978-1503290563"));
        bookSet.add(new Book("Fahrenheit 451", "Ray Bradbury", "ISBN978-1451673319"));
        bookSet.add(new Book("To Kill a Mockingbird", "Harper Lee", "ISBN978-0061120084"));

        // 같은 ISBN으로 추가 시도(실패)
        bookSet.add(new Book("XXX", "XXX", "ISBN978-0061120084"));

        // 세트 출력
        printSet(bookSet);

        // 요소 제거 - ISBN을 기준으로 equals()를 오버라이딩 했기 때문에 ISBN이 일치하면 제거
        bookSet.remove(new Book("XXX", "XXX", "ISBN978-0061120084"));
        printSet(bookSet);

    }

    private static void printSet(Set set) {
        System.out.println("------printSet------");
        for (Object object : set) {
            System.out.println(object);
        }
        System.out.println("--------------------");
    }
}
