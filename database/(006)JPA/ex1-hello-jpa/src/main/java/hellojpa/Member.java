package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

//@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
// @Table(name = "USER")
public class Member {
    @Id // 데이터베이스 PK와 매핑
    private Long id;

    // @Column(name = "user_name")
    private String name;
}
