package de.springdemo.service;

import de.springdemo.domain.Member;
import de.springdemo.repository.MemberRepository;
import de.springdemo.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;

    @Autowired MemberRepository memberRepository;

    /**
     * @SpringBootTest : 스프링 컨테이너와 테스트를 함께 실행한다
     * 기존에 BeforeEach, AfterEach를 사용한 이유는 메모리에 남아 있는 데이터베이스 기록을 지우기 위해 사용
     * @Transactional : 테스트 시작전에 트랜잭션을 시작하고, 테스트 완료 후에 할상 롤백(다음 테스트 영향 x)
     * @Commit : 커밋 남길 수 있음
     */

    @Test
    void join() {
        // given - 주어진 상황(데이터, 등)
        Member member = new Member();
        member.setName("hello");

        // when - 이것을 실행할 때
        Long saveId = memberService.join(member);

        // then - 이 결과가 나와야 함(검증)
        Member findMember = memberService.findOne(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    void duplicateMemberException() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("This member already exists.");

    }
}