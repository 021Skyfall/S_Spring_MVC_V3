package IO.SampleWeek2JPA.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class MemberForCM {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long memberId;

    @Column(nullable = false, updatable = false, unique = true)
    private String email;

    public MemberForCM(String email) {
        this.email = email;
    }
}
