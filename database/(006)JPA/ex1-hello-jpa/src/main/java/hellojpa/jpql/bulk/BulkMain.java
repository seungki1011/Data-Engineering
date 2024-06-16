package hellojpa.jpql.bulk;

import hellojpa.jpql.Member;
import hellojpa.jpql.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class BulkMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team teamA = new Team("teamA");
            em.persist(teamA);

            Team teamB = new Team("teamB");
            em.persist(teamB);

            Team teamC = new Team("teamC");
            em.persist(teamC);

            Member member1 = new Member("member1", 10);
            member1.addTeam(teamA);
            em.persist(member1);

            Member member2 = new Member("member2", 20);
            member2.addTeam(teamA);
            em.persist(member2);

            Member member3 = new Member("member3", 30);
            member3.addTeam(teamB);
            em.persist(member3);

            Member member4 = new Member("member4", 40);
            member4.addTeam(teamC);
            em.persist(member4);

            em.flush();
            em.clear();

            /**
             * 모든 멤버 엔티티에 대해 age를 50으로 변경
             * executeUpdate() : 결과로 영향받은 엔티티 수를 반환한다
             * UPDATE, DELETE 지원
             */
            int resultCount = em.createQuery("update Member m set m.age = 50")
                    .executeUpdate();

            System.out.println("member1.getAge() = " + member1.getAge());

            System.out.println("resultCount = " + resultCount);

            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
