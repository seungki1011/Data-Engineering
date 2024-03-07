package de.springbasic1.autowired;

import de.springbasic1.AutoAppConfig;
import de.springbasic1.discount.DiscountPolicy;
import de.springbasic1.member.Grade;
import de.springbasic1.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {
    @Test
    void findALlBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "Messi", Grade.VIP);
        int fixDiscountPrice = discountService.discount(member, 20000, "fixDiscountPolicy");

        // fix test
        Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
        Assertions.assertThat(fixDiscountPrice).isEqualTo(1000);

        // rate test
        int rateDiscountPrice = discountService.discount(member, 30000, "rateDiscountPolicy");
        Assertions.assertThat(rateDiscountPrice).isEqualTo(3000);
    }

    static class DiscountService { // 기존 OrderService 대신 사용
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;

        // 생성자 주입
        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
            this.policyMap = policyMap;
            this.policyList = policyList;
            System.out.println("policyMap = "+policyMap);
            System.out.println("policyList = "+policyList);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price);
        }
    }
}
