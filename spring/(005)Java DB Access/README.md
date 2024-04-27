> JDBC, 데이터소스, 커넥션 풀, 트랜잭션에 대하여.

---

## Index

1. [JDBC(Java Database Connectivity)](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(005)Java%20DB%20Access#1-jdbcjava-database-connectivity)
   * [JDBC 소개](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(005)Java%20DB%20Access#11-jdbc-%EC%86%8C%EA%B0%9C)
   * [JDBC 사용 - 1(`DriverManager`)](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(005)Java%20DB%20Access#12-jdbc-%EC%82%AC%EC%9A%A9---1drivermanager)
     * 등록(`insert`)
     * 조회(`select`)
     * 수정, 삭제(`update`, `delete`)
     * 테스트 코드로 동작 확인
   * [JDBC 사용 - 2(`DBCP`)](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(005)Java%20DB%20Access#13-jdbc-%EC%82%AC%EC%9A%A9---2dbcp)
     * `DBCP(커넥션 풀)` 소개
     * `DataSource`
     * 커넥션 풀 사용하기(`HikariDataSource`)
2. [트랜잭션(Transaction)](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(005)Java%20DB%20Access#2-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98transaction)
   * [트랜잭션 복습](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(005)Java%20DB%20Access#21-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EB%B3%B5%EC%8A%B5)
   * [기존 트랜잭션 적용의 문제](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(005)Java%20DB%20Access#22-%EA%B8%B0%EC%A1%B4-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EC%A0%81%EC%9A%A9%EC%9D%98-%EB%AC%B8%EC%A0%9C)
   * [스프링에서의 트랜잭션 처리](https://github.com/seungki1011/Data-Engineering/tree/main/spring/(005)Java%20DB%20Access#23-%EC%8A%A4%ED%94%84%EB%A7%81%EC%97%90%EC%84%9C%EC%9D%98-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EC%B2%98%EB%A6%AC)
     * `PlatformTransactionManager`
     * `TransactionTemplate`
     * `@Transactional`(트랜잭션 AOP)

---

## 1) JDBC(Java Database Connectivity)

### 1.1 JDBC 소개

JDBC의 등장 배경부터 살펴보자.

기존 자바 애플리케이션에서 데이터베이스에 접근하기 위해서는 특정 벤더가 제공해주는 API를 사용했다 (또는 ODBC). 문제는 이런 데이터베이스의 사용법은 각각의 벤더마다 달랐다.

<br>

<p align="center">   <img src="img/beforejdbc1.png" alt="jdbc" style="width: 100%;"> </p>

<p align='center'>JDBC 이전</p>

이러한 문제를 해결하기 위해서 JDBC라는 자바 표준 인터페이스가 등장한다.

<br>

<p align="center">   <img src="img/jdbc1.png" alt="jdbc" style="width: 100%;"> </p>

<p align='center'>JDBC 인터페이스</p>

* JDBC(Java Database Connectivity)는 자바에서 데이터베이스에 접속할 수 있도록 하는 자바 API
* JDBC는 데이터베이스에서 자료를 쿼리하거나 업데이트하는 방법을 제공한다



* JDBC는 다음 3가지 기능을 표준 인터페이스로 정의해서 제공한다
  * `java.sql.Connection` - 연결
  * `java.sql.Statement` - SQL을 담은 내용
  * `java.sql.ResultSet` - SQL 요청 응답



* JDBC에는 `JDBC-ODBC bridge Driver`, `Native-API Driver`, `Network Protocol Driver`, `Thin Driver` 의 4가지 드라이버가 존재한다. 여기서 `Thin Driver`를 보편적으로 많이 사용한다
* 참고 : [https://www.javatpoint.com/jdbc-driver#](https://www.javatpoint.com/jdbc-driver#)

<br>

<p align="center">   <img src="img/afterjdbc1.png" alt="jdbc" style="width: 100%;"> </p>

<p align='center'>JDBC 이후</p>

* JDBC 인터페이스를 사용하기 위해서는 각 DB 벤더에서 DB에 맞게 구현한 라이브러리로 제공한다. 이를 JDBC 드라이버라고 한다.
* JDBC의 등장으로 2가지 문제가 해결되었다
  * 데이터베이스 벤더를 변경시 애플리케이션 서버의 데이터베이스 코드도 변경해야하는 문제. 애플리케이션은 JDBC 인터페이스만 의존하기 때문에, 구현 라이버러리만 변경하고 애플리케이션 서버의 코드를 유지할 수 있다
  * 각 벤더사의 사용법을 새로 익혀야 했던 문제

<br>

> JDBC의 한계
>
> * 각각의 데이터베이스 마다 SQL이나 데이터타입의 사용법이 일부 다르다
> * JDBC 코드는 변경하지 않더라도, SQL은 해당 데이터베이스에 맞게 사용해야 한다
> * 반복되는 보일러 플레이트(boiler-plate) 코드가 많다
>
> <br>
>
> 추후에도 설명하겠지만 이를 위해서 SQL Mapper 기술인 JdbcTemplate 그리고 ORM 기술인 JPA(Java Persistence API)를 사용할 수 있다.
>
> 이런 기술들도 결국에 JDBC를 이용해서 동작하기 때문에, JDBC의 사용법을 알아두는 것은 중요하다.

<br>

---

### 1.2 JDBC 사용 - 1(`DriverManager`)

JDBC의 사용법에 대해서 알아보자. (`DriverManager` 사용)

먼저 MySQL 컨테이너를 만들고 스프링 부트 애플리케이션에 연결해보자.

* [컨테이너를 설정하고 실행하는 방법](../../container/(001)Docker#4-docker-compose)

<br>

`build.gradle`에 `runtimeOnly 'com.mysql:mysql-connector-j'` 추가

```groovy
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-jdbc'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	runtimeOnly 'com.mysql:mysql-connector-j'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'

	testCompileOnly 'org.projectlombok:lombok'
	testAnnotationProcessor 'org.projectlombok:lombok'
}
```

<br>

데이터베이스 이름은 `test_database`로 하자.

`resources/schema.sql` 파일을 만들자.

```sql
drop table if exists member;

create table member (
     member_id varchar(10),
     money integer not null default 0,
     primary key (member_id)
);

insert into member(member_id, money) values ('hi1',10000);
insert into member(member_id, money) values ('hi2',20000);
```

* 초기 데이터 입력은 `data.sql`에 정의하는것이 권장 되지만, 편의상 `schema.sql`에 그냥 쿼리 작성 함

<br>

`member` 테이블을 조회하면 다음과 같이 쿼리 결과가 나와야한다.

```
mysql> select * from member;
+-----------+-------+
| member_id | money |
+-----------+-------+
| hi1       | 10000 |
| hi2       | 20000 |
+-----------+-------+
```

<br>

---

#### 1.2.1 데이터베이스 연결

JDBC의 `DriverManager`를 통한 연결에 대해서 알아보자.

<br>

<p align="center">   <img src="img/jdbcconnection.png" alt="jdbc" style="width: 80%;"> </p>

* MySQL 드라이버는 JDBC의 `java.sql.Connection` 인터페이스를 구현한 `com.mysql.cj.jdbc.ConnectionImpl`이라는 구현체를 제공

<br>

<p align="center">   <img src="img/drivermanager.png" alt="jdbc" style="width: 100%;"> </p>

<p align='center'>DriverManager 커넥션 요청 흐름</p>

* `DriverManager`는 라이브러리에 등록된 데이터베이스 드라이버들을 관리하고, 커넥션을 획득하는 기능을 제공한다

<br>

이제 데이터베이스에 연결하기 위한 코드를 작성해보자.

MySQL 데이터베이스에 접속하기 위한 상수 정의.

```java
public abstract class ConnectionConst {
  
    public static final String URL = "jdbc:mysql://localhost:3306/test_database?serverTimezone=Asia/Seoul";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "admin";

}
```

* 뒤에서 다루겠지만, 스프링 부트를 이용하는 경우 `application.properties`에 데이터베이스의 속성 설정하고, `DataSource`를 의존성 주입으로 받아서 사용가능
* 쉽게 말해서 `application.properties`에 속성 등록하면 `DataSource`를 자동으로 생성해준다

<br>

JDBC를 사용해서 실제로 데이터베이스 연결하는 코드를 작성해보자.

```java
@Slf4j
public class DBConnectionUtil {
  
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // ConnectionConst 상수 static import 처리
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("get connection={}, class={}", connection, connection.getClass());
            return connection;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
```

* 데이터베이스에 연결하기 위해서 JDBC가 제공하는 `DriverManager.getConnection()`을 사용
* `getConnection()`은 라이브러리에 있는 데이터베이스 드라이버를 찾아서 해당 드라이버가 제공하는 커넥션 반환

<br>

동작을 확인하기 위한 테스트 코드를 작성해보자.

```java
@Slf4j
public class DBConnectionUtilTest {

    @Test
    void connection() {
        Connection connection = DBConnectionUtil.getConnection();
        Assertions.assertThat(connection).isNotNull();
    }
}
```

```
[main] INFO de.jdbc.connection.DBConnectionUtil -- get connection=com.mysql.cj.jdbc.ConnectionImpl@c94fd30, class=class com.mysql.cj.jdbc.ConnectionImpl
```

* `com.mysql.cj.jdbc.ConnectionImpl` : MySQL 드라이버가 제공하는 MySQL 전용 커넥션

<br>

---

#### 1.2.2 등록(`insert`)

`Member` 데이터를 데이터베이스에 등록하는 기능을 JDBC를 사용해서 개발해보자.

<br>

```java
@Data
@NoArgsConstructor
public class Member {

    private String memberId;
    private int money;

}
```

* 롬복의 `@Data` :  `@RequiredArgsConstructor`, `@Getter`, `@Setter`, `@ToString`, `@EqualsAndHashCode` 포함
* `memberId` : 회원의 아이디
* `money` : 회원이 소지한 금액

<br>

회원 객체를 데이터베이스에 저장하는 코드를 작성해보자.

```java
/**
 * DriverManager 사용
 */
@Slf4j
public class DriverManagerMemberRepository {

    public Member save(Member member) throws SQLException {
        String sql = "insert into member(member_id, money) values(?, ?)";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            // 파라미터 바인딩
            pstmt.setString(1, member.getMemberId());
            pstmt.setInt(2, member.getMoney());
          	// 쿼리 실행
            pstmt.executeUpdate();
            return member;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            // 외부 자원 해제
            close(con, pstmt, null);
        }

    }

    // 할당된 자원의 해제 과정 중에 예외 발생에 대한 처리를 해야 안정적인 코드
    private void close(Connection con, Statement stmt, ResultSet rs) {
        
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }

        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }

        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
    }
		
    private static Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }
}
```

* `getConnection()` : `DBConnectionUtil`를 통해서 데이터베이스 커넥션을 획득
* `sql` : 데이터베이스에 전달할 쿼리 정의



* `con.prepareStatement(sql)` : 데이터베이스에 전달할 SQL과 파라미터로 전달할 데이터들을 준비
  * 각 `?`에 바인딩할 값 지정



* `pstmt.executeUpdate()` : `Statement`를 통해 준비된 `sql`을 커넥션을 통해 데이터베이스에 전달
  * 데이터 추가, 변경에는 `executeUpdate()` 사용하면 됨



* `close()` : 쿼리 실행후 리소스 정리. 리소스 정리는 항상 역순으로 진행
  * `ResultSet`은 나중에 결과 조회 때 사용한다



* SQL 인젝션을 방지하기 위해서 `PreparedStatement`의  `?`를 통한 파라미터 바인딩 방식을 사용한다

<br>

---

#### 1.2.3 조회(`select`)

데이터베이스에 저장한 데이터를 조회하는 기능을 개발해보자.

<br>

회원을 조회하는 코드를 추가하자.

```java
public Member findById(String memberId) throws SQLException {
    String sql = "select * from member where member_id = ?";

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        con = getConnection();
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, memberId);
        // 데이터 조회를 위해서는 executeQuery() 사용 
        rs = pstmt.executeQuery();
				
      	// 목적은 회원 하나를 찾아서 조회
        if (rs.next()) {
            Member member = new Member();
            member.setMemberId(rs.getString("member_id"));
            member.setMoney(rs.getInt("money"));
            return member;
        } else {
            throw new NoSuchElementException("member not found! memberId = " + memberId);
        }
    } catch (SQLException e) {
        log.error("DB error", e);
        throw e;
    } finally {
        close(con, pstmt, rs);
    }
}
```

* `executeQuery()`는 결과를 `ResultSet`에 담아서 반환한다
* `ResultSet`의 모양은 아래 그림과 같다

<br>

<p align="center">   <img src="img/resultset.png" alt="jdbc" style="width: 100%;"> </p>

* `findById()`의 목적은 회원 하나를 찾아서 조회하는 것이기 때문에, `if`를 사용해서 `member` 반환

<br>

---

#### 1.2.4 수정, 삭제(`update`, `delete`)

데이터베이스에 등록된 데이터를 수정 또는 삭제해보자.

<br>

다음 코드를 추가하자.

```java
public void update(String memberId, int money) throws SQLException {
    String sql = "update member set money=? where member_id=?";

    Connection con = null;
    PreparedStatement pstmt = null;

    try {
        con = getConnection();
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, money);
        pstmt.setString(2, memberId);
        int resultSize = pstmt.executeUpdate();
        log.info("resultSize = {}", resultSize);
    } catch (SQLException e) {
        log.error("DB error", e);
    } finally {
        close(con, pstmt, null);
    }
}

public void delete(String memberId) throws SQLException {
    String sql = "delete from member where member_id=?";

    Connection con = null;
    PreparedStatement pstmt = null;

    try {
        con = getConnection();
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, memberId);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        log.error("DB error", e);
        throw e;
    } finally {
        close(con, pstmt, null);
    }
}
```

* `executeUpdate()`은 쿼리 실행 후 영향받은 row의 수를 반환한다
  * 위의 경우에서는 회원 하나의 데이터만 변경하기 때문에 `1`을 반환한다

<br>

---

#### 1.2.5 테스트 코드로 동작 확인

테스트 코드로 지금까지 작성한 기능들의 동작을 확인해보자.

```java
@Slf4j
class DriverManagerMemberRepositoryTest {

    DriverManagerMemberRepository repository = new DriverManagerMemberRepository();

    @Test
    void crud() throws SQLException {
        // save()
        Member member = new Member("member1", 10000);
        repository.save(member);

        // findById()
        Member findMember = repository.findById(member.getMemberId());
        log.info("findMember = {}", findMember);
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
```

<br>

---

### 1.3 JDBC 사용 - 2(`DBCP`)

#### 1.3.1 `DBCP(커넥션 풀)` 소개

데이터베이스 커넥션 방법인 DBCP(Database Connection Pool)에 대해서 알아보자.

먼저 기존 데이터베이스 커넥션 방법의 단점에 대해서 알아보자.

<br>

<p align="center">   <img src="img/dbcp1.png" alt="jdbc" style="width: 100%;"> </p>

<p align='center'>기존 커넥션 방식</p>

* 커넥션 획득 과정은 `TCP/IP` 연결 및 해제를 포함한 복잡한 과정을 거친다
* 매요청 마다 커넥션을 새로 만들어야 하고 `TCP/IP`의 연결도 획득해야하기 때문에 결과적으로 응답 속도에 영향을 준다
* 이런 문제를 해결하기 위해서 `커넥션 풀(DBCP)`이라는 방법을 사용한다

<br>

커넥션 풀을 다음 그림을 통해서 알아보자.

<p align="center">   <img src="img/dbcp3.png" alt="jdbc" style="width: 100%;"> </p>

<p align='center'>DBCP</p>

* `커넥션 풀`은 이름 그대로, 커넥션들을 미리 만들어두고 풀에 모아두는 방식이다
* `커넥션 풀`에 들어있는 커넥션은 TCP/IP로 연결이 되어있는 상태이기 때문에 언제든지 쿼리를 DB에 전달 가능하다
* 기존 커넥션을 획득하던 방법과 달리, `커넥션 풀`을 통해 이미 생성되어 있는 커넥션을 객체 참조로 가져다 쓰면 된다
* 애플리케이션 로직은 `커넥션 풀`에서 받은 커넥션을 이용해서 쿼리를 전달하고 결과를 처리한다
* 이제 커넥션 종료(`close()`)는 커넥션을 `커넥션 풀`로 다시 돌려주는 것이다



* `커넥션 풀`로 얻을 수 있는 이점이 크기 때문에 실무에서는 기본으로 사용한다
* `커넥션 풀`에서 설정하는 `maximumPoolSize`나 데이터베이스에서 설정할 수 있는 `max_connections`과 같은 값은 성능 테스트를 통해서 정해야 한다



* `커넥션 풀`을 구현한 오픈소스 중에서 `hikariCP`를 주로 사용한다

<br>

---

#### 1.3.2 `DataSource`

커넥션 풀을 사용하는 방법에 대해서 알아보기 전에 `DataSource` 인터페이스에 대해서 알아보자.

커넥션을 얻는 방법은 앞서 소개한 JDBC `DriverManager`를 직접 사용하거나, `커넥션 풀`을 사용하는 등 다양한 방법이 존재한다.

만약 우리가 커넥션을 획득하는 방법을 `DriverManager`에서 `커넥션 풀`로 변경한다면, 해당 애플리케이션 코드로 변경해야 한다. 자바는 이런 문제를 해결하기 위해서 `DataSource`라는 인터페이스를 제공한다. `DataSource` 인터페이스는 커넥션을 획득하는 방법을 추상화한 인터페이스이다.

<br>

<p align="center">   <img src="img/ds2.png" alt="jdbc" style="width: 90%;"> </p>

<p align='center'>DataSource 인터페이스</p>

<br>

그럼 간단하게 `DataSource`가 적용된 `DriverManager`인 `DriverManagerDataSource`를 사용하는 테스트 코드를 작성해보자. (스프링이 제공하는 코드임)

```java
@Slf4j
public class DriverManagerDataSourceTest {

    @Test
    void driverManager() throws SQLException {
        Connection con1 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Connection con2 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        log.info("connection={}, class={}", con1, con1.getClass());
        log.info("connection={}, class={}", con2, con2.getClass());
    }

    @Test
    void dataSourceDriverManager() throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
        useDataSource(dataSource);
    }

    private void useDataSource(DataSource dataSource) throws SQLException {
        Connection con1 = dataSource.getConnection();
        Connection con2 = dataSource.getConnection();
        log.info("connection={}, class={}", con1, con1.getClass());
        log.info("connection={}, class={}", con2, con2.getClass());
    }
  
}
```

```
14:38:55.167 [main] INFO de.jdbc.connection.DriverManagerDataSourceTest -- connection=com.mysql.cj.jdbc.ConnectionImpl@2c4d1ac, class=class com.mysql.cj.jdbc.ConnectionImpl
14:38:55.168 [main] INFO de.jdbc.connection.DriverManagerDataSourceTest -- connection=com.mysql.cj.jdbc.ConnectionImpl@2ef14fe, class=class com.mysql.cj.jdbc.ConnectionImpl
14:38:55.210 [main] INFO de.jdbc.connection.DriverManagerDataSourceTest -- connection=com.mysql.cj.jdbc.ConnectionImpl@3d1848cc, class=class com.mysql.cj.jdbc.ConnectionImpl
14:38:55.210 [main] INFO de.jdbc.connection.DriverManagerDataSourceTest -- connection=com.mysql.cj.jdbc.ConnectionImpl@7dda48d9, class=class com.mysql.cj.jdbc.ConnectionImpl
```

* `Connection con1 = DriverManager.getConnection(URL, USERNAME, PASSWORD);`
  * 기존 `DriverManager`를 사용했을때는 커넥션을 획득할 때 마다 필요한 파라미터를 계속 명시했어야 함



* `DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);`
* `Connection con1 = dataSource.getConnection();`
  * `DataSource`를 사용하는 방식은 처음 객체 생성때만 파라미터를 명시하고, 커넥션 획득 시에는 단순히 `dataSource.getConnection()`으로 획득 가능 함 



* `DataSource`를 사용하는 방식은 필요한 속성을 설정하는 곳과 사용하는 곳을 분리할 수 있도록 해준다

<br>

> `application.properties`
>
> ```properties
> spring.application.name=jdbc
> # spring 2.5.x 부터 deprecated
> # spring.datasource.initialization-mode=always
> # 애플리케이션 시작시 schema.sql 적용
> spring.sql.init.mode=always
> spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
> # 3306 포트의 mysql의 test_database라는 엔드포인트 설정
> # 스프링 부트는 아래의 속성으로 DataSource 자동 빈 등록
> spring.datasource.url=jdbc:mysql://localhost:3306/test_database?serverTimezone=Asia/Seoul
> spring.datasource.username=root
> spring.datasource.password=admin
> ```
>
> * 스프링 부트는 `DataSource`를 스프링 빈에 자동으로 등록한다
> * 이때 스프링 부트는 `application.properties`에 있는 속성을 이용해서 `DataSource`를 생성한다
>
> <br>

<br>

---

#### 1.3.3 커넥션 풀 사용하기(`HikariDataSource`)

기존에 사용하던 코드를 `HikariCP`를 사용하도록 작성해보자.

먼저 `DataSource`를 적용해보자.

<br>

```java
/**
 * DataSource, JdbcUtils 사용
 */
@Slf4j
public class CPMemberRepository {
		
    private final DataSource dataSource;
		// DataSource 주입받아서 사용
    public CPMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Member save(Member member) throws SQLException {
        String sql = "insert into member(member_id, money) values(?, ?)";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getMemberId());
            pstmt.setInt(2, member.getMoney());
            pstmt.executeUpdate();
            return member;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }

    public void update(String memberId, int money) throws SQLException {
        String sql = "update member set money=? where member_id=?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, money);
            pstmt.setString(2, memberId);
            int resultSize = pstmt.executeUpdate();
            log.info("resultSize = {}", resultSize);
        } catch (SQLException e) {
            log.error("DB error", e);
        } finally {
            close(con, pstmt, null);
        }
    }

    public void delete(String memberId) throws SQLException {
        String sql = "delete from member where member_id=?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            log.error("DB error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }

    public Member findById(String memberId) throws SQLException {
        String sql = "select * from member where member_id = ?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                Member member = new Member();
                member.setMemberId(rs.getString("member_id"));
                member.setMoney(rs.getInt("money"));
                return member;
            } else {
                throw new NoSuchElementException("member not found! memberId = " + memberId);
            }
        } catch (SQLException e) {
            log.error("DB error", e);
            throw e;
        } finally {
            close(con, pstmt, rs);
        }
    }

    // JdbcUtils로 close를 편리하게 구현
    private void close(Connection con, Statement stmt, ResultSet rs) {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);
        JdbcUtils.closeConnection(con);
    }

    private Connection getConnection() throws SQLException {
        Connection con = dataSource.getConnection();
        log.info("get connection={}, class={}", con, con.getClass());
        return con;
    }
}
```

* 외부에서 `DataSource`를 주입받아서 사용하도록 변경했다
* `JdbcUtils`를 통해서 `close()`를 더 편리하게 구현

<br>

`DataSource`를 사용하는 `CPMemberRepository`에 `HikariDataSource`를 사용하는 테스트 코드를 작성해보자.

```java
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

        // CPMemberRepository는 DataSource 주입이 필요하다
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
```

```
15:24:28.246 [main] INFO com.zaxxer.hikari.HikariDataSource -- MyPool - Starting...
15:24:28.458 [main] INFO com.zaxxer.hikari.pool.HikariPool -- MyPool - Added connection com.mysql.cj.jdbc.ConnectionImpl@4b6e2263
15:24:28.458 [main] INFO com.zaxxer.hikari.HikariDataSource -- MyPool - Start completed.
15:24:28.460 [main] INFO de.jdbc.repository.CPMemberRepository -- get connection=HikariProxyConnection@1866229258 wrapping com.mysql.cj.jdbc.ConnectionImpl@4b6e2263, class=class com.zaxxer.hikari.pool.HikariProxyConnection
15:24:28.494 [main] INFO de.jdbc.repository.CPMemberRepository -- get connection=HikariProxyConnection@1632497828 wrapping com.mysql.cj.jdbc.ConnectionImpl@4b6e2263, class=class com.zaxxer.hikari.pool.HikariProxyConnection
15:24:28.526 [main] INFO de.jdbc.repository.CPMemberRepository -- get connection=HikariProxyConnection@1060703587 wrapping com.mysql.cj.jdbc.ConnectionImpl@4b6e2263, class=class com.zaxxer.hikari.pool.HikariProxyConnection
15:24:28.532 [main] INFO de.jdbc.repository.CPMemberRepository -- resultSize = 1
15:24:28.532 [main] INFO de.jdbc.repository.CPMemberRepository -- get connection=HikariProxyConnection@1514214932 wrapping com.mysql.cj.jdbc.ConnectionImpl@4b6e2263, class=class com.zaxxer.hikari.pool.HikariProxyConnection
15:24:28.534 [main] INFO de.jdbc.repository.CPMemberRepository -- get connection=HikariProxyConnection@1317375498 wrapping com.mysql.cj.jdbc.ConnectionImpl@4b6e2263, class=class com.zaxxer.hikari.pool.HikariProxyConnection
15:24:28.537 [main] INFO de.jdbc.repository.CPMemberRepository -- get connection=HikariProxyConnection@1202220987 wrapping com.mysql.cj.jdbc.ConnectionImpl@4b6e2263, class=class com.zaxxer.hikari.pool.HikariProxyConnection
```

* `HikariCP` 사용시 같은 커넥션인 `ConnectionImpl@4b6e2263`이 계속 재사용 되는 것을 확인 가능
  * 사용하던 커넥션을 되돌려주고 다시 가져와서 사용되는 것이 반복되는 모습이다
  * 동시다발적으로 여러 요청이 들어오는 경우에는 커넥션 풀의 커넥션을 다양하게 가져간다

<br>

---

## 2) 트랜잭션(Transaction)

> 해당 파트는 트랜잭션에 대한 기본적인 내용을 알고 있다는 전제하에 진행.
>
> [트랜잭션에 대해서 알아보기](../../database/(003)%20Relational%20Database%202#1-transaction)

<br>

### 2.1 트랜잭션 복습

데이터베이스의 연결구조는 다음과 같다.

<br>

<p align="center">   <img src="img/dbtransaction.png" alt="jdbc" style="width: 100%;"> </p>

* 커넥션 마다 세션이 만들어진다
* 커넥션을 통해서 들어온 요청은 세션을 통해서 실행하게 됨

<br>

트랜잭션을 적용한 비즈니스 로직을 구현하기 전에 간단히 트랜잭션의 몇 가지 특징을 살펴보고 가자.

* 원자성(atomicity) : 트랜잭션 내에서 실행한 작업들은 마치 하나의 작업인 것처럼 모두 성공 하거나 모두 실패해야 한다
* 격리성(isolation) : 동시에 실행되는 트랜잭션들이 서로에게 영향을 미치지 않도록 격리한다
  * 격리성은 동시성과 관련된 성능 이슈로 인해 트랜잭션 격리 수준(Isolation level)을 선택할 수 있다
  * 일반적으로 `READ COMMITTED(커밋된 읽기)`를 많이 사용



* 많은 경우 데이터베이스들은 `autocommit`이 `true`로 설정되어 있다. 그래서 `autocommit`을 `false`로 설정하는 것을 트랜잭션을 시작하는 것으로 표현할 수도 있다.
* 트랜잭션 모드에서는 이후에 꼭 `commit`이나 `rollback`을 호출해야 한다



* 원자성이 깨지는 것을 방지하기 위해 [`DB 락`](../../database/(003)%20Relational%20Database%202#4-lock)을 사용한다
* `SET LOCK_TIMEOUT <milliseconds>` : 락 타임아웃 시간을 설정해서 특정 세션이 무한히 대기하는 현상을 방지할 수 있다

<br>

---

### 2.2 기존 트랜잭션 적용의 문제

서비스 계층의 특징을 알아보고, 기존 트랜잭션을 스프링 없이 적용하는 경우의 문제에 대해서 알아보자.

<br>

<p align="center">   <img src="img/tran1.png" alt="jdbc" style="width: 100%;"> </p>

* 트랜잭션은 비즈니스 로직이 있는 서비스 계층에서 시작해야 함
  * 비즈니스 로직에 문제가 생기는 경우 해당 부분 롤백



* 트랜잭션 동안은 같은 커넥션 유지

<br>

<p align="center">   <img src="img/servicelayer.png" alt="jdbc" style="width: 100%;"> </p>

<p align='center'>서비스 계층</p>

* 서비스 계층
  * 비즈니스 로직을 담당한다
  * 가급적이면 순수한 자바 코드로 작성하는 것이 좋다
  * 서비스 계층이 다른 계층에 종속적이면 안된다
    * 예) 데이터 접근 계층에서 `JDBC`에서 `JPA`를 사용하도록 기술을 변경해도, 서비스 계층의 변경은 최소화 되도록 설계해야 함

<br>

* 스프링을 이용하기 전까지는 트랜잭션을 적용하려면, 어쩔 수 없이 서비스 계층에서 `JDBC`에 의존하게 되었음
* 커넥션을 유지하기 위해서 커넥션을 파라미터 형태로 계속 넘겨야함
* `JDBC`의 보일러 플레이트 코드의 양이 많음(계속 반복되는 코드가 많음)
* 스프링을 통해서 이런 문제를 해결 가능

<br>

---

### 2.3 스프링에서의 트랜잭션 처리

스프링에서 트랜잭션을 적용하는 방법에 대해서 알아보자.

#### 2.3.1 `PlatformTransactionManager`

기존의 문제점의 원인 중 하나는, 구현 기술 마다 트랜잭션을 사용하는 방법이 다르기 때문이다. 서비스 계층이 특정 구현 기술에 종속적이면, 기술을 변경하는 경우 서비스 계층의 코드도 몽땅 바꿔야하는 대참사가 벌어진다.

이를 해결하기 위해서, 트랜잭션 기능을 추상화하는 인터페이스가 있으면 된다. 스프링은 이런 문제를 해결하기 위해서 `PlatformTransactionManager`이라는 인터페이스를 제공한다.

<br>

```java
public interface PlatformTransactionManager extends TransactionManager {

	TransactionStatus getTransaction(@Nullable TransactionDefinition definition) throws TransactionException;

	void commit(TransactionStatus status) throws TransactionException;
	void rollback(TransactionStatus status) throws TransactionException;
}
```

* `getTransaction()` : 트랜잭션 시작
  * 진행중인 트랜잭션이 있는 경우 해당 트랜잭션에 참여할 수도 있다(트랜잭션의 전파에서 설명)
* `commit()` : 트랜잭션을 커밋
* `rollback()` : 트랜잭션은 롤백

<br>

이 트랜잭션 매니저는 크게 2 가지의 역할을 한다.

1. 트랜잭션 추상화
   * 앞에서 설명한 메서드 제공

2. 리소스 동기화
   * 트랜잭션을 유지하기 위해서는 같은 데이터베이스 커넥션을 유지해야함(동기화)
   * `트랜잭션 매니저`는 `트랜잭션 동기화 매니저`(`TransactionSynchronizationManager`)를 사용해서 커넥션을 보관해서 사용한다
   * `트랜잭션 동기화 매니저`는 `ThreadLocal`을 사용해서 커넥션을 동기화해준다

<br>

---

#### 2.3.2 `TransactionTemplate`

트랜잭션을 사용하는 로직이 계속 반복되는 문제가 있었다. 코드를 살펴보면 비즈니스 로직만 달라지고, 트랜잭션 관련 부분은 계속 변함이 없다.

```java
TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

try {
	// 비즈니스 로직
	bizLogic(fromId, toId, money); // 이 부분만 변경되고, 나머지 트랜잭션 관련 부분은 항상 반복됨
	transactionManager.commit(status); // 성공시 커밋 
} catch (Exception e) {
	transactionManager.rollback(status); // 실패시 롤백
  throw new IllegalStateException(e);
}
```

<br>

스프링은 이 문제를 해결하기 위해서 `TransactionTemplate`이라는 템플릿 클래스를 제공한다.(템플릿 콜백 패턴 찾아보기)

<br>

```java
public class TransactionTemplate extends DefaultTransactionDefinition
	implements TransactionOperations, InitializingBean {

	protected final Log logger = LogFactory.getLog(getClass());

	@Nullable
	private PlatformTransactionManager transactionManager;

	public TransactionTemplate() {
	}

	public TransactionTemplate(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public TransactionTemplate(PlatformTransactionManager transactionManager, TransactionDefinition transactionDefinition) {
		super(transactionDefinition);
		this.transactionManager = transactionManager;
	}


	/**
	 * Set the transaction management strategy to be used.
	 */
	public void setTransactionManager(@Nullable PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	/**
	 * Return the transaction management strategy to be used.
	 */
	@Nullable
	public PlatformTransactionManager getTransactionManager() {
		return this.transactionManager;
	}

	@Override
	public void afterPropertiesSet() {
		if (this.transactionManager == null) {
			throw new IllegalArgumentException("Property 'transactionManager' is required");
		}
	}

	@Override
	@Nullable
	public <T> T execute(TransactionCallback<T> action) throws TransactionException {
	// ...
	}

	private void rollbackOnException(TransactionStatus status, Throwable ex) throws TransactionException {
	// ...
	}

	@Override
	public boolean equals(@Nullable Object other) {
		return (this == other || (super.equals(other) && (!(other instanceof TransactionTemplate template) ||
				getTransactionManager() == template.getTransactionManager())));
	}

}
```

* `execute()` : 응답 값이 있을 때 사용한다
* `executeWithoutResult()` : 응답 값이 없을 때 사용한다
* 트랜잭션 템플릿을 적용하면, 반복되는 트랜잭션의 보일러 플레이트 코드를 상당수 제거 가능

<br>

---

#### 2.3.3 `@Transactional`(트랜잭션 AOP)

지금까지 `PlatformTransactionManager`, 그리고 `TransactionTemplate`을 통해서 특정 기술에 대한 종속성을 제거하고, 반복되는 트랜잭션 코드도 제걸할 수 있다는 것을 알 수 있다. 그러나 이것이 서비스 계층에 순수하게 비즈니스 로직만 남았다는 것은 아니다. 

이를 해결하기 위해서 스프링 AOP를 통해서 프록시를 도입해서 해결할 수 있다.

<br>

<p align="center">   <img src="img/transactional.png" alt="jdbc" style="width: 100%;"> </p>

<p align='center'>Transaction AOP</p>

* 프록시를 도입해서 위와 같이 서비스 계층에서 트랜잭션 로직을 분리하는 것이 목표
* 스프링이 제공하는 AOP 기능을 이용하면 프록시를 편리하게 적용 가능
  * 사실 스프링은 이미 `@Transactional`이라는 기능을 제공해준다
  * 트랜잭션이 필요한 곳에 `@Transactional` 애노테이션만 붙여주면 스프링은 트랜잭션 프록시를 적용해줌

<br>

---

## Further Reading

* `hikariCP`
  * 파라미터 설정

* 데이터베이스의 `DBCP` 관련 파라미터 설정
  * `max_connections`




---

## Reference

1. [https://www.javatpoint.com/jdbc-driver#](https://www.javatpoint.com/jdbc-driver#)
