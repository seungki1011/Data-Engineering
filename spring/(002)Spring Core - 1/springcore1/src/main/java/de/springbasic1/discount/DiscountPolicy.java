package de.springbasic1.discount;

import de.springbasic1.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액 (호출시 할인 금액을 리턴)
     */
    int discount(Member member, int price);
}
