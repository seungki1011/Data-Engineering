package hellojpa.inheritance.join;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@NoArgsConstructor
public class Book extends Item {

    private String author;
    public String isbn;

    public Book(String name, int price, String author, String isbn) {
        super(name, price);
        this.author = author;
        this.isbn = isbn;
    }
}
