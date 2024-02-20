> 데이터베이스에 대한 이론, SQL 기초 및 실습

---

## Index

### [1) RDBMS I](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(001)%20Relational%20Database.md)

1. [데이터베이스(Database, DB) 소개](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(001)%20Relational%20Database.md#1-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4database-%EC%86%8C%EA%B0%9C)
   * 데이터베이스의 정의
   * 데이터베이스 관리 시스템(DBMS)
   * 메타데이터(Metadata)
2. [Modeling](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(001)%20Relational%20Database.md#2-modeling)
   * 데이터 모델링의 정의
   * 데이터 모델링의 3단계
   * 데이터 독립성(Data Independence)
     * three-schema-architecture
3. [Entity, Attribute, Relationship](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(001)%20Relational%20Database.md#3-entity-attribute-relationship)
   * 엔티티(Entity)
   * 속성(Attribute)
   * 관계(Relationship)
4. [식별자(Identifier)](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(001)%20Relational%20Database.md#4-%EC%8B%9D%EB%B3%84%EC%9E%90identifier)
   * 식별자의 정의
   * 식별자의 분류
   * 주식별자의 특징
   * 식별자와 비식별자 관계
5. [테이블(Table), 키(Key)](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(001)%20Relational%20Database.md#5-%ED%85%8C%EC%9D%B4%EB%B8%94table-%ED%82%A4key)
   * 테이블(Table)
   * 키(Key)의 정의
   * 키(Key)의 종류
6. [성능 데이터 모델링](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(001)%20Relational%20Database.md#6-%EC%84%B1%EB%8A%A5-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EB%AA%A8%EB%8D%B8%EB%A7%81)
   * 성능 데이터 모델링의 정의
   * 성능 데이터 모델링의 수행 시점
   * 성능 데이터 모델링의 고려 사항
7. [정규화(Normalization)](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(001)%20Relational%20Database.md#7-%EC%A0%95%EA%B7%9C%ED%99%94normalization)
   * 정규화의 정의
   * 잘못된 구조의 테이블
   * 정규화와 성능
   * [함수적 종속성(Functional Dependency, FD)](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(001)%20Relational%20Database.md#7-4-%ED%95%A8%EC%88%98%EC%A0%81-%EC%A2%85%EC%86%8D%EC%84%B1functional-dependency-fd)
   * [정규화의 단계](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(001)%20Relational%20Database.md#7-5-%EC%A0%95%EA%B7%9C%ED%99%94%EC%9D%98-%EB%8B%A8%EA%B3%84)
     * [1NF](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(001)%20Relational%20Database.md#7-5-1-1nf)
     * [2NF](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(001)%20Relational%20Database.md#7-5-2-2nf)
     * [3NF](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(001)%20Relational%20Database.md#7-5-3-3nf)
     * [BCNF(Boyce-Codd NF)](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(001)%20Relational%20Database.md#7-5-4-bcnfboyce-codd-normal-form)
8. [반정규화(Denormalization)](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(001)%20Relational%20Database.md#8-%EB%B0%98%EC%A0%95%EA%B7%9C%ED%99%94denormalization)
   * 반정규화의 정의
   * 반정규화의 적용

---

### [2) SQL 기초 및 활용](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md)

1. [```MySQL``` 설치](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#1-mysql-%EC%84%A4%EC%B9%98%EC%99%80-%EC%84%A4%EC%A0%95)
   * [```MySQL``` 설치와 연결](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#1-1-mysql-%EC%84%A4%EC%B9%98%EC%99%80-%EC%97%B0%EA%B2%B0)
     * [CLI](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#1-1-1-cli)
     * [GUI](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#1-1-2-gui)
1. [기초 SQL문 I](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#2-%EA%B8%B0%EC%B4%88-sql%EB%AC%B8-i)
   * [데이터베이스 생성 (```CREATE```)](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#2-1-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-%EC%83%9D%EC%84%B1)
   * [속성의 자료형 (Attribute Data Types)](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#2-2-attribute-data-types)
   * [테이블 생성, Constraint 적용](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#2-3-%ED%85%8C%EC%9D%B4%EB%B8%94-%EC%83%9D%EC%84%B1-constraint-%EC%A0%81%EC%9A%A9)
     * 각 테이블 생성 및 설명
     * 테이블 스키마 변경 (```ALTER```)
   * [테이블에 데이터 추가 / 수정 / 삭제 (```INSERT```/```UPDATE```/```DELETE```)](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#2-4-%ED%85%8C%EC%9D%B4%EB%B8%94%EC%97%90-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EC%B6%94%EA%B0%80--%EC%88%98%EC%A0%95--%EC%82%AD%EC%A0%9C)
   * [데이터 조회 (```SELECT```)](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#2-5-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EC%A1%B0%ED%9A%8C-select)
1. [기초 SQL문 II](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#3-%EA%B8%B0%EC%B4%88-sql%EB%AC%B8-ii)
   * [Subquery (Nested Query)](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#3-1-subquery-nested-query)
     * subquery
     * [```IN```, ```EXISTS```](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#3-1-2-in-exists)
     * [```ANY```](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#3-1-3-any)
     * [```ALL```](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#3-1-4-all)
   * [```NULL```과의 비교 연산, Three-valued logic](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#3-2-null%EA%B3%BC%EC%9D%98-%EB%B9%84%EA%B5%90-%EC%97%B0%EC%82%B0-three-valued-logic)
   * [조인 (```JOIN```)](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#3-3-%EC%A1%B0%EC%9D%B8-join)
     * [Implicit vs Explicit ```JOIN```](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#3-3-1-implicit-join-vs-explicit-join)
     * [```INNER JOIN```](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#3-3-2-inner-join)
     * [```OUTER JOIN```](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#3-3-3-outer-join)
     * [```USING```](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#3-3-4-using)
     * [```NATURAL JOIN```](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#3-3-5-natural-join)
     * [```CROSS JOIN```](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#3-3-6-cross-join)
   * [```ORDER BY```](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#3-4-order-by)
   * [집계 함수 (Aggregate Function)](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#3-5-aggregate-function)
   * [```GROUP BY```](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#3-6-group-by)
   * [```HAVING```](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#3-7-having)
   * [Examples](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#3-8-%EC%A1%B0%ED%9A%8C-%EC%A7%91%EA%B3%84-%EC%98%88%EC%8B%9C)
1. [Stored Function](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#4-stored-function)
   * Examples
   * 저장된 Stored Function 파악하기기 
1. [Stored Procedure](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#5-stored-procedure)
   * Examples
   * Stored Function vs Stored Procedure
1. [SQL Trigger](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#6-sql-trigger)
   * Example
   * 주의 사항
1. [인덱스(Index)](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#7-%EC%9D%B8%EB%8D%B1%EC%8A%A4index)
   * [```INDEX``` 사용법](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#7-1-index-%EC%82%AC%EC%9A%A9%EB%B2%95)
   * [인덱스 동작 방식](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#7-2-%EC%9D%B8%EB%8D%B1%EC%8A%A4-%EB%8F%99%EC%9E%91-%EB%B0%A9%EC%8B%9D)
   * [인덱스를 확인하는 방법](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#7-3-index%EB%A5%BC-%ED%99%95%EC%9D%B8%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95)
   * [주의 사항](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#7-4-%EC%A3%BC%EC%9D%98-%EC%82%AC%ED%95%AD)
   * [Covering Index](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#7-5-covering-index)
   * [Hash Index](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#7-6-hash-index)
1. [B-tree](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(002)%20Using%20SQL.md#8-b-tree)

---

### [3) RDBMS II](https://github.com/seungki1011/Data-Engineering/blob/main/database/sql/(003)%20Relational%20Database%202.md)

1. 트랜잭션(Transaction)
2. Lock
3. 동시성 제어(Concurrency Control)



---

## Requirements

* MySQL 8.0 (InnoDB 사용)
* GUI 툴(MySQL Workbench, DBeaver)은 선택

---

## P.S.





---

## Reference

1. [한국 데이터 산업 진흥원 - SQL 전문가 가이드](https://dataonair.or.kr/db-tech-reference/d-guide/sql/)
2. [인프런 쉬운코드 - 데이터베이스](https://www.inflearn.com/course/%EB%B0%B1%EC%97%94%EB%93%9C-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-%EA%B0%9C%EB%A1%A0/dashboard)
3. [MySQL 8.0 Document](https://dev.mysql.com/doc/mysql-installation-excerpt/8.0/en/macos-installation.html)
4. [https://www.mysqltutorial.org/mysql-basics/mysql-data-types/](https://www.mysqltutorial.org/mysql-basics/mysql-data-types/)

