package hellojpa.jpql.parameterbinding;

import hellojpa.jpql.Member;
import jakarta.persistence.*;

public class ParameterBindingMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member("member1", 25);
            em.persist(member);

            Member findByName = em.createQuery("select m from Member m where m.username = :username", Member.class)
                    .setParameter("username", "member1") // 파라미터 바인딩
                    .getSingleResult();

            System.out.println("findByName.getUsername() = " + findByName.getUsername());

            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
