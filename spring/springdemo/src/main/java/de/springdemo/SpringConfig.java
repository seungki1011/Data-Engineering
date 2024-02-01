package de.springdemo;

import de.springdemo.repository.JdbcTemplateMemberRepository;
import de.springdemo.repository.JpaMemberRepository;
import de.springdemo.repository.MemberRepository;
import de.springdemo.repository.MemoryMemberRepository;
import de.springdemo.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    // @Autowired DataSource dateSource;
//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//  원래는 @PersistenceContext 사용
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcTemplateMemberRepository(dataSource); // 단순히 이 부분만 변경하는 걸로 확장이 가능함
        return new JpaMemberRepository(em);
    }
}
