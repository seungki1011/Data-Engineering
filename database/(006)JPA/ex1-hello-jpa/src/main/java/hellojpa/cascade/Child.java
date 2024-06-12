package hellojpa.cascade;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Child {

    @Id @GeneratedValue
    private Long id;

    private String name;

    // 연관관계의 주인
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Parent parent;

    public Child(String name) {
        this.name = name;
    }
}
