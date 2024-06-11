package hellojpa.loading;

import hellojpa.unidir.UniDirTeam;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Student {

    @Id @GeneratedValue
    private Long id;

    private String name;

    /**
     * LAZY : 지연 로딩
     * 기본값 : EAGER(즉시 로딩)
     * 즉시 로딩은 사용하지 말자
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAJOR_ID")
    private Major major;

    public Student(String name, Major major) {
        this.name = name;
        this.major = major;
    }
}
