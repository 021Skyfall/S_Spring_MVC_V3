package IO.SampleWeek2JPA.basic.config;

import IO.SampleWeek2JPA.basic.entity.MemberForCM;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Configuration
public class JpaColumnMappingConfig {
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaColumnMappingRunner(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();
        this.tx = em.getTransaction();

        return args -> {
//            testEmailNotNull();
//            testEmailUpdatable();
//            testEmailUnique();
        };
    }

    // 1. email nullable 확인
    private void testEmailNotNull() {
        tx.begin();
        em.persist(new MemberForCM());
        tx.commit();
    }

    // 2. email updatable 확인
    private void testEmailUpdatable() {
        tx.begin();
        em.persist(new MemberForCM("a1@gamil.com"));
        MemberForCM member = em.find(MemberForCM.class,1L);
        member.setEmail("b2@naver.com");
        tx.commit();
    }

    // 3. email 중복 확인
    private void testEmailUnique() {
        tx.begin();
        em.persist(new MemberForCM("a1@gmail.com"));
        em.persist(new MemberForCM("a1@gmail.com"));
        tx.commit();
    }
}
