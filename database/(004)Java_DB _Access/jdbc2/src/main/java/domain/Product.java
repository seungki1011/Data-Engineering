package domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Product {

    private int id;
    private String name;
    private LocalDateTime updated_at;
    private String description;
    private int price;

    public Product(int id, String name, LocalDateTime updated_at, String description, int price) {
        this.id = id;
        this.name = name;
        this.updated_at = updated_at;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", updated_at=" + updated_at +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
