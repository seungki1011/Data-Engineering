package de.springdemo;

import de.springdemo.repository.MemberRepository;
import de.springdemo.repository.MemoryMemberRepository;
import de.springdemo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository(); // MemberRepository의 구현체
    }
}
