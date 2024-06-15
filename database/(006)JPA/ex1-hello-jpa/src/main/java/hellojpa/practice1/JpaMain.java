package hellojpa.practice1;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        /**
         * persistence.xml의 persistence-unit의 name을 넣어준다
         * EntityManagerFactory를 통해서 EntityManager를 생성한다
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /**
         * 각 트랜잭션 별로 EntityManager를 만들어서 사용
         */
        EntityManager em = emf.createEntityManager();

        /**
         * JPA에서 데이터를 변경하는 작업은 트랜잭션 단위 내에서 작업한다
         * 생성한 EntityManager에서 트랜잭션을 얻어서 사용
         */
        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작

        /**
         * 아래의 try-catch-finally는 스프링부트를 사용하면 전부 생략가능
         */
        try {
            // ----- 멤버 추가 -----
            // Member member = new Member();
            // member.setId(1L);
            // member.setName("MemberA");
            // em.persist(member); // 객체를 DB에 저장(실제로는 영속성 컨텍스트에 저장, 뒤에서 다룸)
            // -------------------


            // ----- 멤버 찾기 -----
            // PK가 2인 멤버 찾기
            // Member findMember = em.find(Member.class, 2L);
            // System.out.println("findMember.getId() = " + findMember.getId());
            // System.out.println("findMember.getName() = " + findMember.getName());
            // -------------------

            // ----- 멤버 삭제 -----
            // 위에서 찾은 멤버를 가지고 삭제
            // em.remove(findMember);
            // -------------------

            // ----- 멤버 수정 -----
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("UpdatedMemberA");

            // -------------------

            tx.commit(); // 성공하면 커밋
        } catch (RuntimeException e) {
            tx.rollback(); // 예외 발생시 롤백
        } finally {
            em.close();
        }

        emf.close(); // 전체 애플리케이션이 끝나면 EntityManagerFactory 종료
    }
}
