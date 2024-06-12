> 데이터베이스에 대한 이론, SQL 기초 및 실습
>
> NoSQL 데이터베이스 소개, 사용법
>
> 참고 자료 및 강의
>
> * [한국 데이터 산업 진흥원 - SQL 전문가 가이드](https://dataonair.or.kr/db-tech-reference/d-guide/sql/) 
> * [인프런 - 쉬운코드 데이터베이스](https://www.inflearn.com/course/%EB%B0%B1%EC%97%94%EB%93%9C-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-%EA%B0%9C%EB%A1%A0/dashboard)
> * [인프런 - 김영한 : 스프링 완전 정복](https://www.inflearn.com/roadmaps/373)
> * [MongoDB - Using MongoDB with Java](https://learn.mongodb.com/learn/learning-path/using-mongodb-with-java?sessionFields=%5B%5B%22certifiction%22%2C%22Course%22%5D%2C%5B%22programming-language%22%2C%22Java%22%5D%5D)

---

## Index

### [1) RDBMS I](https://github.com/seungki1011/Data-Engineering/tree/main/database/(001)%20Relational%20Database)

1. [데이터베이스(Database, DB) 소개]((001)%20Relational%20Database#1-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4database-%EC%86%8C%EA%B0%9C)
   * 데이터베이스의 정의
   * 데이터베이스 관리 시스템(DBMS)
   * 메타데이터(Metadata)
2. [Modeling]((001)%20Relational%20Database#2-modeling)
   * 데이터 모델링의 정의
   * 데이터 모델링의 3단계
   * 데이터 독립성(Data Independence)
3. [Entity, Attribute, Relationship]((001)%20Relational%20Database#3-entity-attribute-relationship)
   * 엔티티(Entity)
   * 속성(Attribute)
   * 관계(Relationship)
4. [식별자(Identifier)]((001)%20Relational%20Database#4-%EC%8B%9D%EB%B3%84%EC%9E%90identifier)
   * 식별자의 정의
   * 식별자의 분류
   * 주식별자의 특징
   * 식별자와 비식별자 관계
5. [테이블(Table), 키(Key)]((001)%20Relational%20Database#5-%ED%85%8C%EC%9D%B4%EB%B8%94table-%ED%82%A4key)
   * 테이블(Table)
   * 키(Key)의 정의
   * 키(Key)의 종류
6. [성능 데이터 모델링]((001)%20Relational%20Database#6-%EC%84%B1%EB%8A%A5-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EB%AA%A8%EB%8D%B8%EB%A7%81)
   * 성능 데이터 모델링의 정의
   * 성능 데이터 모델링의 수행 시점
   * 성능 데이터 모델링의 고려 사항
7. [정규화(Normalization)]((001)%20Relational%20Database#7-%EC%A0%95%EA%B7%9C%ED%99%94normalization)
   * 정규화의 정의
   * 잘못된 구조의 테이블
   * 정규화와 성능
   * [함수적 종속성(Functional Dependency, FD)]((001)%20Relational%20Database#74-%ED%95%A8%EC%88%98%EC%A0%81-%EC%A2%85%EC%86%8D%EC%84%B1functional-dependency-fd)
   * [정규화의 단계]((001)%20Relational%20Database#75-%EC%A0%95%EA%B7%9C%ED%99%94%EC%9D%98-%EB%8B%A8%EA%B3%84)
8. [반정규화(Denormalization)]((001)%20Relational%20Database#8-%EB%B0%98%EC%A0%95%EA%B7%9C%ED%99%94denormalization)
   * 반정규화의 정의
   * 반정규화의 적용

---

### [2) SQL 기초 및 활용(MySQL)](https://github.com/seungki1011/Data-Engineering/tree/main/database/(002)%20Using%20SQL)

1. [```MySQL``` 설치]((002)%20Using%20SQL#1-mysql-%EC%84%A4%EC%B9%98)
   * [```MySQL``` 설치와 연결]((002)%20Using%20SQL#11-mysql-%EC%84%A4%EC%B9%98%EC%99%80-%EC%97%B0%EA%B2%B0)
1. [기초 SQL문 I]((002)%20Using%20SQL#2-%EA%B8%B0%EC%B4%88-sql%EB%AC%B8-i)
   * [데이터베이스 생성 (```CREATE```)]((002)%20Using%20SQL#21-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-%EC%83%9D%EC%84%B1)
   * [속성의 자료형 (Attribute Data Types)]((002)%20Using%20SQL#22-attribute-data-types)
   * [테이블 생성, Constraint 적용]((002)%20Using%20SQL#23-%ED%85%8C%EC%9D%B4%EB%B8%94-%EC%83%9D%EC%84%B1-constraint-%EC%A0%81%EC%9A%A9)
   * [테이블에 데이터 추가 / 수정 / 삭제 (```INSERT```/```UPDATE```/```DELETE```)]((002)%20Using%20SQL#24-%ED%85%8C%EC%9D%B4%EB%B8%94%EC%97%90-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EC%B6%94%EA%B0%80--%EC%88%98%EC%A0%95--%EC%82%AD%EC%A0%9C)
   * [데이터 조회 (```SELECT```)]((002)%20Using%20SQL#25-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EC%A1%B0%ED%9A%8C-select)
1. [기초 SQL문 II]((002)%20Using%20SQL#3-%EA%B8%B0%EC%B4%88-sql%EB%AC%B8-ii)
   * [Subquery (Nested Query)]((002)%20Using%20SQL#31-subquery-nested-query)
   * [```NULL```과의 비교 연산, Three-valued logic]((002)%20Using%20SQL#32-null%EA%B3%BC%EC%9D%98-%EB%B9%84%EA%B5%90-%EC%97%B0%EC%82%B0-three-valued-logic)
   * [조인 (```JOIN```)]((002)%20Using%20SQL#33-%EC%A1%B0%EC%9D%B8-join)
   * [```ORDER BY```]((002)%20Using%20SQL#34-order-by)
   * [집계 함수 (Aggregate Function)]((002)%20Using%20SQL#35-aggregate-function)
   * [```GROUP BY```]((002)%20Using%20SQL#36-group-by)
   * [```HAVING```]((002)%20Using%20SQL#37-having)
   * [Examples]((002)%20Using%20SQL#38-%EC%A1%B0%ED%9A%8C-%EC%A7%91%EA%B3%84-%EC%98%88%EC%8B%9C)
1. [Stored Function]((002)%20Using%20SQL#4-stored-function)
   * Examples
   * 저장된 Stored Function 파악하기기 
1. [Stored Procedure]((002)%20Using%20SQL#5-stored-procedure)
   * Examples
   * Stored Function vs Stored Procedure
1. [SQL Trigger]((002)%20Using%20SQL#6-sql-trigger)
   * Example
   * 주의 사항
1. [인덱스(Index)]((002)%20Using%20SQL#7-%EC%9D%B8%EB%8D%B1%EC%8A%A4index)
   * [```INDEX``` 사용법]((002)%20Using%20SQL#71-index-%EC%82%AC%EC%9A%A9%EB%B2%95)
   * [인덱스 동작 방식]((002)%20Using%20SQL#72-%EC%9D%B8%EB%8D%B1%EC%8A%A4-%EB%8F%99%EC%9E%91-%EB%B0%A9%EC%8B%9D)
   * [인덱스를 확인하는 방법]((002)%20Using%20SQL#73-index%EB%A5%BC-%ED%99%95%EC%9D%B8%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95)
   * [주의 사항]((002)%20Using%20SQL#74-%EC%A3%BC%EC%9D%98-%EC%82%AC%ED%95%AD)
   * [Covering Index]((002)%20Using%20SQL#75-covering-index)
   * [Hash Index]((002)%20Using%20SQL#76-hash-index)
1. [B-tree]((002)%20Using%20SQL#8-b-tree) (추가 예정)

---

### [3) RDBMS II](https://github.com/seungki1011/Data-Engineering/tree/main/database/(003)%20Relational%20Database%202)

1. [트랜잭션 (Transaction)]((003)%20Relational%20Database%202#1-transaction)
   * [Transaction 설명]((003)%20Relational%20Database%202#11-transaction-%EC%84%A4%EB%AA%85)
   * [ACID]((003)%20Relational%20Database%202#12-acid)
2. [동시성 제어 (Concurrency Control)]((003)%20Relational%20Database%202#2-concurrency-control)
   * [Schedule, Serializability]((003)%20Relational%20Database%202#21-schedule-serializability)
   * [Conflict]((003)%20Relational%20Database%202#22-conflict)
   * [Conflict Serializability]((003)%20Relational%20Database%202#23-conflict-serializability-protocol)
   * [Recoverability]((003)%20Relational%20Database%202#24-recoverability)
3. [Isolation Level]((003)%20Relational%20Database%202#3-isolation-level)
   * [Dirty Read]((003)%20Relational%20Database%202#31-dirty-read)
   * [Non-repeatable Read]((003)%20Relational%20Database%202#32-non-repeatable-read)
   * [Phantom Read]((003)%20Relational%20Database%202#33-phantom-read)
   * [Isolation Level (SQL Standard)]((003)%20Relational%20Database%202#34-isolation-level-sql-standard)
   * [Dirty Write]((003)%20Relational%20Database%202#35-dirty-write)
   * [Lost Update]((003)%20Relational%20Database%202#36-lost-update)
   * [Snapshot Isolation]((003)%20Relational%20Database%202#37-snapshot-isolation)
4. [Lock]((003)%20Relational%20Database%202#4-lock)
   * [Lock 소개]((003)%20Relational%20Database%202#41-lock-%EC%86%8C%EA%B0%9C)
   * [Exclusive Lock]((003)%20Relational%20Database%202#42-exclusive-lock-%EB%B0%B0%ED%83%80%EC%A0%81-lock)
   * [Shared Lock]((003)%20Relational%20Database%202#43-shared-lock-%EA%B3%B5%EC%9C%A0-lock)
   * [2PL (Two-Phased Locking)]((003)%20Relational%20Database%202#43-2pl-2-phase-locking)
   * [2PL의 한계]((003)%20Relational%20Database%202#48-2pl%EC%9D%98-%ED%95%9C%EA%B3%84)
5. [MVCC (Multi Version Concurrency Control)]((003)%20Relational%20Database%202#5-mvccmulti-version-concurrency-control) (추가 예정)
6. Distributed Database (추가 예정)
   * 파티셔닝 (Partitioning)
   * 샤딩 (Sharding)
   * 레플리케이션 (Replication)
7. DBCP (Database Connection Pool) (추가 예정)

---

### [4) Java Database Connectivity](https://github.com/seungki1011/Data-Engineering/tree/main/database/(004)Java_DB%20_Access)

1. [JDBC(Java Database Connectivity)]((004)Java_DB%20_Access#1-jdbcjava-database-connectivity)
   * [JDBC 소개]((004)Java_DB%20_Access#11-jdbc-%EC%86%8C%EA%B0%9C)
   * [JDBC 사용 - 1(`DriverManager`)]((004)Java_DB%20_Access#12-jdbc-%EC%82%AC%EC%9A%A9---1drivermanager)
     * 등록(`insert`)
     * 조회(`select`)
     * 수정, 삭제(`update`, `delete`)
     * 테스트 코드로 동작 확인
   * [JDBC 사용 - 2(`DBCP`)]((004)Java_DB%20_Access#13-jdbc-%EC%82%AC%EC%9A%A9---2dbcp)
     * `DBCP(커넥션 풀)` 소개
     * `DataSource`
     * 커넥션 풀 사용하기(`HikariDataSource`)
   * [JDBC 사용 -3(스프링 사용 x)]((004)Java_DB%20_Access#14-jdbc-%EC%82%AC%EC%9A%A9---3%EC%8A%A4%ED%94%84%EB%A7%81-%EC%82%AC%EC%9A%A9-x)
     * [프로젝트, DB 설정]((004)Java_DB%20_Access#141-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-db-%EC%85%8B%ED%8C%85)
     * [`dbutil` 구현]((004)Java_DB%20_Access#142-dbutil-%EA%B5%AC%ED%98%84)
     * [커넥션 생성, `DatabaseMetaData` 확인]((004)Java_DB%20_Access#143-%EC%BB%A4%EB%84%A5%EC%85%98-%EC%83%9D%EC%84%B1-databasemetadata-%ED%99%95%EC%9D%B8)
     * [`Statement` 사용]((004)Java_DB%20_Access#144-statement-%EC%82%AC%EC%9A%A9)
       * `executeQuery()`
       * `executeUpdate()`
       * `executeBatch()`
     * [`PreparedStatement` 사용]((004)Java_DB%20_Access#145-preparedstatement-%EC%82%AC%EC%9A%A9)
     * `CallableStatement` 사용
   * [`POJO` 클래스로 매핑]((004)Java_DB%20_Access#15-pojo-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%82%AC%EC%9A%A9)
     * [`POJO` 란]((004)Java_DB%20_Access#151-pojo%EB%9E%80)
     * [`POJO` 클래스에 매핑 후 사용]((004)Java_DB%20_Access#152-pojo-%ED%81%B4%EB%9E%98%EC%8A%A4%EC%97%90-%EB%A7%A4%ED%95%91-%ED%9B%84-%EC%82%AC%EC%9A%A9)
2. [트랜잭션(Transaction)]((004)Java_DB%20_Access#2-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98transaction)
   * [트랜잭션 복습]((004)Java_DB%20_Access#21-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EB%B3%B5%EC%8A%B5)
   * [기존 트랜잭션 적용의 문제]((004)Java_DB%20_Access#22-%EA%B8%B0%EC%A1%B4-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EC%A0%81%EC%9A%A9%EC%9D%98-%EB%AC%B8%EC%A0%9C)
   * [스프링에서의 트랜잭션 처리]((004)Java_DB%20_Access#23-%EC%8A%A4%ED%94%84%EB%A7%81%EC%97%90%EC%84%9C%EC%9D%98-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EC%B2%98%EB%A6%AC)
     * `PlatformTransactionManager`
     * `TransactionTemplate`
     * `@Transactional`(트랜잭션 AOP)
   * [스프링 트랜잭션 주의점]((004)Java_DB%20_Access#24-%EC%8A%A4%ED%94%84%EB%A7%81-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EC%A3%BC%EC%9D%98%EC%A0%90)
   * [`@Transactional` 옵션들]((004)Java_DB%20_Access#25-transactional-%EC%98%B5%EC%85%98%EB%93%A4)
   * [예외에 따른 트랜잭션 커밋/롤백]((004)Java_DB%20_Access#26-%EC%98%88%EC%99%B8%EC%97%90-%EB%94%B0%EB%A5%B8-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EC%BB%A4%EB%B0%8B%EB%A1%A4%EB%B0%B1)
   * [스프링 트랜잭션 전파(Transaction Propagation)]((004)Java_DB%20_Access#27-%EC%8A%A4%ED%94%84%EB%A7%81-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EC%A0%84%ED%8C%8Ctransaction-propagation)
     * [두 트랜잭션을 따로 관리]((004)Java_DB%20_Access#271-%EB%91%90-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98%EC%9D%84-%EB%94%B0%EB%A1%9C-%EA%B4%80%EB%A6%AC)
     * [전파 기본 옵션 `REQUIRED`]((004)Java_DB%20_Access#272-%EC%A0%84%ED%8C%8C-%EA%B8%B0%EB%B3%B8-%EC%98%B5%EC%85%98-required)
     * [전파 옵션 `REQUIRES_NEW`]((004)Java_DB%20_Access#273-%EC%A0%84%ED%8C%8C-%EC%98%B5%EC%85%98-requires_new)
     * 기타 전파 옵션
3. [JdbcTemplate]((004)Java_DB%20_Access#3-jdbctemplate)
   * [예시 프로젝트(메모리 기반) 소개]((004)Java_DB%20_Access#31-%EC%98%88%EC%8B%9C-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%EB%A9%94%EB%AA%A8%EB%A6%AC-%EA%B8%B0%EB%B0%98-%EC%86%8C%EA%B0%9C)
     * 도메인
     * 레포지토리
     * 스프링 부트 설정
     * [프로필(`@Profile`)]((004)Java_DB%20_Access#314-%ED%94%84%EB%A1%9C%ED%95%84profile)
   * [프로젝트 데이터베이스 준비]((004)Java_DB%20_Access#32-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-%EC%A4%80%EB%B9%84)
   * [JdbcTemplate 소개]((004)Java_DB%20_Access#33-jdbctemplate-%EC%86%8C%EA%B0%9C)
   * [JdbcTemplate 설정]((004)Java_DB%20_Access#34-jdbctemplate-%EC%84%A4%EC%A0%95)
   * [JdbcTemplate 적용]((004)Java_DB%20_Access#35-jdbctemplate-%EC%A0%81%EC%9A%A9)
     * `ItemRepository` 구현체 만들기
     * [동적 쿼리]((004)Java_DB%20_Access#352-%EB%8F%99%EC%A0%81-%EC%BF%BC%EB%A6%AC)
     * 구성하고 실행
   * [`NamedParameterJdbcTemplate`]((004)Java_DB%20_Access#36-namedparameterjdbctemplate)
   * [`SimpleJdbcInsert`]((004)Java_DB%20_Access#37-simplejdbcinsert)
4. [DB Testing]((004)Java_DB%20_Access#4-db-testing)
   * [데이터베이스 연동]((004)Java_DB%20_Access#41-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-%EC%97%B0%EB%8F%99)
   * [데이터베이스 분리]((004)Java_DB%20_Access#42-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-%EB%B6%84%EB%A6%AC)
   * [Rollback]((004)Java_DB%20_Access#43-rollback)
   * [`@Transactional`]((004)Java_DB%20_Access#44-transactional)
   * [Embedded Mode]((004)Java_DB%20_Access#45-embedded-mode)

---

### [5) MongoDB(NoSQL)](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL))

1. [NoSQL(Not Only SQL)]((005)MongoDB(NoSQL)#1-nosqlnot-only-sql)
   * 관계형 데이터베이스의 한계
   * NoSQL 등장 배경
   * NoSQL 분류 및 특징
2. [MongoDB 소개]((005)MongoDB(NoSQL)#2-mongodb-%EC%86%8C%EA%B0%9C)
   * MongoDB의 특징
   * MongoDB 설치
3. [MondgoDB 사용하기 (CRUD)]((005)MongoDB(NoSQL)#3-mongodb-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0crud)
   * MongoDB Query Language(MQL)
   * 데이터베이스 생성
   * `Collection` 생성, 삭제
   * [Document 생성]((005)MongoDB(NoSQL)#34-document-%EC%83%9D%EC%84%B1)
     * `insertOne()`
     * `insertMany()`
     * Embedded(Nested) Document
     * `ordered` 옵션
     * `writeConcern` 옵션
   * [Document 수정]((005)MongoDB(NoSQL)#35-document-%EC%88%98%EC%A0%95)
     * `updateOne()`
     * `updateMany()`
   * [Document 삭제]((005)MongoDB(NoSQL)#36-document-%EC%82%AD%EC%A0%9C)
     * `deleteOne()`
     * `deleteMany()`
   * [Document 조회]((005)MongoDB(NoSQL)#37-document-%EC%A1%B0%ED%9A%8C)
     * `mongoimport`
     * `find()`
     * 모든 도큐먼트 조회
     * 동등 조건으로 도큐먼트 조회
     * 쿼리 오퍼레이터를 이용한 조건으로 도큐먼트 조회, Projection
     * `AND`, `OR`
     * Nested 도큐먼트의 필드를 이용해서 조회
     * [:star: `find()`와 cursor]((005)MongoDB(NoSQL)#378-star-find%EC%99%80-cursor)
     * `sort()`
4. [MongoDB 스키마 설계]((005)MongoDB(NoSQL)#4-mongodb-%EC%8A%A4%ED%82%A4%EB%A7%88-%EC%84%A4%EA%B3%84)
   * 스키마 설계
   * Nested Document vs Reference
   * [:star: 스키마 검증(Validation))]((005)MongoDB(NoSQL)#43-star-%EC%8A%A4%ED%82%A4%EB%A7%88-%EA%B2%80%EC%A6%9Dvalidation)
     * 스키마 검증 적용
     * `validationAction`
     * `validationLevel`
     * 스키마 검증 규칙 변경
5. [MongoDB 인덱스(Index)]((005)MongoDB(NoSQL)#5-mongodb-%EC%9D%B8%EB%8D%B1%EC%8A%A4index)
   * 인덱스 소개
   * [인덱스 생성]((005)MongoDB(NoSQL)#52-%EC%9D%B8%EB%8D%B1%EC%8A%A4-%EC%83%9D%EC%84%B1)
   * 쿼리 소요 시간 확인
6. [Aggregation Pipeline]((005)MongoDB(NoSQL)#6-aggregation-pipeline)
   * Aggregation Pipeline 소개
   * [사용 예시]((005)MongoDB(NoSQL)#62-%EC%82%AC%EC%9A%A9-%EC%98%88%EC%8B%9C)
7. [Java MongoDB Driver]((005)MongoDB(NoSQL)#7-java-mongodb-driver)
   * [MongoDB 드라이버로 연결]((005)MongoDB(NoSQL)#71-mongodb-%EB%93%9C%EB%9D%BC%EC%9D%B4%EB%B2%84%EB%A1%9C-%EC%97%B0%EA%B2%B0)
   * MongoDB에서의 POJO 클래스
   * [POJO 클래스 사용하기]((005)MongoDB(NoSQL)#73-pojo-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0)
     * POJO 클래스 만들기
     * 도큐먼트 생성
     * 도큐먼트 조회
8. [Further Reading]((005)MongoDB(NoSQL)#further-reading)

---

### [6) JPA](https://github.com/seungki1011/Data-Engineering/tree/main/database/(006)JPA)

1. [JPA 소개]((006)JPA#1-jpa-%EC%86%8C%EA%B0%9C)
2. [JPA 준비]((006)JPA#2-jpa-%EC%A4%80%EB%B9%84)
   * [프로젝트 setup]((006)JPA#21-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-setup)
   * [객체와 테이블 매핑]((006)JPA#22-%EA%B0%9D%EC%B2%B4%EC%99%80-%ED%85%8C%EC%9D%B4%EB%B8%94-%EB%A7%A4%ED%95%91)
   * [JPA 동작 확인]((006)JPA#23-jpa-%EB%8F%99%EC%9E%91-%ED%99%95%EC%9D%B8)
     * JPA 정상 동작 체크
     * 저장
     * 조회
     * 삭제
     * 수정
     * JPQL
3. [내부 동작 - 영속성 컨텍스트(Persistence Context)]((006)JPA#3-%EB%82%B4%EB%B6%80-%EB%8F%99%EC%9E%91---%EC%98%81%EC%86%8D%EC%84%B1-%EC%BB%A8%ED%85%8D%EC%8A%A4%ED%8A%B8persistence-context)
   * [영속성 컨텍스트란?]((006)JPA#31-%EC%98%81%EC%86%8D%EC%84%B1-%EC%BB%A8%ED%85%8D%EC%8A%A4%ED%8A%B8%EB%9E%80)
   * [영속성 컨텍스트를 사용하는 이유]((006)JPA#32-%EC%98%81%EC%86%8D%EC%84%B1-%EC%BB%A8%ED%85%8D%EC%8A%A4%ED%8A%B8%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%EC%9D%B4%EC%9C%A0)
     * [1차 캐시(First level Cache)]((006)JPA#321-1%EC%B0%A8-%EC%BA%90%EC%8B%9C)
     * [영속 엔티티의 동일성 보장]((006)JPA#322-%EC%98%81%EC%86%8D-%EC%97%94%ED%8B%B0%ED%8B%B0%EC%9D%98-%EB%8F%99%EC%9D%BC%EC%84%B1-%EB%B3%B4%EC%9E%A5)
     * [쓰기 지연(Write-Behind), 변경 감지(Dirty-Check)]((006)JPA#323-%EC%93%B0%EA%B8%B0-%EC%A7%80%EC%97%B0write-behind-%EB%B3%80%EA%B2%BD-%EA%B0%90%EC%A7%80dirty-check)
     * [플러시(Flush)]((006)JPA#324-%ED%94%8C%EB%9F%AC%EC%8B%9Cflush)
4. [엔티티 매핑(Entity Mapping)]((006)JPA#4-%EC%97%94%ED%8B%B0%ED%8B%B0-%EB%A7%A4%ED%95%91entity-mapping)
   * [DB 스키마 자동 생성(`hibernate.hbm2ddl.auto`)]((006)JPA#40-db-%EC%8A%A4%ED%82%A4%EB%A7%88-%EC%9E%90%EB%8F%99-%EC%83%9D%EC%84%B1-hibernatehbm2ddlauto)
   * [객체 - 테이블 매핑]((006)JPA#41-%EA%B0%9D%EC%B2%B4---%ED%85%8C%EC%9D%B4%EB%B8%94-%EB%A7%A4%ED%95%91)
   * [필드 - 컬럼 매핑]((006)JPA#42-%ED%95%84%EB%93%9C---%EC%B9%BC%EB%9F%BC-%EB%A7%A4%ED%95%91)
   * [기본키(PK) 매핑]((006)JPA#43-%EA%B8%B0%EB%B3%B8%ED%82%A4pk-%EB%A7%A4%ED%95%91)
     * 기본키 매핑 애노테이션
     * `IDENTITY` 전략
     * `SEQUENCE` 전략
5. [연관관계 매핑(Relationship Mapping)]((006)JPA#5-%EC%97%B0%EA%B4%80%EA%B4%80%EA%B3%84-%EB%A7%A4%ED%95%91relationship-mapping)
   * [단방향 연결관계(Uni-directional)]((006)JPA#51-%EB%8B%A8%EB%B0%A9%ED%96%A5-%EC%97%B0%EA%B4%80%EA%B4%80%EA%B3%84uni-directional)
   * [양방향 연관관계(Bi-directional)]((006)JPA#52-%EC%96%91%EB%B0%A9%ED%96%A5-%EC%97%B0%EA%B4%80%EA%B4%80%EA%B3%84bi-directional)
     * [양방향 연관관계 소개]((006)JPA#521-%EC%96%91%EB%B0%A9%ED%96%A5-%EC%97%B0%EA%B4%80%EA%B4%80%EA%B3%84-%EC%86%8C%EA%B0%9C)
     * [:star: 연관관계의 주인(Owning side of Relationship))]((006)JPA#522-star-%EC%97%B0%EA%B4%80%EA%B4%80%EA%B3%84%EC%9D%98-%EC%A3%BC%EC%9D%B8owning-side-of-relationship-%EC%86%8C%EA%B0%9C)
     * [양방향 매핑 규칙]((006)JPA#523-%EC%96%91%EB%B0%A9%ED%96%A5-%EB%A7%A4%ED%95%91-%EA%B7%9C%EC%B9%99)
     * [양방향 매핑시 주의점, 권장사항]((006)JPA#524-%EC%96%91%EB%B0%A9%ED%96%A5-%EB%A7%A4%ED%95%91%EC%8B%9C-%EC%A3%BC%EC%9D%98%EC%A0%90-%EA%B6%8C%EC%9E%A5%EC%82%AC%ED%95%AD)
     * [양방향 매핑 정리]((006)JPA#525-%EC%96%91%EB%B0%A9%ED%96%A5-%EB%A7%A4%ED%95%91-%EC%A0%95%EB%A6%AC)
6. [연관관계 카디널리티(Cardinality)]((006)JPA#6-%EC%97%B0%EA%B4%80%EA%B4%80%EA%B3%84-%EC%B9%B4%EB%94%94%EB%84%90%EB%A6%AC%ED%8B%B0cardinality)
   * [다대일(N:1, `@ManyToOne`)]((006)JPA#61-%EB%8B%A4%EB%8C%80%EC%9D%BCn1-manytoone)
   * 일대다(1:N, `@OneToMany`)
   * 일대일(1:1, `@OneToOne`)
7. [상속관계 매핑 (Inheritance Mapping)]((006)JPA#7-%EC%83%81%EC%86%8D-%EA%B4%80%EA%B3%84-%EB%A7%A4%ED%95%91inheritance-mapping)
   * [상속 관계 매핑 소개]((006)JPA#71-%EC%83%81%EC%86%8D-%EA%B4%80%EA%B3%84-%EB%A7%A4%ED%95%91-%EC%86%8C%EA%B0%9C)
   * [조인 전략(`JOINED`)]((006)JPA#72-%EC%A1%B0%EC%9D%B8-%EC%A0%84%EB%9E%B5joined)
   * [단일 테이블 전략(`SINGLE_TABLE`)]((006)JPA#73-%EB%8B%A8%EC%9D%BC-%ED%85%8C%EC%9D%B4%EB%B8%94-%EC%A0%84%EB%9E%B5single_table)
   * 클래스 마다 테이블 전략(`TABLE_PER_CLASS`)
   * [`@MappedSuperclass`]((006)JPA#75-mappedsuperclass)
8. [즉시 로딩(`EAGER`), 지연 로딩(`LAZY`)]((006)JPA#8-%EC%A6%89%EC%8B%9C-%EB%A1%9C%EB%94%A9eager-%EC%A7%80%EC%97%B0-%EB%A1%9C%EB%94%A9lazy)
9. [영속성 전이(Cascade)]((006)JPA#9-%EC%98%81%EC%86%8D%EC%84%B1-%EC%A0%84%EC%9D%B4cascade)
   * [영속성 전이 설명]((006)JPA#91-%EC%98%81%EC%86%8D%EC%84%B1-%EC%A0%84%EC%9D%B4-%EC%84%A4%EB%AA%85)
   * [영속성 전이를 사용하는 경우]((006)JPA#92-%EC%98%81%EC%86%8D%EC%84%B1-%EC%A0%84%EC%9D%B4%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%EA%B2%BD%EC%9A%B0)
   * 고아 객체 제거(`orphanRemoval`)
10. Embedded Type(추가 예정)
11. [JPQL]((006)JPA#11-jpql)
    * JPQL 소개
    * QueryDSL 소개
    * Native SQL 소개
    * JPQL 사용법(추가 예정)

---

## Requirements

* MySQL 8.0 (InnoDB 사용)
  * GUI 툴(MySQL Workbench, DBeaver)

* Docker

---

## Further Reading

* Cache DB
  * Redis

* Oracle SQL
* NoSQL
  * MongoDB

* OLTP vs OLAP

---

## Reference

1. [한국 데이터 산업 진흥원 - SQL 전문가 가이드](https://dataonair.or.kr/db-tech-reference/d-guide/sql/)
2. [인프런 쉬운코드 - 데이터베이스](https://www.inflearn.com/course/%EB%B0%B1%EC%97%94%EB%93%9C-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-%EA%B0%9C%EB%A1%A0/dashboard)
3. [MySQL 8.0 Document](https://dev.mysql.com/doc/mysql-installation-excerpt/8.0/en/macos-installation.html)
4. [https://www.mysqltutorial.org/mysql-basics/mysql-data-types/](https://www.mysqltutorial.org/mysql-basics/mysql-data-types/)

