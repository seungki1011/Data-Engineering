package hellojpa.unidir;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UniDirMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 팀 저장
            UniDirTeam team = new UniDirTeam("TeamA");
            em.persist(team);

            // 멤버 저장
            UniDirMember member = new UniDirMember("member1", team);
            em.persist(member);

            // DB에서 직접 가져오는 쿼리를 보고 싶으면 사용
            // em.flush();
            // em.clear();

            // 조회
            UniDirMember findMember = em.find(UniDirMember.class, member.getId());

            // 참조를 이용한 연관 관계 조회
            UniDirTeam findTeam = findMember.getTeam();
            System.out.println("findTeam = " + findTeam.getName());


            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
