package hellojpa.loading;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Major {

    @Id @GeneratedValue
    @Column(name = "MAJOR_ID")
    private Long id;

    private String name;

    public Major(String name) {
        this.name = name;
    }
}
