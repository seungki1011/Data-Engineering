package hellojpa.jpql;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "ORDERS") // Order는 예약어라서 잘 안됨
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    private int orderAmount;

    @Embedded
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    Member member;

    @OneToOne
    @JoinColumn(name = "product_id")
    Product product;

    public Order(int orderAmount, String city, String street, String zipcode) {
        this.orderAmount = orderAmount;
        this.address = new Address(city, street, zipcode);
    }

    public void addMember(Member member) {
        member.getOrders().add(this);
    }
}
