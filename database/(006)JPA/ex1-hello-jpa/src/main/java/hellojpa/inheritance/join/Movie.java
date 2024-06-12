package hellojpa.inheritance.join;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Setter
@NoArgsConstructor
public class Movie extends Item {

    private String director;
    private String actor;

    public Movie(String name, int price, String director, String actor) {
        super(name, price);
        this.director = director;
        this.actor = actor;
    }
}
