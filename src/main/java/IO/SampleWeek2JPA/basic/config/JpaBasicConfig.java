package IO.SampleWeek2JPA.basic.config;

import IO.SampleWeek2JPA.basic.entity.MemberForBasic;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Configuration
public class JpaBasicConfig {
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaBasicRunner(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();
        this.tx = em.getTransaction();

        return args -> {
//            example05();
//            example04();
//            example03();
//            example02();
//            example01();
        };
    }

    // 5. 영속성 컨텍스트와 테이블의 엔티티 삭제
    private void example05() {
        tx.begin();
        em.persist(new MemberForBasic("a1@gmail.com"));
        tx.commit();

        tx.begin();
        MemberForBasic member = em.find(MemberForBasic.class,1L);
        em.remove(member);
        tx.commit();
    }

    // 4. 영속성 컨텍스트와 테이블에 엔티티 업데이트
    private void example04() {
        tx.begin();
        em.persist(new MemberForBasic("a1@gmail.com"));
        tx.commit();

        tx.begin();
        MemberForBasic member1 = em.find(MemberForBasic.class, 1L);
        member1.setEmail("b2@naver.com");
        tx.commit();
    }

    // 3. 쓰기 지연을 통한 영속성 컨텍스트와 테이블에 엔티티 일괄 저장
    private void example03() {
        tx.begin();

        MemberForBasic member1 = new MemberForBasic("a1@gmail.com");
        MemberForBasic member2 = new MemberForBasic("b1@gamil.com");

        em.persist(member1);
        em.persist(member2);

        tx.commit();
    }

    // 2. 영속성 컨텍스트와 테이블에 엔티티 저장
    private void example02() {
        tx.begin();
        MemberForBasic member = new MemberForBasic("asd@gmail.com");
        em.persist(member);
        tx.commit();
        MemberForBasic resultMember1 = em.find(MemberForBasic.class, 1L);
        System.out.printf("Id : %s , email : %s \n",resultMember1.getMemberId(),resultMember1.getEmail());

        MemberForBasic resultMember2 = em.find(MemberForBasic.class, 2L);
        System.out.println(resultMember2 == null);
    }

    // 1. 영속성 컨텍스트에 엔티티 저장
    private void example01() {
        MemberForBasic member = new MemberForBasic("asd@gmail.com");

        em.persist(member);

        MemberForBasic resultMember = em.find(MemberForBasic.class, 1L);
        System.out.println("Id : " + resultMember.getMemberId() +
                " / emaile : " + resultMember.getEmail());
    }
}
