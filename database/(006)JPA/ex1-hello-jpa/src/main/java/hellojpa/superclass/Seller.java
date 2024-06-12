package hellojpa.superclass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

//@Entity
@NoArgsConstructor
public class Seller extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String product;

}
