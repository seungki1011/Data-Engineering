package de.springbasic1;

import de.springbasic1.member.Grade;
import de.springbasic1.member.Member;
import de.springbasic1.member.MemberService;
import de.springbasic1.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        // AppConfig를 통해 사용
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        // MemberService memberService = new MemberServiceImpl();
        // 회원 가입과 조회 동작 확인해보기
        // main에서 확인하는 것은 한계가 있기 떄문에 junit을 사용해서 테스트 코드 작성하자

        Member member = new Member(1L, "messi", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("-------Check-------");
        System.out.println("member = "+member.getName());
        System.out.println("findMember = "+findMember.getName());
    }
}
