package de.jdbc.repository;

import de.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@Slf4j
class DriverManagerMemberRepositoryTest {

    DriverManagerMemberRepository repository = new DriverManagerMemberRepository();

    @Test
    void saveTest() throws SQLException {
        Member member = new Member("member1", 10000);
        repository.save(member);
    }

    @Test
    void findTest() throws SQLException {
        Member member = new Member("member2", 20000);
        repository.save(member);
        Member findMember = repository.findById(member.getMemberId());
        log.info("findMember = {}", findMember);
        Assertions.assertThat(findMember).isEqualTo(member);
    }

}