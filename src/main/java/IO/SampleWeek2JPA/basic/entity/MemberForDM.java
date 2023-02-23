package IO.SampleWeek2JPA.basic.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 3. SEQUENCE 기본키 생성 전략
@NoArgsConstructor
@Getter
@Entity
public class MemberForDM {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long memberId;
}

// 2. IDENTITY 기본키 생성 전략 (데이터베이스에서 자동 생성)
//@NoArgsConstructor
//@Getter
//@Entity
//public class Member {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long memberId;
//
//    public Member(long memberId) {
//        this.memberId = memberId;
//    }
//}

// 1. 기본키 직접 할당
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity(name = "USERS")
//@Table(name = "USERS")
//public class Member {
//    @Id
//    private long memberId;
//}