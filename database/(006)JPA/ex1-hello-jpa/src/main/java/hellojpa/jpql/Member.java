package hellojpa.jpql;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(
        name = "Member.findByUsername",
        query = "select m from Member m where m.username = :username"
)
@Getter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;
    private int age;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    private void setTeam(Team team) {
        this.team = team;
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }

    // 편의 메서드
    public void addTeam(Team team) {
        this.setTeam(team);
        team.getMembers().add(this);
    }

}
