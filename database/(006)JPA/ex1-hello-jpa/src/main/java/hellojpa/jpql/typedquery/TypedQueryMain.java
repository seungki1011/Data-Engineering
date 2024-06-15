package hellojpa.jpql.typedquery;

import hellojpa.jpql.Member;
import jakarta.persistence.*;

public class TypedQueryMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member("member1", 25);
            em.persist(member);

            /**
             * 1. TypedQuery : 반환 타입을 명시할 수 있음
             * Member 타입이라는 것을 명시할 수 있음
             * select를 통해 멤버를 조회
             */
            TypedQuery<Member> typedQuery = em.createQuery("select m from Member m", Member.class);

            /**
             * 2. Query : 반환 타입이 명확하지 않음
             * 만약 m.username만 조회한다면 TypedQuery<String>으로 타입을 명기할 수 있찌만
             * 그러나 지금은 username: String, age: int를 조회하고 있음
             */
            Query query = em.createQuery("select m.username, m.age from Member m");

            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
