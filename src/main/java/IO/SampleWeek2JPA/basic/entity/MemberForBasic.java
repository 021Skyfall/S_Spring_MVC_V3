package IO.SampleWeek2JPA.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class MemberForBasic {
    @Id
    private long memberId;
    private String email;

    public MemberForBasic(String email) {
        this.email = email;
    }
}

