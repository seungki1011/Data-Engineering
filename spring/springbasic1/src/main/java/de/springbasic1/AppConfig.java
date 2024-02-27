package de.springbasic1;

import de.springbasic1.discount.DiscountPolicy;
import de.springbasic1.discount.FixDiscountPolicy;
import de.springbasic1.discount.RateDiscountPolicy;
import de.springbasic1.member.MemberRepository;
import de.springbasic1.member.MemberService;
import de.springbasic1.member.MemberServiceImpl;
import de.springbasic1.member.MemoryMemberRepository;
import de.springbasic1.order.OrderService;
import de.springbasic1.order.OrderServiceImpl;

public class AppConfig {
    // 생성자 주입을 통해서 구현체 선택
    
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // 추후에 변경시 이 부분만 수정하면 됨
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 추후에 변경시 이 부분만 수정하면 됨
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy(); // FixDiscount-> RateDiscount로 변경
    }

}
