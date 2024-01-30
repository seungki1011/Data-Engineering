package de.springdemo.service;

import de.springdemo.domain.Member;
import de.springdemo.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 테스트 코드는 이름을 한글로 작성 가능
 * given, when, then으로 로직을 나누는 것이 항상 맞는 것은 아니다
 * 상황을 잘 보면서 사용
 * 테스트는 정상 로직 뿐만 아니라 예외 상황도 제대로 캐치하는지 확인하는 것이 중요함
 */

class MemberServiceTest {

    MemberService memberService;
    /**
     * 사실상 다른 MemoryMemberRepository로 테스트 되는 것
     * MemberService에서 MemberRepository를 새로 생성하지 않고 생성자를 사용
     */
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        /**
         * MemberService의 입장에서 외부에서 memberRepository를 넣어주는 것 (의존성 주입)
         */
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        // given - 주어진 상황(데이터, 등)
        Member member = new Member();
        member.setName("hello");

        // when - 이것을 실행할 때
        Long saveId = memberService.join(member);

        // then - 이 결과가 나와야 함(검증)
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void duplicateMemberException() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when - 똑같은 name으로 join 하면 예외가 터져야 함
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        Assertions.assertThat(e.getMessage()).isEqualTo("This member already exists.");


        /** try-catch문으로 작성 시
        memberService.join(member1);
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) { // 예외 메세지가 일치해야 함
            Assertions.assertThat(e.getMessage()).isEqualTo("This member already exists. xx");
        }
        */

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}