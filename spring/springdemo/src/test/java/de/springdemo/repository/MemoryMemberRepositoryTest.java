package de.springdemo.repository;

import de.springdemo.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    /**
     * 각 테스트에서 저장소에 저장하는 작업이 있기 때문에 테스트 후 비워주는 작업이 필요함
     * 테스트는 순서에 의존 관계가 없도록 설계해야 함
    */
    @AfterEach // 메서드가 끝날때 마다 특정 동작(콜백 함수라고 생각하면 됨
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring"); // 이름을 "spring"으로

        repository.save(member); // 저장소에 멤버 저장
        Member result = repository.findById(member.getId()).get();

        // 1. 일치하면 true 반환
        System.out.println("Result = "+(result == member));
        // 2. 기대한 값과 일치하는지 확인, 다를 경우 AssertionFailedError
        Assertions.assertEquals(result, member);
        // 3. org.assertj.core.api.Assertions.assertThat 사용
        assertThat(member).isEqualTo(result); // static import로 처리하면 편함
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        Member result1 = repository.findByName("spring1").get();
        assertThat(result1).isEqualTo(member1);
        // 일치하지 않기 때문에 오류 발생
        /*
        Member result1 = repository.findByName("spring2").get();
        assertThat(result1).isEqualTo(member1);
        */
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2); // 입력한 멤버가 2개
    }
}
