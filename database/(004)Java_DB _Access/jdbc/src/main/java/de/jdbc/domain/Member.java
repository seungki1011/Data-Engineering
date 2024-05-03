package de.jdbc.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Member {

    private String memberId;
    private int money;

    public Member(String memberId, int money) {
        this.memberId = memberId;
        this.money = money;
    }
}
