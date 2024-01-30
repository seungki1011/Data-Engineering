package de.springdemo.domain;

public class Member {
    private Long id; // 데이터를 식별하기 위해 시스템이 정하는 아이디
    private String name;

    // 일단 간단한 예제이기 때문에 Getter Setter 전부 구현
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
