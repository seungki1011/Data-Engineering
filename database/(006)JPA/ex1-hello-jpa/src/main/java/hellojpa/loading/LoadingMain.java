package hellojpa.loading;

import hellojpa.SeqMember;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class LoadingMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Major major1 = new Major("전자전기공학");
            em.persist(major1);

            Student student1 = new Student("김xx", major1);
            em.persist(student1);

            em.flush();
            em.clear();

            Student findStudent = em.find(Student.class, student1.getId());
            System.out.println("findStudent = " + findStudent.getMajor().getClass());

            tx.commit();

        } catch (RuntimeException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}
