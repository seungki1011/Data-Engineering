package de.springbasic1;

import de.springbasic1.discount.DiscountPolicy;
import de.springbasic1.discount.RateDiscountPolicy;
import de.springbasic1.member.MemberRepository;
import de.springbasic1.member.MemberService;
import de.springbasic1.member.MemberServiceImpl;
import de.springbasic1.member.MemoryMemberRepository;
import de.springbasic1.order.OrderService;
import de.springbasic1.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() { return new RateDiscountPolicy(); }
}
