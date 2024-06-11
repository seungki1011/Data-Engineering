package hellojpa.bidir;

import hellojpa.unidir.UniDirTeam;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Getter @Setter
@NoArgsConstructor
public class BiDirMember {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USER_NAME", nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private BiDirTeam team;

    public BiDirMember(String username, BiDirTeam team) {
        this.username = username;
        this.team = team;
    }



    public void setBiDirTeam(BiDirTeam team) {
        this.team = team;
        team.getMembers().add(this); //
    }

}
