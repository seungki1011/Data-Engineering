package de.springdemo.repository;

import de.springdemo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원을 저장소에 저장
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 지금까지 저장한 모든 회원 리스트 반환
}
