package de.jdbc.repository;

import com.zaxxer.hikari.HikariDataSource;
import de.jdbc.connection.ConnectionConst;
import de.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static de.jdbc.connection.ConnectionConst.*;

@Slf4j
class CPMemberRepositoryTest {

    // DataSource를 주입받아서 사용할 것이다
    // DriverManagerMemberRepository repository = new DriverManagerMemberRepository();

    CPMemberRepository repository;
    @BeforeEach
    void beforeEach() throws Exception {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setMaximumPoolSize(10);
        dataSource.setPoolName("MyPool");

        // CPMemberRepository는 DataSource 의존성 주입이 필요하다
        repository = new CPMemberRepository(dataSource);
    }


    @Test
    void crud() throws SQLException {
        // save()
        Member member = new Member("member1", 10000);
        repository.save(member);

        // findById
        Member findMember = repository.findById(member.getMemberId());
        Assertions.assertThat(findMember).isEqualTo(member);

        // update()
        // money : 10000 -> 30000으로 수정
        repository.update(member.getMemberId(), 30000);
        Member updatedMember = repository.findById(member.getMemberId());
        Assertions.assertThat(updatedMember.getMoney()).isEqualTo(30000);

        // delete()
        repository.delete(member.getMemberId());
        Assertions.assertThatThrownBy(() -> repository.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
    }
}