> NoSQL의 등장 배경, 기초적인 MongoDB 사용법
>
> `MongoDB 7.0`을 기준으로 작성

---

## Index

1. [NoSQL(Not Only SQL)](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL)#1-nosqlnot-only-sql)
   * 관계형 데이터베이스의 한계
   * NoSQL 등장 배경
   * NoSQL 분류 및 특징
2. [MongoDB 소개](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL)#2-mongodb-%EC%86%8C%EA%B0%9C)
   * MongoDB의 특징
   * MongoDB 설치
3. [MondgoDB 사용하기 (CRUD)](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL)#3-mongodb-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0crud)
   * MongoDB Query Language(MQL)
   * 데이터베이스 생성
   * `Collection` 생성, 삭제
   * [Document 생성](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL)#34-document-%EC%83%9D%EC%84%B1)
     * `insertOne()`
     * `insertMany()`
     * Embedded(Nested) Document
     * `ordered` 옵션
     * `writeConcern` 옵션
   * [Document 수정](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL)#35-document-%EC%88%98%EC%A0%95)
     * `updateOne()`
     * `updateMany()`
   * [Document 삭제](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL)#36-document-%EC%82%AD%EC%A0%9C)
     * `deleteOne()`
     * `deleteMany()`
   * [Document 조회](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL)#37-document-%EC%A1%B0%ED%9A%8C)
     * `mongoimport`
     * `find()`
     * 모든 도큐먼트 조회
     * 동등 조건으로 도큐먼트 조회
     * 쿼리 오퍼레이터를 이용한 조건으로 도큐먼트 조회, Projection
     * `AND`, `OR`
     * Nested 도큐먼트의 필드를 이용해서 조회
     * [:star: `find()`와 cursor](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL)#378-star-find%EC%99%80-cursor)
     * `sort()`
4. [MongoDB 스키마 설계](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL)#4-mongodb-%EC%8A%A4%ED%82%A4%EB%A7%88-%EC%84%A4%EA%B3%84)
   * 스키마 설계
   * Nested Document vs Reference
   * [:star: 스키마 검증(Validation))](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL)#43-star-%EC%8A%A4%ED%82%A4%EB%A7%88-%EA%B2%80%EC%A6%9Dvalidation)
     * 스키마 검증 적용
     * `validationAction`
     * `validationLevel`
     * 스키마 검증 규칙 변경
5. [MongoDB 인덱스(Index)](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL)#5-mongodb-%EC%9D%B8%EB%8D%B1%EC%8A%A4index)
   * 인덱스 소개
   * [인덱스 생성](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL)#52-%EC%9D%B8%EB%8D%B1%EC%8A%A4-%EC%83%9D%EC%84%B1)
   * 쿼리 소요 시간 확인
6. [Aggregation Pipeline](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL)#6-aggregation-pipeline)
   * Aggregation Pipeline 소개
   * [사용 예시](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL)#62-%EC%82%AC%EC%9A%A9-%EC%98%88%EC%8B%9C)
7. [Java MongoDB Driver](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL)#7-java-mongodb-driver)
   * [MongoDB 드라이버로 연결](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL)#71-mongodb-%EB%93%9C%EB%9D%BC%EC%9D%B4%EB%B2%84%EB%A1%9C-%EC%97%B0%EA%B2%B0)
   * MongoDB에서의 POJO 클래스
   * [POJO 클래스 사용하기](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL)#73-pojo-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0)
     * POJO 클래스 만들기
     * 도큐먼트 생성
     * 도큐먼트 조회
8. [Further Reading](https://github.com/seungki1011/Data-Engineering/tree/main/database/(005)MongoDB(NoSQL)#further-reading)

---

## 1) NoSQL(Not Only SQL)

NoSQL을 설명하기 전에 NoSQL이 등장하게 된 배경부터 살펴보자.

먼저 기존 SQL 데이터베이스(관계형 데이터베이스)의 한계에 대해서 살펴보자.

<br>

### 1.1 관계형 데이터베이스의 한계

<p align="center">   <img src="img/rdb1.png" alt="nosql" style="width: 100%;"> </p>

<p align="center">유연하지 않은 스키마</p>

* 관계형 데이터베이스는 특정 기능이나 서비스의 도입에 따라 테이블에 컬럼을 추가하기 위해서는 스키마 변경이 필요하다
* 데이터의 수가 적으면 큰 문제가 되지 않겠지만, 데이터가 많은 경우 스키마 변경을 위한 작업이 데이터베이스 서버에 큰 부담이 될 수 있다
* 쉽게 말해서 RDBMS는 경직된 스키마를 가지고, 서비스 중에 이 스키마를 변경하는 것은 부담되는 행위이다

<br>

<p align="center">   <img src="img/rdb_2.png" alt="nosql" style="width: 90%;"> </p>

<p align="center">과도한 JOIN의 문제</p>

* 관계형 데이터베이스의 스키마는 보통 정규화를 통해서 중복을 제거하기 위해서 테이블들을 쪼개 놓는다
* 이때 데이터를 읽어오기 위해서 과도한 JOIN을 수행하게 되고, 이는 read의 성능을 하락시킨다(쉽게 말해서 응답 시간이 늘어남)

<br>

<p align="center">   <img src="img/rdb3.png" alt="nosql" style="width: 100%;"> </p>

<p align="center">Scale-out이 쉽지 않다</p>

* 데이터베이스 레플리케이션 상황에서 `read`를 위한 `slave`를 추가하기 위해서 `master`의 데이터를 카피하는 작업이 필요함
* `write` 성능을 높이기 위해 `master`를 추가해서 `multi-master`를 사용하는 것도 `sharding` 같은 작업이 필요할 수 있기 때문에 쉽게 할 수 있는 작업이 아님

<br>

**위의 내용과 추가적인 단점을 정리하자면 다음과 같다.**

* 유연하지 않은 스키마로 인해 스키마를 변경하는 것은 부담이 된다
  * 이를 해결하기 위해서 애플리케이션 레벨에서 수정하려고 하면 [기술 부채(technical debt)](https://ko.wikipedia.org/wiki/%EA%B8%B0%EC%88%A0_%EB%B6%80%EC%B1%84)가 늘어난다



* 데이터를 읽어오기 위해서 정규화 되어 있는 테이블들에 대해서 `JOIN`을 수행하게 되는데, 과도한 `JOIN` 때문에 응답 시간이 늘어날 수 있다
* 스케일 아웃(scale out)을 하기 위한 `read replica` 추가, `multi-master` 사용, `sharding`, `partitioning` 등의 전략이 있지만 그 과정이 쉽지 않다
  * 프로던션에 이미 배포가 되어있는 상태라면 더더욱 힘들다



* ACID를 보장하기 위해 데이터베이스의 성능에 영향을 끼친다
  * ACID를 위해서 격리(Isolation)나 락(Lock)을 사용하는데, 이는 데이터베이스의 성능(performance)에 영향을 끼친다
  * 이는 단점이라기 보다는 RDBMS가 가지는 ACID와 성능 사이의 상충 관계(Trade-off)로 볼 수 있다

<br>

---

### 1.2 NoSQL 등장 배경

소셜 미디어 플랫폼들이 등장하면서 데이터베이스들은 높은 처리량(high-throughput)과 낮은 지연시간(low-latency), 등이 요구되었다. 

또한 기존의 정형 데이터가 아닌 비정형, 반정형 데이터가 많아지면서, 관계형 데이터베이스(SQL Database)가 다루지 못하는 영역까지 다룰 수 있는 NoSQL(Not only SQL) 데이터베이스가 등장하게 된다.

정리해서 이야기 하자면 다양항 데이터 유형의 등장, 빅데이터, 대용량 트래픽을 다루는 웹 및 모바일 애플리케이션의 등장에 맞춰서 NoSQL은 확장성, 성능, 사용 편의성으로 인해 인기를 얻기 시작했다. NoSQL은 기존의 정형화된 데이터베이스 구조를 따르지 않으며, 데이터 쿼리에 SQL만을 사용하지 않는다.

<br>

---

### 1.3 NoSQL 분류 및 특징

NoSQL 데이터베이스의 종류는 굉장히 많고, 특징에 따라 다음과 같이 분류할 수 있다.

<br>

1. **Key-Value Based**
   - 키는 데이터의 속성을 나타내며 고유 식별자 역할을 한다
   - 키-값 모두 간단한 정수부터 복잡한 JSON 까지 될 수 있다
   - 사용자 세션 데이터, 선호도, 실시간 추천, 캐싱 등에 적합한 Key-Value 쌍으로 저장
   - 예) Redis, Memchached, DynamoDB 등
   - Redis의 경우 in-memory 캐시 DB로 많이 사용한다



2. **Document-Based**
   - 레코드 및 관련 데이터가 하나의 문서 내에 저장되어 유연한 인덱싱 및 임시 쿼리가 가능하다
   - 실제 use-case로는 이커머스, 의료 기록, CRM 등이 있다
   - 예) MongoDB, DocumentDM, CouchDB 등



3. **Column-Based**
   - 데이터는 행이 아닌 열로 구성되어 있어 많은 쓰기 요청이 필요한 시계열 데이터, 날씨 데이터, IoT 데이터 등에 적합하다
   - 예) Cassandra, HBase 등



4. **Graph-Based**
   - 그래프 모델을 활용하여 데이터를 표현하고 저장하기 때문에 데이터간 연결 및 관계를 시각화하기 적합하다
   - 실제 use-case에는 소셜 네트워크, 추천, 네트워크 다이어그램, 액세스 관리 등에 사용한다
   - 예) Neo4j, CosmosDB 등

<br>

<p align="center">   <img src="img/nosql2.png" alt="nosql2" style="width: 100%;"> </p>

<p align="center">https://learn.microsoft.com/ko-kr/dotnet/architecture/cloud-native/relational-vs-nosql-data </p>

<p align="center">remade by seungki1011</p>

* NoSQL 데이터베이스는 대용량의 데이터를 처리할 수 있는 능력, 분산 처리 시스템 지원, 확장의 용이성, 유연한 스키마 등의 특징이 있다
  * NoSQL의 경우 ACID를 일부 포기하고 그 대신 높은 처리량과 낮은 지연성을 추구한다
  * NoSQL에서는 보통 중복을 허용해서 데이터를 `JOIN` 없이 조회할 수 있도록 한다
  * 필요한 데이터를 그냥 중복이 있어도 전부 저장해놓는 특징 때문에 스케일 아웃도 용이하다



* 이런 NoSQL 데이터베이스의 특징은 에자일한 개발에 유용하다
* 반면 관계형 데이터베이스와 대조되는 강점을 가짐에도 불구하고, NoSQL 데이터베이스는 상대적으로 ACID 준수성이 부족하고 정형 데이터를 다루는 경우 관계형 데이터베이스에 비해서 기능이 부족할 수 있다
  * 그렇게 때문에 Transaction이나 데이터 정합성과 같은 ACID가 정말 중요한 금융 시스템과 같은 경우 NoSQL 데이터베이스를 사용하지 않고 관계형 데이터베이스를 사용한다

<br>

---

## 2) MongoDB 소개

### 2.1 MongoDB의 특징

몽고DB(MongoDB)는 도큐먼트 지향(Document-oriented) 데이터베이스이다. NoSQL 데이터베이스로 분류되는 몽고DB는 동적 스키마형 JSON 도큐먼트에 데이터를 입력한다. 몽고DB는 BSON(Binary JSON)이라는 포맷을 사용해서 저장한다.

BSON은 쉽게 생각해서 JSON 도큐먼트를 바이너리(Binary)로 인코딩한 포맷이라고 생각하면 편하다.

공식 문서 참고 : [https://www.mongodb.com/json-and-bson](https://www.mongodb.com/json-and-bson)

<br>

그럼 몽고DB의 특징을 살펴보자.

<p align="center">   <img src="img/mongodb1.png" alt="nosql2" style="width: 100%;"> </p>

<p align="center">RDBMS vs MongoDB</p>

* 몽고DB에서는 테이블이 아니라 컬렉션(Collection)이라는 명칭을 사용한다
  * 컬렉션은 도큐먼트(Document)의 모음
    * 도큐먼트를 저장하기 위한 논리적인 묶음이라고 보면 된다
    * RDBMS의 테이블을 생각하면 된다
  * 몽고DB는 기본적으로 도큐먼트의 스키마에 제약이 없지만, 컬렉션 단위에서 도큐먼트들이 같은 필드, 데이터 타입을 이용하도록 제약(validator)을 걸 수 있다 
  * Schema Validation을 사용하지 않더라고 애플리케이션 레벨에서 스키마 규칙을 프로그래밍적 모델로 가지고 있는 것이 좋다
  * `db.createCollection("user")` 같은 형태로 컬렉션 생성이 가능, 도큐먼트를 생성하는 과정에서도 컬렉션이 존재하지 않았다면 몽고DB에서 자동으로 생성해준다



* 몽고 DB는 기본적으로 도큐먼트 단위로 데이터를 입력하고 조회한다
  * 데이터는 컬럼에 해당하는 필드(field, key)와 해당하는 값(value)을 입력하면 된다
    * 쉽게 말해서 `JSON` 형태로 데이터를 입력하면 된다
  * 몽고DB는 기존의 관계형 데이터베이스와 다르게 스키마가 아무것도 정해지지 않았기 때문에 자유롭게 필드를 정해서 값을 입력해도 된다
  * `db.user.insertOne({ 필드:값 })` 같은 형태로 하나의 도큐먼트를 입력할 수 있다



* 도큐먼트는 고유한 `_id`를 할당받는다
  * `_id`를 할당받는 시점은 데이터 삽입 시점
  * 자동 할당을 받는 경우 `ObjectId` 형식의 데이터로 `_id`가 생성된다
  * `ObjectId`의 경우 `ObjectId.getTimestamp()`를 이용해서 생성 시점을 가져올 수 있음
  * `_id`를 직접 지정하는 것도 가능



* 전체 도큐먼트를 조회하고 싶으면 `db.user.find({})` 같은 형태로 조회할 수 있다
* 몽고DB는 개발자들이 애플리케이션 레벨에서 스키마 관리를 한다

<br>

<p align="center">   <img src="img/mongodb4.png" alt="nosql2" style="width: 100%;"> </p>

<p align="center">MongoDB는 데이터 중복 허용</p>

* 기존의 RDBMS는 `Product`, `User`, `Order` 테이블을 쪼개서 중복이 없도록 설계하고, 이후 `JOIN`을 통해서 필요한 데이터를 조회한다
* 반면 NoSQL 데이터베이스인 몽고DB에서는 중복된 데이터를 저장해도 상관없다는 철학을 사용한다
  * 한 번 읽을 때 필요한 모든 데이터를 다 저장해놓기 때문에, 굳이 `JOIN`을 사용하지 않아도 된다
  * `JOIN`을 사용하지 않기 때문에 과도한 `JOIN` 수행으로 인한 성능 오버헤드를 방지할 수 있다



* 데이터 중복 허용을 통한 `JOIN` 필요성을 제거하는 대신, 애플리케이션 레벨에서 데이터들이 모두 최신 상태를 유지할 수 있도록 관리해야한다
* 도큐먼트에서 필드 안의 필드 같은 중첩(nested)된 형태로 데이터를 저장하는 것이 가능하다. 그러나 이 경우 데이터 저장, 검색, 집계 과정에서 속도가 느려질 가능성이 있다. 물론 데이터가 적을때는 큰 차이가 없지만, 데이터가 많아지면 성능이 떨어질 수 있기 때문에 유의해서 스키마를 설계하자



* 물론 유연한 스키마를 사용할 수 있지만, RDBMS 데이터베이스 처럼 컬렉션을 참조해서 마치 `JOIN`을 하는 것 처럼 사용이 가능하다

<br>

---

### 2.1 MondoDB 설치

MongoDB를 사용하기 위한 초기 셋팅을 해보자.

로컬에 몽고DB를 설치하지 않고 도커 컴포즈를 사용해서 몽고DB 컨테이너를 이용하자.

다음 두 개의 컨테이너를 올려서 사용할 것이다.

* MondoDB
* MongoExpress(GUI 툴)

<br>

몽고DB와 CLI로 상호작용하기 위해서 `Mongosh`를 설치할 것이다.

`Mongosh` 설치 : [https://www.mongodb.com/docs/mongodb-shell/install/](https://www.mongodb.com/docs/mongodb-shell/install/)

<br>

`JSON` 파일에 존재하는 데이터를 몽고DB의 데이터베이스로 불러오기 위해 사용하는 `mongoimport`를 설치하자.

`mongodb-database-tools` 설치 : [https://www.mongodb.com/docs/database-tools/installation/installation-macos/#installation](https://www.mongodb.com/docs/database-tools/installation/installation-macos/#installation)

<br>

그럼 이제 `compose.yaml` 파일을 다음과 같이 작성하자.

```yaml
services:
  mongodb:
    image: mongo:latest
    container_name: mongodb-container
    restart: always
    ports:
      - "27017:27017"
    environment:
      MONGO_INITDB_ROOT_USERNAME: root
      MONGO_INITDB_ROOT_PASSWORD: admin
    volumes:
      - /Users/{사용자이름}/Desktop/mongodb-data:/data/db

  mongo-express:
    image: mongo-express
    container_name: mongo-express-container
    restart: always
    ports:
      - "8081:8081"
    environment:
      ME_CONFIG_MONGODB_SERVER: mongodb-container
      ME_CONFIG_MONGODB_ADMINUSERNAME: root
      ME_CONFIG_MONGODB_ADMINPASSWORD: admin

networks:
  default:
    name: mongodb-network
```

* `27017`은 몽고DB 기본 포트
* 현재 MacOS 환경에서 사용하기 때문에 그냥 바인드 마운트로 사용하는 중
* `mongodb-network`라는 도커 네트워크를 정의하고, `mongodb`와 `mongo-express` 컨테이너가 이 네트워크를 통해 통신할 수 있도록 한다
* `MongoExpress`를 사용하기 위해서는 [http://localhost:8081/](http://localhost:8081/)에 접속하면 된다

<br>

`compose.yaml`을 작성한 디렉토리로 가서 `docker compose up -d` 또는 `docker compose -f {컴포즈 파일명} -d`를 이용해서 컨테이너와 네트워크를 생성하자.

생성이 완료되었으면 `mongodb-container`, `mongo-express-container`라는 두개의 컨테이너와 `mongodb-network`라는 네트워크가 만들어져야한다.

<br>

<p align="center">   <img src="img/mongo3.png" alt="nosql2" style="width: 70%;"> </p>

<br>

`docker network inspect mongodb-network`를 통해서 `mongodb-network`에 두 컨테이너 모두 포함되어 있는지 확인해보자.

<p align="center">   <img src="img/network2.png" alt="nosql2" style="width: 70%;"> </p>

<br>

이제 `mongosh`를 이용해서 몽고DB에 접속해보자.

`mongosh --host 127.0.0.1 --port 27017 --username root --password admin`

또는

`mongosh "mongodb://root:admin@127.0.0.1:27017"`

* `--authenticationDatabase {DB명}` 옵션을 이용하면 해당 `user`가 권한을 가지는 데이터베이스로 접속할 수 있다
* `127.0.0.1` 대신 `localhost` 가능

<br>

 <p align="center">   <img src="img/mongosh.png" alt="nosql2" style="width: 100%;"> </p>

* 연결을 끊기 위해서는 `.exit`, `exit`, `exit()`, `quit`, `quit()` 등을 사용할 수 있다
* `cls`를 이용해서 몽고쉘의 콘솔을 비울수 있다

<br>

---

## 3) MongoDB 사용하기(CRUD)

몽고DB를 사용하는 방법에 대해서 알아보자.

<br>

### 3.1 MongoDB Query Language(MQL)

`mongosh` 명령어 공식 문서 : [https://www.mongodb.com/docs/mongodb-shell/run-commands/](https://www.mongodb.com/docs/mongodb-shell/run-commands/)

`MongoDB` CRUD 공식 문서 : [https://www.mongodb.com/docs/manual/crud/](https://www.mongodb.com/docs/manual/crud/)

이제 몽고DB를 사용해보자.

<br>

> Naming Convention
>
> * 데이터베이스
>   * 소문자
>   * 특수문자 지양
> * 컬렉션
>   * 소문자
>   * 단수가 아닌 복수 사용
> * 필드
>   * 캐멀케이스(CamelCase) 사용
>   * 특수문자 지양
> * 인덱스
>   * 소문자
>   * `xxx_index` 같은 형식 사용

<br>

> `db.help()`
>
> * `db` 객체에 대한 일반적인 메서드 리스트와 설명 출력
>
> 
>
> `show dbs`
>
> * 몽공DB 서버내에 존재하는 모든 데이터베이스에 대한 목록
>
> 
>
> `show collections`
>
> * 현재 사용하는 데이터베이스 내에 존재하는 모든 컬렉션에 대한 목록
>



---

### 3.2 데이터베이스 생성

```sql
use shop
```

* `use dbname`

  * `dbname`이라는 명시한 데이터베이스 이름으로 새로운 데이터베이스를 생성한다

  * 만약 기존에 존재하는 데이터베이스라면 해당 데이터베이스를 이용한다




* `use shop`으로 `shop`이라는 이름의 데이터베이스를 생성하고 사용

<br>

---

### 3.3 `Collection` 생성, 삭제

```js
db.users.insertOne({
    "name" : "엘링 홀란드",
    "gender" : "male",
    "age" : 23,
    "hobbies" : ["축구"],
    "phone" : "010-1234-xxxx"
})
```

* `db.collectionName.insertOne({data}, options)`
  * 만약 해당 컬렉션이 없다면 컬렉션을 생성하고 명시한 데이터를 이용한 도큐먼트가 생성됨
  * 쉽게 말해서 컬렉션이 존재하지 않으면 명시한 컬렉션 이름에 대한 도큐먼트를 처음 생성할 때 해당 컬렉션이 생성된다
  * 컬렉션이 있으면 해당 컬렉션안에 도큐먼트 생성

<br>

<p align="center">   <img src="img/mdb1.png" alt="nosql2" style="width: 60%;"> </p>

<br>

`db.createCollection("컬렉션명")`

* 명시한 컬렉션명으로 비어있는 컬렉션을 생성한다
* 뒤에서 더 자세히 다루겠지만, `schema validation`과 같은 더 자세한 설정을 하고 싶을 때 사용할 수 있다 

<br>

`db.collectionName.drop()`

* 명시한 컬렉션을 삭제한다

<br>

---

### 3.4 Document 생성

#### 3.4.1 `insertOne()`

`syntax`

```js
db.collection.insertOne(
    <document>,
    {
      writeConcern: <document>
    }
)
```

* `db.collectionName.insertOne({data}, options)`
  * 위에서도 설명했듯이 제공한 데이터로 컬렉션안에 단일 도큐먼트를 생성(입력)한다
  * 만약 컬렉션이 존재하지 않으면 명시한 컬렉션명으로 컬렉션을 생성하고 도큐먼트를 생성한다

<br>

---

#### 3.4.2 `insertMany()`

`syntax`

```js
db.collection.insertMany(
   [ <document 1> , <document 2>, ... ],
   {
      writeConcern: <document>,
      ordered: <boolean>
   }
)
```

<br>

`예시`

```js
db.users.insertMany([{
        "name" : "퓨리 타이슨",
        "gender" : "male",
        "age" : 57,
        "hobbies" : ["복싱"],
        "phone" : "010-3456-xxxx"
    },
    {
        "name" : "존 존스",
        "gender" : "male",
        "age" : 36,
        "hobbies" : ["종합격투기"],
        "phone" : "010-5678-xxxx"
    }])
```

* `db.collectionName.insertMany([{doc1}, {doc2}..], options)`
  * 컬렉션안에 다수의 도큐먼트를 생성(입력)한다

<br>

<p align="center">   <img src="img/mdb2.png" alt="nosql2" style="width: 60%;"> </p>

<br>

---

#### 3.4.3 Embedded(Nested) Document

```js
db.users.insertMany([{
        "name" : "김연아",
        "gender" : "female",
        "age" : 33,
        "hobbies" : ["피겨 스케이팅"],
        "phone" : "010-7891-xxxx",
        "address" : {
            "country" : "South Korea",
            "city" : "Seoul",
            "district" : "Heukseok-dong"
        }
    },
    {
        "name" : "오타니 쇼헤이",
        "gender" : "male",
        "age" : 29,
        "hobbies" : ["야구"],
        "phone" : "010-7654-xxxx",
        "address" : {
            "country" : "United States of America",
            "state" : "Hawaii",
            "district" : "Kaunaoa Dr, Waimea"
        }
    }])
```

* 도큐먼트안에 도큐먼트가 들어간 중첩된 형태로 사용가능하다
* 몽고DB는 도큐먼트 중첩을 `100층`까지 제한한다
* 데이터가 적을때는 크게 상관없지만, 데이터가 많아지면 이런 중첩 도큐먼트들이 성능에 대한 오버헤드를 발생시킬수 있다

<br>

<p align="center">   <img src="img/nested1.png" alt="nosql2" style="width: 100%;"> </p>

* 필드는 도큐먼트로 이루어진 배열이 될 수 있다
  * 예: `[{doc1}, {doc2}, ... {docN}]`

<br>

> 도큐먼트 생성은 위의 방법 외에도, 다른 메서드에 특정 옵션을 추가해서 사용할 수도 있다.
>
> *  예) `db.collectionName.updateOne()`에 `upsert:true` 옵션을 사용하면 도큐먼트 생성가능
> * 쉽게 설명하자면, `upsert:true`를 사용해서 업데이트를 하면, 도큐먼트가 존재하는 경우 해당 도큐먼트에 대한 업데이트 작업을 수행하고, 존재하지 않으면 해당 업데이트 작업 내용으로 도큐먼트를 생성한다
>
> <br>
>
> `insert()`라는 메서드도 존재했으나, 지금은 deprecated 되었다.

<br>

---

#### 3.4.4 `ordered` 옵션

기본적으로 몽고DB는 작업이 실패하면, 실패한 작업 부터 모든 작업을 중단한다. 쉽게 이야기 하자면 성공한 작업은 정상적으로 반영되지만, 실패한 작업 부터는 전체 작업이 중단되기 때문에 뒤의 작업이 정상적으로 수행될 수 있어도 반영되지 않는다.

다음 그림으로 이해하면 편할 것이다. 

<br>

 <p align="center">   <img src="img/order1.png" alt="nosql2" style="width: 90%;"> </p>

* 이후에 `_id: "id3"`로 된 도큐먼트를 정상적으로 생성이 가능해도, 기본적으로 옵션이 `ordered: true`로 설정이 되어있기 때문에 도큐먼트 생성이 실패한 곳 부터 전체 작업이 중단된다
* 여기서 알아야 할 것은, 실패 전까지의 반영된 작업은 롤백(`rollback`)되지 않는다는 것이다
  * 몽고DB의 트랜잭션에서 다루겠지만, 트랜잭션을 사용하지 않는 이상 롤백되지 않는다

<br>

그러면 `ordered` 옵션을 `false`로 설정하면 어떻게 될까? 결론적으로 말하자면 작업이 실패한 도큐먼트는 반영되지 않지만, 전체 작업이 중단되지 않고 정상적으로 작업을 반영할 수 있는 도큐먼트는 전부 반영이 된다.

그림으로 살펴보자.

<br>

 <p align="center">   <img src="img/order2.png" alt="nosql2" style="width: 90%;"> </p>

<br>

사용법은 다음과 같다.

```syntax```

```js
db.collection.insertMany([
  {doc1}, {doc2}, ... {docN}
], {ordered: false})
```

<br>

---

#### 3.4.5 :star: `writeConcern` 옵션

쓰기 고려(`writeConcern`) 옵션은 몽고DB가 `write` 작업에 대한 `acknowledgment` 수준을 정할 수 있는 옵션이다.

> 핸드셰이크(Handshake)에서 `syn - ack`의 그 `ack`이  `acknowledgment`이다.
>
> 한국어로 번역하면 승인이라는 뜻이다.

<br>

`writeConcern` 옵션을 통해서 몽고DB가 어느 정도 수준(level)의 승인을 성공적인 쓰기 작업으로 인정하는지 정할 수 있다.

(`writeConcern` 옵션은 로컬 몽고DB에서 사용 불가능하다. 이유는 이 옵션은 여러 노드를 사용하는 레플리케이션 상황에서 사용하기 때문.)

공식문서를 참고하자. [https://www.mongodb.com/docs/manual/reference/write-concern/#std-label-write-concern](https://www.mongodb.com/docs/manual/reference/write-concern/#std-label-write-concern)

<br>

`syntax`

```js
db.collection.insertMany({
  [{doc1}, {doc2}, ...],
  {writeConcern: { w: <value>, j: <boolean>, wtimeout: <number> }}
})
```

* `insertMany()` 외에도 모든 쓰기 작업에 대해서 사용 가능



* `{w: "majority"}`
  * 대다수의 `replica set members`로 쓰기 작업이 커밋되었다는 승인을 받으면 성공으로 인정
* `{w: 1}`
  * `primary node`로 부터 승인되면 성공으로 인정
  * `standalone`(로컬 서버) 상황에서의 기본 옵션
* `{w: 0}`
  * 쓰기 작업을 바로 서버로 보내고 성공으로 인정
  * 승인을 기다리지 않는다
  * 가장 빠르지만, 성공에 대한 보장 확률은 제일 낮다
* `{w: <number>}`
  * 몇 개의 `replica set member`가 승인을 해야 성공으로 인정하는지 최소 한도를 정할 수 있다
  * 예) `{w: 3}`는 최소 `replica set member` 3개의 승인이 필요

<br>

* `j` 옵션과 `wtimeout` 옵션도 있다

<br>

---

### 3.5 Document 수정

#### 3.5.1 `updateOne()`

`syntax`

```js
db.collection.updateOne(
   <filter>,
   <update>,
   {
     upsert: <boolean>,
     writeConcern: <document>,
     collation: <document>,
     arrayFilters: [ <filterdocument1>, ... ],
     hint:  <document|string>,
     let: <document>
   }
)
```

<br>

`예시`

```js
db.users.updateOne({name: "엘링 홀란드"}, {$set: {address: {country: "England", city: "Manchester City"}}})
```

* `db.collectionName.updateOne(filter, update, option)`
  * 필터로 찾은 첫번째 도큐먼트를 제시한 수정 내용으로 수정한다

<br>

<p align="center">   <img src="img/update3.png" alt="nosql2" style="width: 70%;"> </p>

* 예시의 경우 `$set`을 사용한 것을 볼 수 있다
  * `$set`의 경우 명시한 필드가 존재한다면 해당 필드의 내용을 업데이트 해준다
  * 만약 해당 필드가 존재하지 않는다면 필드와 그 내용을 추가한다
  * `$set` 처럼 `$`이 붙은 것들을 `operator`라고 한다

<br>

아래 표는 도큐먼트의 필드 업데이트를 위한 `operator`들이다.

<p align="center">   <img src="img/updatefield.png" alt="nosql2" style="width: 90%;"> </p>

<p align='center'>https://www.mongodb.com/docs/manual/reference/operator/update/#std-label-update-operators</p>

* `Array`에 사용하기 위한 `operator`들도 존재한다
  * [https://www.mongodb.com/docs/manual/reference/operator/update/#array](https://www.mongodb.com/docs/manual/reference/operator/update/#array)

<br>

---

#### 3.5.2 `updateMany()`

`syntax`

```js
db.collection.updateMany(
   <filter>,
   <update>,
   {
     upsert: <boolean>,
     writeConcern: <document>,
     collation: <document>,
     arrayFilters: [ <filterdocument1>, ... ],
     hint:  <document|string>,
     let: <document>
   }
)
```

<br>

`예시`

```js
db.users.updateMany({}, {$inc : {age: 1}})
```

* `db.collectionName.updateMany(filter, update, option)`
  * 필터로 찾은 모든 도큐먼트들을 제시한 수정 내용으로 수정한다



* 예시의 경우 모든 도큐먼트에 대해서 `age` 필드를 `1` 증가시키는 업데이트를 적용한다
  * 필터에 `{}`를 사용하면 모든 도큐먼트를 선택한다

<br>

> `update()`라는 메서드도 있었지만 `mongosh`가 도입되면서 deprecated 되었다.

<br>

---

### 3.6 Document 삭제

#### 3.6.1 `deleteOne()`

`syntax`

```js
db.collection.deleteOne(
    <filter>,
    {
      writeConcern: <document>,
      collation: <document>,
      hint: <document|string>
    }
)
```

<br>

`예시`

```js
db.users.deleteOne({name: "퓨리 타이슨"})
```

* `db.collectionName.deleteOne(filter, option)`
  * 필터로 찾은 첫 번째 도큐먼트를 삭제한다



* 예시의 경우 `name`이 `퓨리 타이슨`으로 찾은 첫 번째 도큐먼트를 삭제한다

<br>

---

#### 3.6.2 `deleteMany()`

`syntax`

```js
db.collection.deleteMany(
   <filter>,
   {
      writeConcern: <document>,
      collation: <document>
   }
)
```

<br>

`예시`

```js
db.users.deleteMany({"age" : {$gt: 33}})
```

* `db.collectionName.deleteMany(filter, option)`
  * 필터로 찾은 모든 도큐먼트를 삭제한다



* 예시의 경우 `age`가 `33` 보다 많은 모든 도큐먼트를 삭제한다
  * `$gt` : greater than

<br>

---

### 3.7 Document 조회

#### 3.7.1 `mongoimport`

`mongoimport`를 이용해서 `JSON`이나 `CSV` 파일을 몽고DB 데이터베이스로 데이터를 임포트하는 방법을 알아보자. 사용하기 위해서는 `mongodb-database-tools`을 설치하면 된다.

<br>

`사용법`

```
mongoimport --uri mongodb://<username>:<password>@<hostname>:<port>/<DB명> --collection <컬렉션명> 
--file <파일디렉토리> --authenticationDatabase admin
```

* `--drop` 옵션을 추가하는 경우, 컬렉션이 이미 존재하는 경우 컬렉션을 먼저 삭제해준다

<br>

[https://github.com/ozlerhakan/mongodb-json-files/blob/master/datasets/books.json](https://github.com/ozlerhakan/mongodb-json-files/blob/master/datasets/books.json)의 데이터셋을 이용할 것이다.

```
mongoimport --uri mongodb://root:admin@localhost:27017/shop --collection books 
--file books.json --authenticationDatabase admin
```

<br>

---

#### 3.7.2 `find()`

`syntax`

```js
db.collection.find(<query>, <projection>, <options>)
```

* `db.collectionName.find(query, projection, option)`
  * 뷰(view)나 컬렉션의 더큐먼트들을 쿼리에 맞춰서 조회하고 커서(cursor)를 반환한다
    * RDBMS의 `ResultSet`에 대해 커서를 반환하는 것과 비슷한걸로 생각하면 된다



* **반환한 커서를 `var` 키워드를 이용해서 변수에 할당하지 않을 경우 몽고쉘(`mongosh`)에서 자동으로 `20`번 `iterate` 해서, 첫 `20` 도큐먼트를 결과로 출력하도록 설정 되어있다**
  * 뒤에서 더 자세히 다룰 예정이다



* `projection`을 이용해서 특정 필드만을 조회할 수 있다
  * 생략시, 기본적으로 모든 필드를 조회한다

<br>

`find()`를 이용해서 다양한 쿼리를 적용해보자.

<br>

> `findOne()`
>
> * 찾은 첫 번째 도큐먼트만 조회한다
> * 조건에 맞는 첫 번째 도큐먼트만 조회하고 싶을때 사용 가능
> * `pretty()`는 사용불가
> * 커서 반환이 아닌 단일 도큐먼트 반환

<br>

---

#### 3.7.3 모든 도큐먼트 조회

> 들어가기에 앞서 `3.7.3` ~ `3.7.7`은 커서를 이용하는 것이 아니라, 몽고쉘(`mongosh`)이 기본적으로 `20`개의 도큐먼트를 출력하는 기능을 이용했다.
>
> 커서에 대한 내용은 뒤에서 더 자세히 다룰 예정이다.

<br>

`syntax`

```
db.collection.find({})
```

* `{}`를 생략가능

<br>

`예시`

```js
db.books.find().pretty()
```

* 예시의 경우 `find()`에 빈 쿼리를 사용했다. 이 경우 컬렉션의 모든 도큐먼트를 조회한다

  

* `SQL`은 `SELECT * FROM books;`에 해당



* `pretty()`를 사용하면 결과를 더 정리된 포맷으로 확인 가능

<br>

<p align="center">   <img src="img/find1.png" alt="nosql2" style="width: 90%;"> </p>

<br>

---

#### 3.7.4 동등 조건으로 도큐먼트 조회

`syntax`

```
db.collection.find({<field>:<value>})
```

<br>

`예시`

```js
db.books.find({pageCount : 425})
```

* `db.collection.find({<field>:<value>})`
  * `field`의 `<value>`값과 동일한 도큐먼트들을 조회한다



* 예시의 경우 `pageCount`가 `425`인 모든 도큐먼트들을 조회한다



* `SQL`은 `SELECT * FROM books WHERE pageCount = 425;`에 해당

<br>

<p align="center">   <img src="img/find2.png" alt="nosql2" style="width: 90%;"> </p>

<br>

---

#### 3.7.5 쿼리 오퍼레이터를 이용한 조건으로 도큐먼트 조회, Projection

```syntax```

```
db.collection.find({ <field1>: { <operator1>: <value1> }, ... })
```

<br>

`예시`

```js
db.books.find(
  {categories: {$in: ["Java","Internet"]}}, 
  {title: 1, categories: 1}
)
```

* `{categories: {$in: ["Java","Internet"]}}` 
  * `categories`안에 `Java` 또는 `Internet`이 하나라도 포함되어 있으면 조회
  * `SQL`은 `SELECT * FROM books WHERE categories in ("Java", "Internet")`에 해당한다



* `{title: 1, categories: 1}` : Projection
  * `title`과 `categories` 필드만 조회
  * `_id`의 경우 `1`로 설정하지 않아도 무조건 조회한다. 조회하고 싶지 않다면 명시적으로 `_id: 0`으로 설정해야 한다
  * `SQL`은 `SELECT _id, title, categories FROM`에 해당한다

<br>

<p align="center">   <img src="img/find4.png" alt="nosql2" style="width: 100%;"> </p>

<br>

---

#### 3.7.6 `AND`, `OR` 조건

`AND 예시`

```js
db.books.find(
  {categories: "Java", pageCount: {$lt: 350}},
  {title: 1, pageCount: 1, categories: 1}
)
```

* `{categories: "Java", pageCount: {$lt: 350}}`
  * 기본적으로`{}`안에 아무것도 명시하지 않을 경우 `,`로  `AND` 연산으로 처리한다



* `SQL`은 `SELECT _id, title, pageCount, categories FROM books WHERE catgories = "Java" AND pageCount < 350;`에 해당한다

<br>

<p align="center">   <img src="img/find5.png" alt="nosql2" style="width: 100%;"> </p>

<br>

---

`OR 예시`

```js
db.books.find(
  {title: {$regex: /^Understanding/}, 
   $or: [{pageCount: {$lt: 600}}, {categories: "Java"}]
  },
  {title: 1, pageCount: 1, categories: 1}
)
```

* `title: {$regex: /^Understanding/}` 
  * 정규표현식을 이용해서 `title`이 `Understanding`으로 시작하는 도큐먼트 조회



* `$or: [{pageCount: {$lt: 600}}, {categories: "Java"}]`
  * `{pageCount: {$lt: 600}}`와 `{categories: "Java"}`는 `OR` 연산으로 연결
  * `pageCount`가 `600`미만이거나 `categories`가 `Java`인 도큐먼트 조회



* `title: {$regex: /^Understanding/}`와 `$or: [{pageCount: {$lt: 600}}, {categories: "Java"}]`는 `AND` 연산으로 연결



* `SQL`은 `SELECT _id, title, pageCount, categories FROM books WHERE title LIKE "Understanding%" AND (pageCount < 600 OR categories = "Java");`에 해당한다

<br>

<p align="center">   <img src="img/find6.png" alt="nosql2" style="width: 60%;"> </p>

<br>

---

#### 3.7.7 Nested 도큐먼트의 필드를 이용해서 조회

`예시`

```js
db.users.find({"address.country": "England"})
```

* `{"<innerDocument>.<field>" : <value>}` 같은 형태로 사용하면 된다

<br>

<p align="center">   <img src="img/find7.png" alt="nosql2" style="width: 60%;"> </p>

<br>

---

#### 3.7.8 :star: ​`find()`와 cursor

**지금까지 `find()`를 사용해서 도큐먼트를 조회했지만, `find()`는 도큐먼트를 반환하는 메서드가 아니다!** 이전에도 설명했지만, `find()`는 **커서(cursor)**를 반환한다. `mongosh`(몽고쉘)에서는 반환한 커서를 `var` 키워드를 이용해서 변수에 할당하지 않을 경우 몽고쉘(`mongosh`)에서 자동으로 `20`번 `iterate` 해서, 첫 `20` 도큐먼트를 결과로 출력하도록 설정 되어있다.

<br>

그러면 커서를 매뉴얼하게 iterate하는 방법에 대해서 알아보자.

몽고쉘에서는 `find()`를 통해 반환 받은 커서를 `var` 키워드를 이용해서 변수에 할당하면 커서는 자동으로 `20`번 `iterate` 하지 않는다

이때 커서를 할당한 변수를 호출하면 기존에 몽고쉘이 해줬던 것 처럼 `20`번 `iterate` 해서 매칭 도큐먼트들을 출력할 수 있다.

<br>

`예시`

```js
var booksCursor = db.books.find({}, {title: 1, categories: 1});

booksCursor.pretty()
```

* 기존에 `find().pretty()`는 결국에 커서에 `pretty()` 메서드를 사용했던 것이다
* 커서를 할당받은 변수에 `pretty()`를 사용할 수 있다는 뜻이다

<br>

<p align="center">   <img src="img/cursor1.png" alt="nosql2" style="width: 60%;"> </p>

<br>

그러면 이번에는 `next()` 메서드를 이용해서 매칭된 도큐먼트에 접근해보자. 

<br>

`예시`

```js
var booksCursor = db.books.find({categories: "Java"}, {title: 1, categories: 1});

while (booksCursor.hasNext()) {
  printjson(booksCursor.next());
}
```

* `hasNext()` : 현재 커서가 더 `iterate`이 가능하다면(도큐먼트가 더 남았다면) `true`를 반환한다
* `next()` : 현재 커서 위치 기준으로 다음 도큐먼트를 가져온다
  * 다음 도큐먼트를 가져온후 커서 위치를 다음으로 옮긴다

* 위 예시는 반복문을 돌면서 필터에 매칭된 모든 도큐먼트를 출력한다
  * 커서의 현재 위치 기준, 다음 도큐먼트가 존재하지 않으면 `hasNext()`는 `false`를 리턴하고 반복문이 끝난다

<br>

이번에 `forEach()`를 사용해보자.

<br>

`예시`

```js
var booksCursor = db.books.find({categories: "Java"}, {title: 1, categories: 1});

booksCursor.forEach(printJson)
```

* 바로 이전 `next()`를 이용한 예시와 똑같은 결과를 얻을 수 있다

<br>

`forEach() syntax`

```js
db.collection.find().forEach( <function> )
```

* `function` : 자바스크립트 코드가 들어갈 수 있다

<br>

---

#### 3.7.9 `sort()`

`result set`의 정렬 기준을 정할 수 있다.

대표적으로 오름차순/내림차순 정렬을 정할 수 있다.

공식 문서 참고 : [https://www.mongodb.com/docs/manual/reference/method/cursor.sort/#syntax](https://www.mongodb.com/docs/manual/reference/method/cursor.sort/#syntax)

<br>

`예시`

```js
db.books.find({}, {title: 1, pageCount: 1, categories: 1}).sort({pageCount: 1}).pretty()
```

* `pageCount`를 기준으로 결과를 오름차순 정렬을 한다
  * `-1`로 설정시 내림차순 정렬을 한다
* 여러 필드를 기준으로 정할 수 있다

<br>

<p align="center">   <img src="img/sort1.png" alt="nosql2" style="width: 60%;"> </p>

<p align="center">pageCount를 기준으로 오름차순 정렬</p>

<br>

---

## 4) MongoDB 스키마 설계

### 4.1 스키마 설계

스키마를 어떻게 설계하는 것이 좋을까? 

프로젝트나 서비스의 요구사항과 상황에 따라 다르겠지만, 거의 모든 경우 기준이 되는 고정된 스키마로 시작을 한다. 이때 사람들은 MongoDB와 같은 NoSQL 데이터베이스의 강점이 경직된 스키마가 아닌 유연한 스키마가 아니냐는 의문점을 가질것이다.

맞다. 그러나 그것이 스키마를 아무런 기준도 없이 마구잡이로 저장한다는 뜻은 아니다. 다음 그림을 살펴보자.

<br>

<p align="center">   <img src="img/schema1.png" alt="nosql2" style="width: 100%;"> </p>

* 위 그림에서도 알 수 있듯이 오른쪽 방향으로 갈 수록 기존 SQL 데이터베이스의 정형화된 스키마를 사용하는 것을 확인할 수 있다

<br>

NoSQL이 가지는 유연한 스키마의 강점은 중간의 스키마 처럼 추가할 필드가 필요하면, 쉽게 추가가 가능하다는 점이다. 만약 기존의 RDBMS 데이터베이스를 사용하는 경우라면, 필드(RDBMS의 경우 속성)를 추가하기 위해서는 기존 테이블의 스키마 변경을 무조건 했어야한다. 이때, 이미 프로덕션에 들어가 있는 테이블에 스키마 변경을 시도하는 것은 쉽지 않은 일이다. 또한 이런 어려움을 피하려고, 핫픽스로 애플리케이션 레벨에서 수정을 하게 되면 점점 기술 부채가 늘어나게 된다. (한마디로 코드가 더러워진다!)

반면에 몽고DB에서는 처음 부터 애플리케이션 레벨에서 관리를 하고, 필드를 추가하는 경우에도 기존 도큐먼트에 대한 스키마 변경을 강제하지 않아도 된다는 장점이 있다.

<br>

그러면 좋은 스키마를 설계하기 위해선 어떻게 해야할까? 

좋은 스키마에는 정답이 없다. 애플리케이션이 필요하거나 생성하는 데이터의 종류, 회사가 사용할 수 있는 자원의 여유, 데이터의 양, 프로젝트 마감 기간, 등 여러가지 고려 사항이 있기 때문이다. 적절한 스키마를 찾기 위해서는 현재 처한 상황과 요구사항을 잘 파악하고 베스트 프랙티스로 나와있는 방법들을 고려하면서 설계하자.

<br>

---

### 4.2 Nested(Embedded) Document vs Reference

스키마를 설계하면서 이런 고민을 맞닥뜨릴 것이다.

반복되는 데이터가 있어도 하나의 도큐먼트 안에 전부 저장할 것인지, 아니면 RDBMS 데이터베이스를 사용하는 것 처럼 참조를 이용해서 다른 컬렉션에서 데이터를 가져와서 사용할 것인지(RDBMS로 치면 `JOIN`을 사용할 것인지).

<br>

<p align="center">   <img src="img/lookup1.png" alt="nosql2" style="width: 100%;"> </p>

* 보통의 경우 강한 `One-to-One` 관계이면 `Embedded(Nested) Document`를 사용
  * 예) 한 환자당 유일하게 존재하는 환자 진단서



* `One-to-Many`, `Many-to-Many` 관계에서 만약 자주 반복적으로 사용되는 중복 데이터가 있고, 이런 중복 데이터가 자주 변하는 경우라면 `Reference`를 사용하는 것이 편할 수 있다
  * 예) 특정 유저가 가지고 있는 책, 자동차에 대한 정보



* 이전 스키마 설계에서도 설명했듯이, 관계(relation) 설정도 결국에는 프로젝트 요구사항과 상황에 따라 어떤식으로 관계를 설정할 것인지 정하면 된다
  * 예1) 애자일하게 개발해야하는 상황이라면 `Nested Document`로 전부 저장했다가 추후에 사용자나 데이터가 많아지면 리팩토링하는 방향으로 진행할 수 있다
  * 예2) 자주 중복되는 내용이라도, `JOIN`이 필요없는 이점을 사용하기 위해서 `Nested Document`를 사용할 수 있다
  * 예3) 중복되는 내용이 자주 바뀌는 상황이라면, 따로 컬렉션으로 분리하고 `Reference`해서 사용할 수 있다



* `Reference`해서 사용하기 위해서는 `aggregate` 파이프라인의 `$lookup` 연산자를 사용해야한다
* `aggregate`에 대해서는 뒤에서 더더 자세히 다룰 예정이다 



* 위 그림에서 `$lookup`은 다음과 같이 사용한다

* ```js
  db.users.aggregate([
  	{
  		$lookup: {
  			from: "cars",
  			localField: "carId",
  			foreignField: "_id",
  			as: "carDetail"
  		}
  	}
  ])
  ```

  * `from` : `JOIN`을 수행할 타겟 컬렉션
  * `localField` : 기존 컬렉션에서 타겟 컬렉션인 `cars`의 `foreignField`와 매칭되어야 할 필드
  * `foreignField` :  타겟 컬렉션의 필드 중에 `localField`와 매칭될 필드
  * `as` : 기존 필드에 추가될 결과 배열 필드의 이름

<br>

`aggregate`와 `$lookup`에 대한 내용은 뒤에서 더 자세히 다룰 예정이다.

<br>

---

### 4.3 :star: 스키마 검증(Validation)

스키마를 설계하면서, 어떤 경우에는 스키마를 강제하고 싶을 수 있다. 

이때 스키마 검증(Schema Validation)을 사용할 수 있다. 다음과 같은 경우들이 존재한다.

* `user` 컬렉션에 비밀번호(`password`)를 오로지 `string` 타입으로 입력하도록 강제하는 경우
* `post`라는 컬렉션에 반드시 `title`, `content`, `creator`라는 필드를 가지도록 강제하고, `tags`와 `comment`는 선택 사항으로 설계하고 싶은 경우

<br>

그러면 스키마 검증(schema validation)이 검증 레벨(validation level)과 검증 행동(validation action)에 따라 어떻게 동작하는지 알아보자.

먼저 스키마는 다음과 같이 설계하자.

> 컬렉션 : `customer`
>
> 필수 필드
>
> * `name` : `string` 타입
> * `age` : `int` 타입
>   * 범위 : `0 ~ 200`
>
> 선택 필드
>
> * `email` : `string` 타입

<br>

데이터 모델링 공식 문서 : [https://www.mongodb.com/docs/manual/data-modeling/](https://www.mongodb.com/docs/manual/data-modeling/)

<br>

---

#### 4.3.1 스키마 검증 적용

컬렉션을 스키마 검증 규칙과 함께 생성하기 위해서는 `createCollection()`과 `$jsonSchema`를 사용한다.

`예시`

```js
db.createCollection("customer", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      title: "Customer Schema Validation",
      required: ["name", "age"],
      properties: {
        name: {
          bsonType: "string",
          description: "name field is required and must be a string"
        },
        age: {
          bsonType: "int",
          description: "age field is required and must be a integer"
        },
        email: {
          bsonType: "string",
          description: "email field is not required and must be a string"
        }
      }
    }
  }
})
```

* `title`: 설정한 검증 규칙에 대한 설명을 추가할 수 있다
* `description` : 특정 필드에 대한 검증 규칙을 설명을 추가할 수 있다



* `required` : 필수로 입력해야하는 필드를 명시한다
* `properties` : 특정 필드들이 가져야할 데이터 타입(`bsonType`), `description`을 명시한다
  * `enum`을 추가해서 특정 값만 올 수 있도록 제한할 수 있다. [참고](https://www.mongodb.com/docs/manual/core/schema-validation/specify-json-schema/specify-allowed-field-values/#std-label-schema-allowed-field-values) 

<br>

이제 위 명령어를 가지고 스키마 검증이 있는 컬렉션을 생성하고, 몇 가지 도큐먼트들을 생성해보자. 

<br>

먼저 검증 규칙을 모두 만족해서 정상적으로 도큐먼트가 생성되는 경우를 살펴보자. 

`첫 번째 도큐먼트`

```js
db.customer.insertOne({
  name: "김메시",
  age: 10
})
```

`두 번째 도큐먼트`

```js
db.customer.insertOne({
  name: "최날두",
  age: 20,
  email: "choinaldu1234@xxx.com"
})
```

* 위 두 경우는 검증 규칙을 모두 만족하기 때문에 정상적으로 도큐먼트가 생성된다

<br>

이번에는 필수 필드로 지정된 필드를 제외한 경우를 살펴보자.

```세 번째 도큐먼트```

```js
db.customer.insertOne({
  name: "박타이슨"
})
```

* 필수 필드인 `age`가 제외되었다
* 이 경우에는 `Document Failed Validation` 에러가 뜨면서 도큐먼트 생성이 거절된다

<br>

<p align="center">   <img src="img/val1.png" alt="nosql2" style="width: 60%;"> </p>

<p align="center">필수 필드인 age가 빠져서 검증 실패</p>

<br>

이번에는 지정한 데이터 타입외의 타입을 사용하는 경우를 살펴보자.

```네 번째 도큐먼트```

```js 
db.customer.insertOne({
  name: "이가누",
  age: 40,
  email: 666
})
```

* `email`을 `string`이 아닌 `int`를 입력했다
* 이 경우에도 검증이 실패하는 것을 확인 할 수 있다

<br>

<p align="center">   <img src="img/val2.png" alt="nosql2" style="width: 60%;"> </p>

<p align="center">필수 필드는 아니지만 email을 'string'이 아닌 'int'를 입력해서 검증 실패</p>

<br>

---

#### 4.3.2 `validationAction`

검증이 실패하면 몽고DB는 기본적으로 문제가 생긴 필드들을 에러 결과에 포함해서 출력한다.

몽고DB는 검증이 실패한 도큐먼트에 대해서 어떻게 처리할 것인지 `validationAction`을 설정할 수 있도록 기능을 제공한다.

기본적으로 `validationAction`은 `error`로 설정되어 있다. [참고](https://www.mongodb.com/docs/manual/core/schema-validation/handle-invalid-documents/)

<br>

<p align="center">   <img src="img/valaction1.png" alt="nosql2" style="width: 90%;"> </p>

<p align="center">https://www.mongodb.com/docs/manual/core/schema-validation/handle-invalid-documents/</p>

<br>

`validationAction`을 설정하는 방법은 다음과 같다.

```예시```

```js
db.createCollection("customer", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      title: "Customer Schema Validation",
      required: ["name", "age"],
      properties: {
        name: {
          bsonType: "string",
          description: "name field is required and must be a string"
        },
        age: {
          bsonType: "int",
          description: "age field is required and must be a integer"
        },
        email: {
          bsonType: "string",
          description: "email field is not required and must be a string"
        }
      }
    }
  },
  validationAction: "warn"
})
```

* 기존 `validator` 다음에 `validationAction` 필드를 추가하면 된다

* `warn`으로 설정하는 경우 검증이 실패해도 도큐먼트 생성이나 변경 사항을 적용하지만, 검증 실패에 대한 기록을 몽고DB 로그에 추가한다. 

* 로그 확인

  * ``` js
    db.adminCommand(
       { getLog:'global'} ).log.forEach(x => { print(x) }
    )
    ```

<br>

---

#### 4.3.3 `validationLevel`

 이번에는 `validationLevel`을 설정하는 방법에 대해서 알아보자.

`validationLevel`을 통해서 몽고DB가 어느 정도 수준으로 검증 규칙을 적용할 것인지 정할 수 있다. [참고](https://www.mongodb.com/docs/manual/core/schema-validation/specify-validation-level/#std-label-schema-specify-validation-level)

<br>

<p align="center">   <img src="img/vallevel.png" alt="nosql2" style="width: 90%;"> </p>

<p align="center">https://www.mongodb.com/docs/manual/core/schema-validation/specify-validation-level/</p>

<br>

적용 방법은 다음과 같다.

`예시`

```js
db.createCollection("customer", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      title: "Customer Schema Validation",
      required: ["name", "age"],
      properties: {
        name: {
          bsonType: "string",
          description: "name field is required and must be a string"
        },
        age: {
          bsonType: "int",
          description: "age field is required and must be a integer"
        },
        email: {
          bsonType: "string",
          description: "email field is not required and must be a string"
        }
      }
    }
  },
  validationAction: "error",
  validationLevel: "strict"
})
```

* `strict`
  * 디폴트 `validationLevel`
  * 도큐먼트가 생성되거나 업데이트할 때 항상 검증을 수행한다



* `moderate`
  * 기존에 존재하던 도큐먼트들 중에서 검증 규칙에 맞지 않았던(통과하지 못하는) 도큐먼트들은 업데이트를 적용시 검증을 수행하지 않는다

<br>

---

#### 4.3.4 스키마 검증 규칙 변경

기존에 적용했던 스키마 검증에 대한 규칙을 변경하는 방법에 대해서 알아보자. [참고](https://www.mongodb.com/docs/manual/core/schema-validation/update-schema-validation/#std-label-schema-update-validation)

스키마 검증을 변경하기 위해서는 `collMod` 명령을 사용한다. 사용법은 다음과 같다. (기존 스키마를 이어서 사용하고 있다)

<br>

`예시`

```js
db.runCommand( { collMod: "customer",
  validator: {
    $jsonSchema: {
      bsonType: "object",
      title: "Customer Schema Validation",
      required: ["name", "age", "gender"],
      properties: {
        name: {
          bsonType: "string",
          description: "name field is required and must be a string"
        },
        age: {
          bsonType: "int",
          description: "age field is required and must be a integer"
        },
        email: {
          bsonType: "string",
          description: "email field is not required and must be a string"
        },
        gender: {
          bsonType: "string",
          description: "gender field is required and must be a string"
        }
      }
    }
  }
})
```

* 기존 스키마 검증 규칙에서 `required`에 `gender` 필드를 추가하고, 데이터 타입은 `string`을 사용하도록 검증 규칙을 변경하였다
* `collMod`를 이용해서 스키마 검증이 없던 기존의 컬렉션에 스키마 검증을 추가하는 것도 가능하다

<br>

---

## 5) MongoDB 인덱스(Index)

### 5.1 인덱스 소개

몽고DB도 다른 RDBMS 데이터베이스와 마찬가지로 인덱스(Index)를 제공한다.

만약 인덱스를 사용하지 않는다면 쿼리 결과를 얻기 위해서 항상 전체 컬렉션을 커렉션-스캔(collection-scan)해서 결과를 얻어야 한다. (RDBMS로 치면 테이블에 대해 풀스캔 한다고 생각하면 편하다)

같은 필드에 대해서 쿼리를 자주 사용한다면 인덱스를 생성하는 것을 고려해보자.

추가적인 내용.

* 몽고DB는 인덱스를 `B-tree`로 구현한다.
  * `_id` 필드에는 기본적으로 고유 인덱스([`unique index`](https://www.mongodb.com/docs/manual/core/index-unique/#std-label-index-type-unique))가 생성되어 있다

<br>

참고 : [이전 포스트에서 다룬 RDBMS에서의 인덱스](../(002)%20Using%20SQL#7-%EC%9D%B8%EB%8D%B1%EC%8A%A4index)

<br>

---

### 5.2 인덱스 생성

인덱스에도 다양한 종류가 존재한다. 인덱스를 생성하는 방법에 대해서 알아보자.

공식 문서 참고 : [https://www.mongodb.com/docs/manual/core/indexes/create-index/](https://www.mongodb.com/docs/manual/core/indexes/create-index/)

<br>

`syntax`

```js
db.collection.createIndex( <key and index type specification>, <options> )
```

<br>

인덱스의 종류는 다양하다. 공식 문서 : [https://www.mongodb.com/docs/manual/core/indexes/index-types/](https://www.mongodb.com/docs/manual/core/indexes/index-types/)

* Single Field Index
* Compound Index
* Multikey Index
* Geospatial Index
* Text Index
* Hashed Index

<br>

상황에 맞게 알맞은 인덱스를 생성해서 사용하자. 예시로는 `Single Field Index`를 생성해보자.

<br>

`예시`

```js
db.books.createIndex({pageCount : 1})
```

* `Single Field Index`의 경우 몽고DB는 양방향 탐색이 가능하기 때문에 오름차순과 내림차순에 차이는 없다
* 예시의 경우 `pageCount` 필드에 대해서 인덱스를 생성하였다
  * `1`은 오름차순 탐색이며, `-1`은 내림차순이다

* `Compound Field Index`(복합 필드 인덱스)는 위의 예시에서 필드를 더 추가하기만 하면 된다
* `unique`과 같은 옵션들도 존재한다

<br>

특정 컬렉션에서 생성한 인덱스를 조회하기 위해서는 다음 명령어를 사용한다.

```js
db.collection.getIndexes()
```

<br>

하나의 인덱스를 제거하기 위해서는 다음 명령어를 사용한다

```js
db.collection.dropIndex("<indexName>")
```

<br>

여러개의 인덱스를 제거하기 위해서는 다음 명령어를 사용한다.

```js
db.collection.dropIndexes(["<index1>", "<index2>", ...])
```

* `_id` 인덱스를 모든 인덱스를 제거하기 위해서는 `db.collection.dropIndexes()`

<br>

---

### 5.3 쿼리 소요 시간 확인

사용한 쿼리에 대한 소요 시간과 같은 여러 메트릭(metric)을 확인할 수 있는 명령어는 다음과 같다.

`예시`

```js 
db.books.find({pageCount: {$get: 400}}).explain("executionStats")
```

* `explain("executionStats")`를 사용하면 된다

<br>

---

## 6) Aggregation Pipeline

### 6.1 Aggregation Pipeline 소개

몽고DB의 aggregate 연산에 대해서 알아보자.

몽고DB의 aggregation은 컬렉션(다수의 도큐먼트)에 대해서 데이터 처리 및 변환 작업을 할 수 있도록 해준다. 조금 풀어서 설명하자면, 컬렉션에 대해서 필터링, 그룹, 조인, 정렬, 분석 등의 복합적인 데이터 작업을 가능하도록 해준다. 이런 aggregation은 `aggregation pipeline`을 통해서 수행할 수 있다.

공식 문서 참고 : [https://www.mongodb.com/docs/manual/aggregation/#std-label-aggregation-pipeline-intro](https://www.mongodb.com/docs/manual/aggregation/#std-label-aggregation-pipeline-intro)

<br>

`Aggregation pipeline`은 도큐먼트를 처리하기 위한 하나 이상의 스테이지로 구성되어있다.

* 각 스테이지는 인풋 도큐먼트에 대해서 연산을 수행한다
  * 예) 필터링, 그룹핑, 계산, 등
* 이전 스테이지의 결과 도큐먼트들은 다음 스테이지로 넘겨진다
* 이런 스테이지들로 이루어진 `aggregation pipeline`의 결과로 계산된 값이 나올수도 있고, 도큐먼트가 나올수도 있다
* 뒤에서도 다루겠지만 `aggregate()`를 이용한 `aggregation pipeline`은 `$merge` 또는 `$out` 스테이지를 포함하지 않는 이상, 원본 도큐먼트를 수정하지 않는다(보통 `aggregation` 과정 중에 메모리 위에 복사본을 생성해서 연산을 진행한다)

<br>

사용법에 대해서 알아보자.

`syntax`

```js
db.collection.aggregate( <pipeline>, <options> )
```

* `<pipeline>` : 파이프라인을 구성하는 스테이지의 연산들을 배열 형태로 전달한다
  * 예) `[{stage1}, {stage2}, ... ]`

* `<options>` : 제공하는 옵션을 설정할 수 있다

<br>

<p align="center">   <img src="img/ap.png" alt="nosql2" style="width: 90%;"> </p>

<p align="center">https://www.mongodb.com/blog/post/joins-and-other-aggregation-enhancements-coming-in-mongodb-3-2-part-1-of-3-introduction</p>

<br>

---

### 6.2 사용 예시

실제 예시를 통해서 사용해보자.

<br>

`예시`

```js
db.books.aggregate([
  // Stage 1: status 'PUBLISH'인 도큐먼트를 매칭한다
  { $match: { status: 'PUBLISH' } },

  // Stage 2: 필요한 필드만 프로젝션
  { $project: { title: 1, authors: 1, categories: 1 } },

  // Stage 3: 'categories' 필드를 배열의 요소별로 분리한다
  { $unwind: '$categories' },

  // Stage 4: 'categories' 필드로 Grouping하고 각 카테고리별로 요소를 카운트
  {
    $group: {
      _id: '$categories', // Group by category
      count: { $sum: 1 }  // Count documents in each category
    }
  },

  // Stage 5: 'count'를 기준으로 내림차순 정렬 
  { $sort: { count: -1 } }
])
```

```
[
  { _id: 'Java', count: 95 },
  { _id: 'Internet', count: 41 },
  { _id: 'Microsoft .NET', count: 33 },
  { _id: 'Web Development', count: 16 },
  { _id: 'Software Engineering', count: 15 },
  { _id: 'Programming', count: 12 },
  { _id: 'Business', count: 12 },
  { _id: 'Client-Server', count: 11 },
  { _id: 'Microsoft', count: 8 },
  { _id: 'Networking', count: 7 },
  { _id: 'PowerBuilder', count: 7 },
  { _id: 'Theory', count: 7 },
  { _id: 'Perl', count: 6 },
  { _id: 'Computer Graphics', count: 6 },
  { _id: 'Python', count: 6 },
  { _id: 'Mobile Technology', count: 5 },
  { _id: 'XML', count: 4 },
  { _id: 'Object-Oriented Programming', count: 4 },
  { _id: 'Miscellaneous', count: 2 },
  { _id: 'Open Source', count: 2 }
]
```

<br>

`Aggregation Pipeline`에 사용할 수 있는 연산은 굉장히 많다. 공식 문서를 참고하면서 프로젝트에 적용해보자.

공식 문서 : [https://www.mongodb.com/docs/manual/core/aggregation-pipeline/](https://www.mongodb.com/docs/manual/core/aggregation-pipeline/)

<br>

---

## 7) Java MongoDB Driver

### 7.1 MongoDB 드라이버로 연결

자바의 몽고DB 드라이버를 통해 몽고DB 데이터베이스에 연결하고 사용해보자.

몽고DB와 통신하면서 쿼리하는 문법은 언어별로 서로 다르다. 그러나 이전 몽고쉘에서 다룬 컨셉들과 동작원리는 동일하다.

공식 문서 참고 : [https://www.mongodb.com/docs/drivers/java/sync/current/quick-start/](https://www.mongodb.com/docs/drivers/java/sync/current/quick-start/)

<br>

`build.gradle`의 `dependencies`에 `lombok`, `mongodb-driver`, `slf4j`를 사용할 수 있도록 추가.

```groovy
dependencies {
    testImplementation platform('org.junit:junit-bom:5.9.1')
    testImplementation 'org.junit.jupiter:junit-jupiter'

    compileOnly 'org.projectlombok:lombok:1.18.32'
    annotationProcessor 'org.projectlombok:lombok:1.18.32'

    testCompileOnly 'org.projectlombok:lombok:1.18.32'
    testAnnotationProcessor 'org.projectlombok:lombok:1.18.32'


    implementation 'org.slf4j:slf4j-api:1.7.32'
    implementation 'ch.qos.logback:logback-classic:1.4.12'

    implementation 'org.mongodb:mongodb-driver-sync:5.1.0'
}
```

<br>

몽고DB와 연결하고 쿼리까지 해보는 코드를 구현해보자.

<br>

`database.properties`

```properties
mongodb.username=root
mongodb.password=admin
mongodb.host=localhost
mongodb.port=27017
mongodb.database=shop
```

<br>

`dbutil/MongoDBPropertiesLoader`

```java
@Slf4j
public class MongoDBPropertiesLoader {
    private static final String PROPERTIES_FILE = "database.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream input = MongoDBPropertiesLoader.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                System.out.println("file not found");
            }

            properties.load(input);
        } catch (IOException e) {
            log.error("MongoDBPropertiesLoader error", e);
        }
    }

    public static String getHost() {
        return properties.getProperty("mongodb.host");
    }

    public static  String getPort() {
        return properties.getProperty("mongodb.port");
    }

    public static String getDatabase() {
        return properties.getProperty("mongodb.database");
    }

    public static String getUsername() {
        return properties.getProperty("mongodb.username");
    }

    public static String getPassword() {
        return properties.getProperty("mongodb.password");
    }

}
```

<br>

이제 실제로 몽고DB에 연결하고 간단한 쿼리를 통해 조회해보자.

<br>

`ConnectMain`

```java
@Slf4j
public class ConnectMain {
    public static void main(String[] args) {

        String HOST = MongoDBPropertiesLoader.getHost();
        String PORT = MongoDBPropertiesLoader.getPort();
        String DATABASE = MongoDBPropertiesLoader.getDatabase();
        String USERNAME = MongoDBPropertiesLoader.getUsername();
        String PASSWORD = MongoDBPropertiesLoader.getPassword();
        String URI = "mongodb://"+USERNAME+":"+PASSWORD+"@" +HOST+":"+PORT;

        try (MongoClient mongoClient = MongoClients.create(URI)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE);
            MongoCollection<Document> collection = database.getCollection("books");

            Document projection = new Document("_id", 1) // 프로젝션을 위한 도큐먼트
                    .append("title", 1)
                    .append("pageCount", 1);

            Document query = new Document("pageCount", new Document("$gt", 300)); // 쿼리를 위한 도큐먼트
					  
            MongoCursor<Document> cursor = collection.find(query)
                            .projection(projection)
                            .sort(Sorts.descending("pageCount"))
                            .iterator();

            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
            
        } catch (Exception e) {
            // log.error("Exception", e);
        }
    }
}
```

```
{"_id": 30, "title": "jQuery in Action, Second Edition", "pageCount": 488}
{"_id": 279, "title": "SCBCD Exam Study Kit", "pageCount": 488}
{"_id": 39, "title": "Graphics File Formats", "pageCount": 484}
{"_id": 25, "title": "JSTL in Action", "pageCount": 480}
...생략
{"_id": 64, "title": "Data Munging with Perl", "pageCount": 304}
{"_id": 198, "title": "SharePoint 2007 Developer's Guide to Business Data Catalog", "pageCount": 304}
{"_id": 243, "title": "Explorer's Guide to the Semantic Web", "pageCount": 304}
{"_id": {"$oid": "53c2ae8528d75d572c06adb3"}, "title": "J2EE and XML Development", "pageCount": 304}
```

* `find()`는 `FindIterable` 객체 반환
  * `FindIterable`은 `MongoIterable`의 자손
* `iterator()`는 `MongoCursor` 객체 반환

<br>

---

### 7.2 MongoDB에서 POJO 클래스 

POJO 클래스를 사용하면, 프로그래밍적 스키마를 도큐먼트에 그대로 사용할 수 있다. 쉽게 이야기 해서 POJO 클래스를 컬렉션의 도큐먼트에 바로 매핑해서 사용할 수 있다.

공식 문서 : [https://www.mongodb.com/docs/drivers/java/sync/current/fundamentals/data-formats/document-data-format-pojo/](https://www.mongodb.com/docs/drivers/java/sync/current/fundamentals/data-formats/document-data-format-pojo/)

<br>

POJO를 사용하기 위해서는 이를 해석할 수 있는 코덱을 설정해줘야한다.

`예시`

```java
CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(),fromProviders(pojoCodecProvider));

MongoClient mongoClient = MongoClients.create(uri);
MongoDatabase database = mongoClient.getDatabase("sample_pojos").withCodecRegistry(pojoCodecRegistry);
```

* `sample_pojos`라는 데이터베이스에 `pojoCodecRegistry`를 설정

<br>

이후에는 사용할 POJO 클래스를 `MongoCollection` 객체의 타입으로 지정하고, `getCollection()`의 도큐먼트 클래스 인자로 전달해서 사용한다.

`예시`

```java
MongoCollection<MyPOJO> collection = database.getCollection("mypojos", MyPOJO.class);
```

<br>

---

### 7.3 POJO 클래스 사용하기

#### 7.3.1 POJO 클래스 만들기

그러면 이제 POJO 클래스를 만들어보고, POJO 클래스를 사용해서 다양한 CRUD 작업을 해보자.

<br>

`domain/Movies`

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movies {
    @BsonId
    ObjectId _id;
    String title;
    String genre;
    Integer price;
    // @BsonProperty("contents") : 데이터베이스상의 이름과 달라도 매핑 가능
    String description;
    LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "Movies{" +
                "_id=" + _id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
```

* `_id`를 위한 필드는 `@BsonId` 사용

<br>

몽고DB에 연결하기 위한 코드를 추출해서 유틸로 구현하자.

`dbutil/MongoConnectionUtil`

```java
@Slf4j
public class MongoConnectionUtil {
    private static final String HOST = MongoDBPropertiesLoader.getHost();
    private static final String PORT = MongoDBPropertiesLoader.getPort();
    private static final String USERNAME = MongoDBPropertiesLoader.getUsername();
    private static final String PASSWORD = MongoDBPropertiesLoader.getPassword();

    public static MongoClient getConnection() {
        String URI = "mongodb://"+USERNAME+":"+PASSWORD+"@" +HOST+":"+PORT;

        try {
            return MongoClients.create(URI);
        } catch (Exception e) {
            log.error("Failed to connect to MongoDB", e);
            throw new RuntimeException("Failed to connect to MongoDB", e);
        }
    }
}
```

<br>

---

#### 7.3.2 도큐먼트 생성

POJO 클래스 `Movies`를 이용해서 `movies`라는 컬렉션에 도큐먼트들을 생성해보자.

`CreateDocuments`

```java
public class CreateDocuments {
    public static void main(String[] args) {

        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(),fromProviders(pojoCodecProvider));

        try(MongoClient mongoClient = MongoConnectionUtil.getConnection()) {
            MongoDatabase database = mongoClient.getDatabase("shop").withCodecRegistry(pojoCodecRegistry);

            MongoCollection<Movies> moviesCollection = database.getCollection("movies", Movies.class);
            // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            List<Movies> movies = new ArrayList<>();
            movies.add(new Movies(null, "The Nexus Protocol", "Sci-Fi", 12000,
                    "Summary comes here!", LocalDateTime.now()));
            movies.add(new Movies(null, "Quantum Dawn", "Sci-Fi", 9000,
                    "Summary comes here!", LocalDateTime.now()));
            movies.add(new Movies(null, "Shadow Protocol", "Sci-Fi", 12000,
                    "Summary comes here!", LocalDateTime.now()));
            movies.add(new Movies(null, "Midnight Echo", "Mystery", 10000,
                    "Summary comes here!", LocalDateTime.now()));
            movies.add(new Movies(null, "Code Breaker", "Thriller", 15000,
                    "Summary comes here!", LocalDateTime.now()));
            movies.add(new Movies(null, "Celestial Odyssey", "Adventure", 28000,
                    "Summary comes here!", LocalDateTime.now()));
            movies.add(new Movies(null, "Echoes of Tomorrow", "Drama", 9000,
                    "Summary comes here!", LocalDateTime.now()));
            movies.add(new Movies(null, "The Last Stand", "Action", 9000,
                    "Summary comes here!", LocalDateTime.now()));
            movies.add(new Movies(null, "Red Horizon", "Adventure", 5000,
                    "Summary comes here!", LocalDateTime.now()));

            moviesCollection.insertMany(movies);

        }
    }
}
```

* 이전에도 설명했던 것 처럼 POJO를 사용하기 위한 코덱이 필요하다
* `insertMany()`를 이용해서 다수의 도큐먼트를 생성한다

<br>

데이터베이스를 확인해보면 도큐먼트들이 정상적으로 생성이 된것을 확인할 수 있다.(`MongoExpress`를 한번 써봤다)

<br>

<p align="center">   <img src="img/pojo1.png" alt="nosql2" style="width: 100%;"> </p>

<br>

---

#### 7.3.3 도큐먼트 조회

도큐먼트를 조회해보자.

`ReadMain`

```java
public class ReadMain {
    public static void main(String[] args) {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(),fromProviders(pojoCodecProvider));

        try(MongoClient mongoClient = MongoConnectionUtil.getConnection()) {
            MongoDatabase database = mongoClient.getDatabase("shop").withCodecRegistry(pojoCodecRegistry);

            MongoCollection<Movies> moviesCollection = database.getCollection("movies", Movies.class);

            // 1. 커서를 이용해서 조회
            MongoCursor<Movies> cursor = moviesCollection.find().cursor();
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }

            // 2. 필터를 통한 조회 조건 설정
            cursor = moviesCollection.find(eq("price", 9000)).cursor(); // price가 9000인 경우만 필터링
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }

            // 3. projection으로 원하는 필드만 가져오기

            // projection이라는 도큐먼트를 생성해서 사용하지 않고 Projections.fields(include()) 사용
            Document projection = new Document("title", 1)
                    .append("genre", 1)
                    .append("price", 1);

            cursor = moviesCollection.find()
                    .projection(Projections.fields(Projections.include("title", "genre", "price")))
                    .sort(Sorts.descending("price")) // price를 기준으로 내림차순 정렬
                    .limit(5) // 첫 5개의 결과만 가져온다
                    .cursor();
						
            while (cursor.hasNext()) {
                Movies doc = cursor.next();

                System.out.println("Title: " + doc.getTitle());
                System.out.println("Genre: " + doc.getGenre());
                System.out.println("Price: " + doc.getPrice());
                System.out.println("-------------------------");

            }
        }
    }
}
```

<br>

이외에도 몽공DB 매뉴얼을 참고해서 자바에서 업데이트와 삭제하는 방법과 `aggregation pipeline`을 사용하는 방법도 알아보자. 

<br>

---

## Further Reading

* Read concern
* Write concern
* MongoDB에서의 Atomic Operation
* MongoDB에서의 [Transaction](https://www.mongodb.com/docs/manual/core/transactions/)
* [Sharding](https://www.mongodb.com/docs/manual/sharding/)과 [Replication](https://www.mongodb.com/docs/manual/replication/) 방법

---

## Reference

1. [https://www.mongodb.com/developer/products/mongodb/mongodb-schema-design-best-practices/](https://www.mongodb.com/developer/products/mongodb/mongodb-schema-design-best-practices/)
2. [https://www.mongodb.com/docs/manual/core/schema-validation/](https://www.mongodb.com/docs/manual/core/schema-validation/)
