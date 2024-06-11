package hellojpa.inheritance.join;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@NoArgsConstructor
public class Album extends Item {
    private String artist;

    public Album(String name, int price, String artist) {
        super(name, price);
        this.artist = artist;
    }
}
