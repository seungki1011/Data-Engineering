package hellojpa.bidir;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class BiDirMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            BiDirTeam team = new BiDirTeam("TeamA");
            em.persist(team);

            BiDirMember member = new BiDirMember("member1", team);
            em.persist(member);

            em.flush();
            em.clear();

            BiDirMember findMember = em.find(BiDirMember.class, member.getId());
            List<BiDirMember> members = findMember.getTeam().getMembers();

            for (BiDirMember m : members) {
                System.out.println("m.getUsername() = " + m.getUsername());
            }

            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
        } finally {
            em.close();
        }

    }
}
