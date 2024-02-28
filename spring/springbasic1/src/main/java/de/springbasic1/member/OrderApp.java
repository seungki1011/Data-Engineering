package de.springbasic1.member;

import de.springbasic1.AppConfigJava;
import de.springbasic1.order.Order;
import de.springbasic1.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfigJava appConfig = new AppConfigJava();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        long memberId = 1L;
        Member member = new Member(memberId, "messi", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
    }
}
