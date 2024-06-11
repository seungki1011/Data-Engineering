package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * JPA에서 사용할 엔티티 이름을 직접 지정 가능
 * 기본값 : 클래스 이름을 그대로 사용한다
 * 기본값 사용 권장
 */
//@Entity(name = "Customer")
/**
 * @Table을 통해서 엔티티와 매핑할 테이블 직접 지정 가능
 * name - 매핑할 테이블 이름
 * catalog - 데이터베이스 카탈로그 매핑
 * schema - 데이터베이스 스키마 매핑
 * uniqueConstraints - DDL 생성시에 유니크 제약 조건 생성
 */
//@Table(name="USERS")
//@Entity
@Getter @Setter
@AllArgsConstructor
public class EmCustomer {
    @Id
    private Long id;
    private String name;
    private Integer age;

    // 기본 생성자 필수
    public EmCustomer() {
    }

}
