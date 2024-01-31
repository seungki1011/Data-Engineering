package de.springdemo.controller;

import de.springdemo.domain.Member;
import de.springdemo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Controller가 있으면 스프링 컨테이너에 MemberController 객체를 생성해서 넣어둔고, 스프링이 관리한다
 * 이것을 스프링 컨테이너에서 스프링 빈(Spring Bean)이 관리된다고 표현한다
 */
@Controller
public class MemberController {
    /**
     * 스프링이 관리를 하게 되면 컨테이너에 등록이 되고, 컨테이너로 부터 받아서 쓰도록 해야함
     * new를 사용하면 MemberController가 아니더라도 다른 Controller들이 MemberService를 사용할 수 있게 됨
     * private final MemberService memberService = new MemberService();
     */

    private final MemberService memberService;

    /**
     * @Autowired가 있으면 스프링 컨테이너의 MemberService와 연결 시켜줌
     * 생성자의 @Autowired를 통해서 스프링이 연관된 객체를 컨테이너에서 찾아서 넣어준다 - 의존성 주입
     * MemberService에 @Service 애노테이션이 있어야 함
     * @Service가 있아야 컨테이너에 MemberService를 등록 해줌
     */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm"; // "templates/members/createMemberForm.html"
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member); // join을 통해서 회원 등록

        return "redirect:/"; // 홈 화면으로 돌려보내기
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}


