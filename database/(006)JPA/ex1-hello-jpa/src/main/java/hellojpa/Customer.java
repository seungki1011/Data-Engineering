package hellojpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

//@Entity
@Getter @Setter
@AllArgsConstructor
public class Customer {

    @Id
    private Long id;

    /**
     * DB 컬럼명은 name 사용
     * 객체는 username 사용
     */
    @Column(name = "name")
    private String username;

    private Integer age;

    /**
     * 특정 필드를 컬럼에 매핑하지 않음(매핑 무시)
     */
    @Transient
    private Integer point;

    /**
     * enum 타입 매핑
     * DB는 보통 enum 타입이 없음
     */
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    /**
     * 닐짜 타입 매핑
     * TIMESTAMP는 날짜 + 시간 포함
     * 아래 처럼 Date, Calendar를 사용하는 경우 사용하고
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    /**
     * 만약 LocalDate, LocalDateTime을 사용하면 @Temporal 생략 가능
     */
    private LocalDateTime testLocalDateTime;

    /**
     * VarChar를 넘어가는 큰 데이터는 Lob사용(Clob, Blob)
     * String을 사용했으니 Clob으로 생성됨
     * 니머지는 Blob 매핑
     */
    @Lob
    private String description;

    public Customer() {
    }
}
