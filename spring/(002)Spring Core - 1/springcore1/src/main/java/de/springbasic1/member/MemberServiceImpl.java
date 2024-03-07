package de.springbasic1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{
    // 구현 객체를 선택해야 함
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    // 생성자를 통해서 구현체를 선택할 것이다
    @Autowired // 자동 의존성 주입 필요
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
