package de.springdemo.service;

import de.springdemo.domain.Member;
import de.springdemo.repository.MemberRepository;
import de.springdemo.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 서비스 레이어쪽은 비즈니스에 의존적으로 네이밍하고 설계한다
 * cmd+shift+t : Create New Test
 */
//@Service
public class MemberService {
    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * Join as a member (회원가입)
     */
    public Long join(Member member) {
        //  같은 이름의 중봅 회원 금지
        /*
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("This member already exists.");
        });
        */

        /* 권장 하는 코드
         * 이 경우 메서드로 뽑는 것이 좋음 ctrl+t : extract method
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
            throw new IllegalStateException("This member already exists.");
            });
        */
        validateDuplicateMember(member); // 같은 이름의 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("This member already exists.");
                });
    }

    /**
     * Check all members(전체 회원 조회)
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
