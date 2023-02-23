package IO.SampleWeek2JPA.basic.config;

import IO.SampleWeek2JPA.basic.entity.MemberForDM;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Configuration
public class JpaIdDirectMappingConfig {
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaSingleMappingRunner(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();
        this.tx = em.getTransaction();

        return args -> {
//            tx.begin();
//            em.persist(new MemberForDM());
//            MemberForDM member = em.find(MemberForDM.class, 1L);
//            System.out.println("memberId : " + member.getMemberId());
//            tx.commit();
        };
    }
}
