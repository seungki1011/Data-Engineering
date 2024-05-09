> NoSQL의 등장 배경, MongoDB 사용

---

## Index









---

## 1) NoSQL(Not Only SQL)

### 1.1 NoSQL 소개

NoSQL을 설명하기 전에 NoSQL이 등장하게 된 배경부터 살펴보자.

먼저 기존 SQL 데이터베이스(관계형 데이터베이스)의 한계에 대해서 살펴보자.

<br>

#### 1.1.1 관계형 데이터베이스의 단점

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

 #### 1.1.2 NoSQL 등장 배경

소셜 미디어 플랫폼들이 등장하면서 데이터베이스들은 높은 처리량(high-throughput)과 낮은 지연시간(low-latency), 등이 요구되었다. 

또한 기존의 정형 데이터가 아닌 비정형, 반정형 데이터가 많아지면서, 관계형 데이터베이스(SQL Database)가 다루지 못하는 영역까지 다룰 수 있는 NoSQL(Not only SQL) 데이터베이스가 등장하게 된다.

정리해서 이야기 하자면 다양항 데이터 유형의 등장, 빅데이터, 대용량 트래픽을 다루는 웹 및 모바일 애플리케이션의 등장에 맞춰서 NoSQL은 확장성, 성능, 사용 편의성으로 인해 인기를 얻기 시작했다. NoSQL은 기존의 정형화된 데이터베이스 구조를 따르지 않으며, 데이터 쿼리에 SQL만을 사용하지 않는다.

<br>

---

#### 1.1.3 NoSQL 분류 및 특징

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
  * 몽고DB는 기본적으로 도큐먼트의 스키마에 제약이 없지만, 컬렉션 단위에서 도큐먼트들이 같은 필드, 데이터 타입을 이용하도록 제약을 걸 수 있다 
  * Schema Validation을 사용하지 않더라고 애플리케이션 레벨에서 스키마 규칙을 프로그래밍적 모델로 가지고 있는 것이 좋다
  * `db.createCollection("user")` 같은 형태로 컬렉션 생성



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
* 몽고DB의 Polymorphism 검색!

<br>

<p align="center">   <img src="img/mongodb4.png" alt="nosql2" style="width: 100%;"> </p>

<p align="center">MongoDB는 데이터 중복 허용</p>

* 기존의 RDBMS는 `Product`, `User`, `Order` 테이블을 쪼개서 중복이 없도록 설계하고, 이후 `JOIN`을 통해서 필요한 데이터를 조회한다
* 반면 NoSQL 데이터베이스인 몽고DB에서는 중복된 데이터를 저장해도 상관없다는 접근을 사용한다
  * 한 번 읽을 때 필요한 모든 데이터를 다 저장해놓기 때문에, 굳이 `JOIN`을 사용하지 않아도 된다
  * `JOIN`을 사용하지 않기 때문에 과도한 `JOIN` 수행으로 인한 성능 오버헤드를 방지할 수 있다



* 데이터 중복 허용을 통한 `JOIN` 필요성을 제거하는 대신, 애플리케이션 레벨에서 데이터들이 모두 최신 상태를 유지할 수 있도록 관리해야한다
* 도큐먼트에서 필드 안의 필드 같은 중첩(nested)된 형태로 데이터를 저장하는 것이 가능하다. 그러나 이 경우 데이터 저장, 검색, 집계 과정에서 속도가 느려질 가능성이 있다. 물론 데이터가 적을때는 큰 차이가 없지만, 데이터가 많아지면 성능이 떨어질 수 있기 때문에 유의해서 스키마를 설계하자

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

## 3) MongoDB 사용하기 - 1(CRUD)

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

#### 3.4.2 Embedded(Nested) Document

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



* 반환한 커서를 `var` 키워드를 이용해서 변수에 할당하지 않을 경우 몽고쉘(`mongosh`)에서 자동으로 `20`번 iterate 해서, 첫 `20` 도큐먼트를 결과로 출력하도록 설정 되어있다



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

<br>

---

#### 3.7.3 모든 도큐먼트 조회

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

* 예시의 경우 `find()`에 빈 쿼리를 사용했다. 이 경우 컬렉션의 모든 도큐먼트를 조회한다. 이 도큐먼트가 굉장히 많은 경우 모든 더큐먼트를 조회하면 서버에 부담이 될 수 있기 때문에 몽고DB는 조회할 수 있는 도큐먼트 수를 20으로 제한했다. `it`을 누르면 해당하는 도큐먼트들을 더 볼 수 있다.

  

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

#### 3.7.5 쿼리 오퍼레이터를 이용한 조건으로 도큐먼트 조회

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

#### 3.7.7 :star: ​`find()`와 cursor

**지금까지 `find()`를 사용해서 도큐먼트를 조회했지만, `find()`는 도큐먼트를 반환하는 메서드가 아니다!** 이전에도 설명했지만, `find()`는 **커서(cursor)**를 반환한다. `mongosh`(몽고쉘)에서는 반환한 커서를 `var` 키워드를 이용해서 변수에 할당하지 않을 경우 몽고쉘(`mongosh`)에서 자동으로 `20`번 iterate 해서, 첫 `20` 도큐먼트를 결과로 출력하도록 설정 되어있다.

<br>

그러면 커서를 매뉴얼하게 iterate하는 방법에 대해서 알아보자.





















