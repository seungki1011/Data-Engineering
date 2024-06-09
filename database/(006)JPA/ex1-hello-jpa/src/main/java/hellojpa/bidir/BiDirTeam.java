package hellojpa.bidir;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class BiDirTeam {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    /**
     * Team이 One, Member가 Many
     * (mappedBy = "team") : 반대편에 대응되는 변수명 team
     */
    @OneToMany(mappedBy = "team")
    private List<BiDirMember> members = new ArrayList<>(); // add시 NPE 방지

    public BiDirTeam(String name) {
        this.name = name;
    }

    public BiDirTeam(String name, List<BiDirMember> members) {
        this.name = name;
        this.members = members;
    }
}
