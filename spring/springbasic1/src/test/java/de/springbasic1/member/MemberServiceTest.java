package de.springbasic1.member;

import de.springbasic1.AppConfigJava;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;
    // MemberService memberService = new MemberServiceImpl(memberRepository);

    @BeforeEach
    public void beforeEach() {
        AppConfigJava appConfig = new AppConfigJava();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given - 주어진 상황(데이터, 등)
        Member member = new Member(1L, "messi", Grade.VIP);

        // when - 이것을 실행할 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then - 이런 결과가 나와야 한다(검증)
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
